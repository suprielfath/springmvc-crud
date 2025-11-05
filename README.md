# mylibrary

A complete example for Spring MVC + Maven + Hibernate CRUD operation + mysql

# Database Setup

The application is configured to connect to a MySQL database. The configuration can be found in `src/main/resources/database.properties`.

-   **Database Name:** `mylibrary`
-   **Username:** `root`
-   **Password:** `admin`

The application is set to automatically create the database (`createDatabaseIfNotExist=true`) on first run if it does not exist. However, you must ensure that the user (`root`) has the necessary privileges to create a new database on your MySQL server.

If your local MySQL credentials are different, please update the `database.properties` file before running the application.

# Running the Application

1.  Open a Command Prompt or Terminal.
2.  Navigate to the root project directory.
3.  Run the following Maven command to start the application using an embedded Tomcat server:

    ```
    mvn clean tomcat7:run
    ```

4.  Open your web browser and go to the following URL:

    ```
    http://localhost:8080/mylibrary/book/
    ```

The port number might be different in your case. Please check the Tomcat log in your console for the correct port.