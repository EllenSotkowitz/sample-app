#### At a high level, how does your app work?
The user can enter a string and the app performs a search on OMDB for movies whose titles 
contain the string. The request to OMDB is performed using Volley HTTP and the response is parsed 
using GSON.

The movie poster and title for movies found in the search are displayed in a RecyclerView.
#### How would we extend your app if we had to add functionality?
Initial version of the UI is just MainActivity.  Refactoring would be recommended if additional UI
functionality were to be added.

To add a new OMDB request a class could be added that extends OmdbRequest. (See SearchRequest.)  Again, 
the initial code could use some refactoring, but the general idea is a base class for requests that 
can be extended to add different kinds of requests.  

Data classes similar to MovieData can be added.  The data classes have fields that correspond to the 
fields in the JSON data so they can be parsed using GSON.
#### What documentation, websites, papers, etc. did you consult for this assignment?

* http://omdbapi.com/
* https://developer.android.com/reference/android/support/v7/widget/RecyclerView.html
* https://developer.android.com/reference/android/support/v7/widget/RecyclerView.Adapter.html
* https://developer.android.com/training/volley/index.html
* https://google.github.io/gson/apidocs/com/google/gson/Gson.html
#### What third-party libraries or other tools does your application use? How did you choose each library or framework you used?
* com.android.support:appcompat - Supports the app on different versions of android.
* com.android.support:recyclerview - A flexible view for providing a limited window into a large data set.
* com.android.volley:volley - HTTP library used for network requests.
* com.google.code.gson:gson - Used to parse JSON data returned by OMDB.  Could also be used to convert 
data to JSON if it is necessary to send JSON data to a server.
#### How long did you spend on this exercise? 
Spent around 3-4 hours (spread out over 2 days with some interruptions).
#### If you had unlimited time to spend on this, how would you spend it and how would you prioritize each item?
* Priority 1 - The initial version of the app only displays the first page of results.  One thing I would add
ASAP would be a way to show additional pages of results.  Buttons could be added at the top and 
bottom of the list to get the next page or previous page, or paging could be done as the
user scrolls through the list.
* Priority 2 - App should handle end of editing in the text field (i.e. start the search when user 
types Enter in the text field, not just when they click the Search button).
* Priority 3 - The UI design uses Theme.AppCompat.Light.DarkActionBar (inherited from HelloWorld app).  I would 
update to use material design.
* Priority 4 - Initial version shows the movie posters in the UI at the size and shape that is returned by OMDB.  The 
poster images returned by OMDB are not all the same size and shape.  I would update the UI to handle this better.
* Priority 5 - I would add functionality so that the user could click on an  item in the list and the app would get
the details of the selected movie from OMDB and show a new screen with those details.
#### If you were going to implement a level of automated testing to prepare this for a production environment, how would you go about doing so?
I would probably recommend some combination of junit testing and UI testing (eg. espresso) so that 
both the UI and underlying functionality could be tested.