To run the application following steps need to be made:
1. Clone the git repository
2. Execute: 
-     ./mvnw clean package -DskipTests
-     docker build -t polls-docker-image .
-     docker-compose up --remove-orphans

For preparing a database:
1. Save the json file from https://boiling-tor-31289.herokuapp.com/users/me/polls locally as polls.json
2. Execute: 
-     docker run -p 27017:27017 -d mongo 
-     docker exec -it <container-name-or-id> bash
-     docker cp polls.json <container-name-or-id>:/tmp/polls.json
-     mongoimport --db test --collection polls --file /tmp/polls.json --jsonArray
     
Following the requirements it was not difficult to come to conclusion that the Mongo db would be the ideal choice.
Building a database model would be more complicated in any object-relational DB. For the REST Api itself
Spring Boot was the logical choice because of the simplicity.
This is just a very simple API, next steps should be improved logging and exception handling.
Personally it was challenging because of my luck of expierence working with NoSQL database, and also
also not being enough versatile in writing the scripts for running Docker containers, 
so I have spent more time than I would anticipate. However I would still stick to this technology choices.
