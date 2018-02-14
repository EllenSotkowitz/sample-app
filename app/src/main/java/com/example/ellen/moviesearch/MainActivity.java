package com.example.ellen.moviesearch;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static String TAG = MainActivity.class.getName();
    private RecyclerView mRecyclerView;
    private MovieListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,
                LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        mAdapter = new MovieListAdapter();
        mRecyclerView.setAdapter(mAdapter);

        final EditText searchEditText = findViewById(R.id.search_text);

        Button mSearchButton = findViewById(R.id.search_button);

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchText = searchEditText.getText().toString();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
                SearchRequest request = new SearchRequest(searchText,
                        new SearchRequest.Listener() {
                            @Override
                            public void onResponse(List<MovieData> movieDataList) {
                                mRecyclerView.removeAllViews();
                                mAdapter.setDataList(movieDataList);
                            }
                        },
                new SearchRequest.ErrorListener() {
                            @Override
                            public void onErrorResponse(Exception error) {
                                Log.e(TAG, error.getMessage());
                            }
                        });
                RequestQueue queue = RequestQueue.getInstance(getApplicationContext());
                request.addToQueue(queue);
            }
        });

    }
}
