# Cinema Application

This is the documentation for the cinema application. This application assumes the following things:

* The cinema galleries in this theater have 77 seats in a grid of 11x21, since that is assumed to be the average
  size of movie theaters
* Any time a session is created a random number of seats will be occupied
* The user wants to be seated to the closest available seat from the middle most seat
* This application doesn't handle authentication, so the application initializer is hardcoded in a state where a there
  is a logged-in user with info on the movies they have watched