The user can enter a string and the app performs a search on OMDB for movies whose titles 
contain the string. The request to OMDB is performed using Volley HTTP and the response is parsed 
using GSON.

The movie poster and title for movies found in the search are displayed.

Changes I sould make if I spent more time on this app:

* 1 - The initial version of the app only displays the first page of results.  First thing I would add
would be a way to show additional pages of results.  Buttons could be added at the top and 
bottom of the list to get the next page or previous page, or paging could be done as the
user scrolls through the list.
* 2 - App should handle end of editing in the text field (i.e. start the search when user 
types Enter in the text field, not just when they click the Search button).
* 3 - The UI design uses Theme.AppCompat.Light.DarkActionBar (inherited from HelloWorld app).  I would 
update to use material design.
* 4 - Initial version shows the movie posters in the UI at the size and shape that is returned by OMDB.  The 
poster images returned by OMDB are not all the same size and shape.  I would update the UI to handle this better.
* 5 - I would add functionality so that the user could click on an  item in the list and the app would get
the details of the selected movie from OMDB and show a new screen with those details.
