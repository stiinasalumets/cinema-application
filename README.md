# Cinema Application

### This is the documentation for the cinema application. This application assumes the following things:

* The cinema galleries in this theater have 77 seats in a grid of 7x11, since that is assumed to be the average
  size of movie theaters
* Any time a session is created a random number of seats will be occupied
* The user wants to be seated to the closest available seat from the middle most seat
* This application doesn't handle authentication, so the application initializer is hardcoded in a state where a there
  is a logged-in user with info on the movies they have watched

### I am missing the filtering and choose seat function, here is how I was planning to solve them:

#### Filtering

* For filtering I was planning on creating a controller function that based on the filters it is provided, will do a 
database query that returns all the movies that fulfill the requirements
* In the frontend application that is solved by creating a search button, that triggers the controller and reloads the 
page with the given information

#### Choosing seat

* For choosing the seat, I currently have just the hardcoded grid of seats and the plan was to in each cell, find the 
corresponding seat and displaying whether it was occupied or not
* For recommending seats there was a plan of choosing the first seat with the lowest weight and if there were more than 
one seat needed, it would check if the seat next to it would be available as well