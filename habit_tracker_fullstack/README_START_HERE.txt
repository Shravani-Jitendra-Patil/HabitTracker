ADVANCED HABIT TRACKER PROJECT
==============================

This project has 2 parts:
1. backend  -> Spring Boot + MySQL
2. frontend -> Angular

FEATURES
--------
- Add habit
- Edit habit
- Delete habit
- Mark today as done/pending
- Dashboard summary
- Streak count
- Category and description

====================================================
PART 1: WHAT YOU NEED TO INSTALL FIRST
====================================================

1. JAVA JDK 21
   Download and install JDK 21.
   After install, open Command Prompt and check:
       java -version
       javac -version

2. MAVEN
   Download Apache Maven and set PATH.
   Check:
       mvn -version

3. MYSQL SERVER + MYSQL WORKBENCH
   Install MySQL.
   Remember your username and password.
   In this project default username and password are:
       username = root
       password = root

   If your MySQL password is different, change it in:
       backend/src/main/resources/application.properties

4. NODE.JS (LTS)
   Install Node.js.
   Check:
       node -v
       npm -v

5. ANGULAR CLI
   Open Command Prompt and run:
       npm install -g @angular/cli
   Check:
       ng version

6. VS CODE OR STS / INTELLIJ
   You can open this project in VS Code.

====================================================
PART 2: EXTRACT AND OPEN PROJECT
====================================================

1. Extract the ZIP file.
2. Open the main folder habit_tracker_fullstack.
3. Inside it you will see:
       backend
       frontend
       README_START_HERE.txt

====================================================
PART 3: DATABASE SETUP
====================================================

OPTION A (EASIEST)
Spring Boot will create the database automatically if MySQL is running.
You only need to make sure MySQL server is ON.

OPTION B (MANUAL)
Open MySQL Workbench and run backend/schema.sql

====================================================
PART 4: RUN BACKEND
====================================================

1. Open terminal in the backend folder.
2. Run these commands:
       mvn clean install
       mvn spring-boot:run

3. Backend will start at:
       http://localhost:8080

IMPORTANT:
If Maven downloads dependencies for the first time, it may take some time.

IF YOU GET DATABASE LOGIN ERROR:
Open file:
       backend/src/main/resources/application.properties
Change these 2 lines according to your MySQL:
       spring.datasource.username=root
       spring.datasource.password=root

====================================================
PART 5: RUN FRONTEND
====================================================

1. Open a NEW terminal in the frontend folder.
2. Run these commands:
       npm install
       ng serve --open

3. Frontend will start at:
       http://localhost:4200

====================================================
PART 6: HOW TO USE THE PROJECT
====================================================

1. Add a new habit using the form.
2. See all habits in the habit list.
3. Click Mark Done / Mark Pending.
4. Click Edit to update the habit.
5. Click Delete to remove the habit.
6. Dashboard shows:
       - Total habits
       - Completed today
       - Pending today

====================================================
PART 7: IF SOMETHING DOES NOT WORK
====================================================

1. JAVA NOT FOUND
   Check PATH and reinstall JDK.

2. MVN NOT FOUND
   Maven PATH is not set properly.

3. NG NOT FOUND
   Run:
       npm install -g @angular/cli

4. MYSQL ACCESS DENIED
   Change database username/password in application.properties.

5. PORT 8080 ALREADY USED
   Stop other app using 8080 or change:
       server.port=8080
   to another port in application.properties

6. PORT 4200 ALREADY USED
   Run frontend like this:
       ng serve --port 4300 --open

7. CORS ERROR
   Make sure backend is running on 8080 and frontend on 4200.

====================================================
PART 8: PROJECT STRUCTURE
====================================================

backend/src/main/java/com/example/habittracker
    controller
    dto
    model
    repository
    service

frontend/src/app
    components
    models
    services

====================================================
PART 9: MAIN TECHNOLOGIES USED
====================================================

Frontend:
- HTML
- CSS
- TypeScript
- Angular

Backend:
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- JDBC Driver (MySQL)

Database:
- MySQL

====================================================
PART 10: VERY IMPORTANT NOTE
====================================================

Keep BOTH running at the same time:
- backend terminal
- frontend terminal

If backend stops, frontend will show error while loading data.
