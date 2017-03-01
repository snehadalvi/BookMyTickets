Project Title: Online Movie Ticket Booking System (BookMyTickets)
		- Database Systems Final Project

Created by: Sneha Dalvi, Osman Ali, Jiajun Xu, Anuja Jadhav

**************************************************************************

Summary:
This system has following functionalities
1. Registration
2. Login
3. Search shows by movie or theatre
4. Select an available show
5. Pay and book tickets online
6. Logout

Please refer to "bookmytickets2.ppt" for UML Class Diagram, Relational Model, BCNF decompostion, 3NF synthesis and System Architecture.

Technology used:
Struts 2.0
Apache Tomcat 7
PostgreSQL
JDBC
jQuery/Javascript
JSP, HTML

*******************************************************************************

Steps to run the project:

1. Import the project in Eclipse and configure build path if necessary.

2. Create database called "bms" in Postgresql and Run "Database Schema.sql" located in the project folder.
We used following credentials for database connection.
Username: postgres
Password: sneha@212
If you want to use your database credentials, please change the credentials in "com.bms.dao.DBConnection.java" line number 25.

3. Run the project on Apache Tomcat 7 server

4. On login page, click on Registration to create new user.
   (You can search shows without login, but you will have to login to the system if you want to book tickets as well.)

5. Enter new user details and click on "Register" button.
   (The form checks for existing username)

6. Login with the new user credentials.

7. Click on Search Shows link of welcome page.

8. Select a movie or theatre from the given drop-down box and click on "Search" button.
   This will display the results depending on the search criteria.
   If no movie or theatre is selected, it will show a message "No available show.."

9. Select a particular show by clicking on "Book" link to book tickets for that show.
   (In this case, if you are not logged in then it will redirect to login page.)

10. On booking page, select number of tickets and mode of payment. 
    The total cost is calculated dynamically (using jquery) as price multiplied by number of tickets.
    If number of tickets entered are more than availablity, then an error message is displayed.

11. Once clicked on "Pay and book tickets", the booking summary is displayed in successful scenario.

12. Then click on "Logout" to clear your session.

***********************************************************************