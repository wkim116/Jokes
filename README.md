# MVC Web Front-end for Jokes database
This repository is setup with everything it needs to talk to a local postgres database. The "R" in "CRUD" is provided for you. You will need to finish the rest of the CRUD functions.

**This will work with your existing jokes database**

- Fork and then clone this repository
- Open Project in Spring Tool Suite
- Either Run from STS or from the command line with `./mvnw spring-boot:run`
- open http://localhost:8080 
- You shuold see some sample jokes.

## Complete and Satisfactory

- In `src/main/resources/templates` modify the read.html to diplay the jokes in a table with columns that represent the joke, punchline, and rating.
- Using your calculator and what you know about Spring MVC as inspiration, Create a new page that creates a new joke.
- If you succesfully created a new joke you should see it in the database as well as when viewing the read page at http://localhost:8080

## Exceeds Expectations

- Finish the project by completing update and delete functionality for a joke.