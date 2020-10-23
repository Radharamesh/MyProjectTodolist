# Todo list

## Project Description

The application will allow a user to create new tasks, assign them a title, due date, status(done/tobedone) and 
choose a project for that task to belong to. Once they are using the application, the user can able to show task list by date and project and the user can also able to edit, mark status as done or remove tasks. They can also save the current task list to file, and then restart the application with the former state restored.

## How to run the application : 
* Clone the repository and open it in your Intellij IDE.
* Install dependencies for JUnit5(JUnit Jupiter engine, JUnit Jupiter API from maven repository).
* Start the application by running MainMenu class.

## User Manual :

This is the Welcome message of the application with number of tasks to be done and number of tasks done.
<img src = "https://github.com/Radharamesh/MyProjectTodolist/blob/main/Screenshots/IP%20screenshots/Screenshot%202020-10-21%20at%2019.47.21.png" width = "500">

* User can add tasks, edit tasks, remove tasks, show tasks by Project and Duedate and save the tasks to file.

1. User can show tasks by typing 1.
<img src = "https://github.com/Radharamesh/MyProjectTodolist/blob/main/Screenshots/IP%20screenshots/Screenshot%202020-10-22%20at%2018.48.07.png" width = "500">

 * It will ask option to show tasks by Project or by Duedate. 
    * If User type 1 and enter, it will display tasks sorted by Project.
    * If User type 2 and enter, it will display tasks sorted by Duedate.

2. User can add tasks by typing 2.
<img src = "https://github.com/Radharamesh/MyProjectTodolist/blob/main/Screenshots/IP%20screenshots/Screenshot%202020-10-22%20at%2018.50.57.png" width = "500">

* It will ask the User to enter task title, duedate and project name, (status will automatically set as Tobedone for new tasks). 
Then it adds the task and ask the User to add another task.
  * If User wants to add another task, they should enter Y. Then it asks the user to enter task details for another task.
  * If User don't want to add another task, they should enter N. Then it dispays welcome message again to choose another action.
 
 <img src = "https://github.com/Radharamesh/MyProjectTodolist/blob/main/Screenshots/IP%20screenshots/Screenshot%202020-10-22%20at%2018.52.06.png" width = "500">
  
  
3. User can edit or remove tasks by typing 3.
<img src = "https://github.com/Radharamesh/MyProjectTodolist/blob/main/Screenshots/IP%20screenshots/Screenshot%202020-10-22%20at%2018.53.03.png" width = "1000">

* It will ask the User to type 1 for edit or type 2 for remove. 
    * If user type 1, it will display the list of tasks for the user to refer which task to edit. 
    * Then it will ask the task name. 
    * If user enters task name, then it will ask the user to type 1 for editing task name field or type 2 for editing status to mark as done.
    * If user choose 1, then it will ask the user to enter new task name to update the existing task name.
    * If user enter new task name, it will update the task and display the message as "task updated", and displays welcome message again.

<img src = "https://github.com/Radharamesh/MyProjectTodolist/blob/main/Screenshots/IP%20screenshots/Screenshot%202020-10-22%20at%2018.56.09.png" width = "1000">

 
* If user choose 2, then it will ask the user to enter true to mark status of task as done and false to mark status as to be done. If user enter status, then it will update the status and display the message as task updated, and displays welcome message again.

<img src = "https://github.com/Radharamesh/MyProjectTodolist/blob/main/Screenshots/IP%20screenshots/Screenshot%202020-10-22%20at%2018.57.50.png" width = "1000">

* If user type 2, to remove task, then it will display the list of tasks for the user to refer which task to remove.

<img src = "https://github.com/Radharamesh/MyProjectTodolist/blob/main/Screenshots/IP%20screenshots/Screenshot%202020-10-22%20at%2018.59.04.png" width = "1000">

* Then it will ask the task name.
* If user enters task name, then it will remove the task with the task name entered and display the message as task removed, and displays welcome message again.

<img src = "https://github.com/Radharamesh/MyProjectTodolist/blob/main/Screenshots/IP%20screenshots/Screenshot%202020-10-22%20at%2018.59.41.png" width = "1000">

4. User can save the tasks in a file and quit the application by typing 4.

<img src = "https://github.com/Radharamesh/MyProjectTodolist/blob/main/Screenshots/IP%20screenshots/Screenshot%202020-10-22%20at%2019.02.41.png" width = "1000">



