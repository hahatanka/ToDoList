
import file.WriteToFile;
import jdk.swing.interop.SwingInterOpUtils;
import userTask.Task;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    ToDoList annaToDo = new ToDoList();
    String filePath = "/Users/rudens/Desktop/ToDo2.txt";
    String userChoice;
    File file = new File("/Users/rudens/Desktop/ToDo2.txt");


    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.Menu();

    }

    public void Menu() throws Exception {

        do {
            String[] choices = {"Select...", "1", "2", "3", "4", "5", "6", "Exit"};
            userChoice = (String) JOptionPane.showInputDialog(null, "Welcome to the ToDo List! Please chose what you want to do:" +
                            "\n 1. Add a task" +
                            "\n 2. View your to-do list" +
                            "\n 3. Search and Edit a task" +
                            "\n 4. Delete a task" +
                            "\n 5. See pending tasks" +
                            "\n 6. See completed tasks" +
                            "\nExit",
                    "MENU",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    choices,
                    choices[0]);

            switch (userChoice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    viewAllTasks();
                    break;
                case "3":
                    searchEditTask();
                    break;
                case "4":
                    deleteTask();
                    break;
                case "5":
                    pendingTasks();
                    break;
                case "6":
                    completedTasks();
                    break;
            }

        } while (userChoice != "Exit");
    }

    public void addTask() throws Exception {
        String name = JOptionPane.showInputDialog(null, "Adding a new task.." + "\nPlease enter the name of the task");
        String date = JOptionPane.showInputDialog(null, "Adding a new task.." + "Please enter the due date of the task");
        String comment = JOptionPane.showInputDialog(null, "Adding a new task.." + "Please enter a comment ");
        String[] statuses = {"Select...", "COMPLETED", "NOT COMPLETED"};
        userChoice = (String) JOptionPane.showInputDialog(null, "Please chose the status", "CHOOSE",
                JOptionPane.QUESTION_MESSAGE, null, statuses, statuses[0]);
        Task task = new Task(name, date, comment, userChoice);
        annaToDo.addTaskNames(name);
        JOptionPane.showMessageDialog(null, annaToDo.addTask(task));
        WriteToFile.SaveTask(name, date, comment, userChoice, filePath);
    }

    public void viewAllTasks() {
//        for (Task tasks : annaToDo.getAllTasks()) {
        ArrayList<String> list = WriteToFile.viewRecords(file);
        JOptionPane.showMessageDialog(null, list);
        //JOptionPane.showMessageDialog(null,"Name: " + "\n" + tasks.getName() + "\nDeadline: " + tasks.getDeadline() + "\nComment: " + tasks.getNote() + "\nStatus: " + tasks.getStatus() + "\n------------------------------");
//        }

    }

    public void searchEditTask() {
        String name = JOptionPane.showInputDialog(null, "Enter the name here: ");
        try {

            Task task = annaToDo.findTask(name);
            WriteToFile.searchRecord(name, file, task.getName(), task.getDeadline(), task.getNote(), task.getStatus());
            String[] choices = {"YES", "NO"};
            userChoice = (String) JOptionPane.showInputDialog(null, "Do you want to edit this task? Please chose YES or NO here", "CHOOSE",
                    JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);

            switch (userChoice) {
                case "YES":
                    do {
                        String[] choices1 = {"name", "deadline", "comment", "status", "EXIT"};
                        userChoice = (String) JOptionPane.showInputDialog(null, "Please chose what you want to change", "CHOOSE",
                                JOptionPane.QUESTION_MESSAGE, null, choices1, choices1[0]);

                        switch (userChoice) {
                            case "name":
                                String newName = JOptionPane.showInputDialog(null, "\nPlease enter the new name of the task");
                                task.setName(newName);
                                break;
                            case "deadline":
                                String newDeadline = JOptionPane.showInputDialog(null, "\nPlease enter the new deadline of the task");
                                task.setDeadline(newDeadline);
                                break;
                            case "comment":
                                String newComment = JOptionPane.showInputDialog(null, "\nPlease enter the new comment of the task");
                                task.setNote(newComment);
                                break;
                            case "status":
                                String[] statuses = {"Select...", "COMPLETED", "NOT COMPLETED"};
                                userChoice = (String) JOptionPane.showInputDialog(null, "Please chose the status", "CHOOSE",
                                        JOptionPane.QUESTION_MESSAGE, null, statuses, statuses[0]);
                                task.setStatus(userChoice);
                                break;
                        }
                    } while (!userChoice.equals("EXIT"));
                case "NO":
                    break;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }
    }

    public void deleteTask() {
        ArrayList taskNames = annaToDo.getTaskNames();
        String exit = "Exit";
        taskNames.add(exit);
        Object[] choices = taskNames.toArray();
        userChoice = (String) JOptionPane.showInputDialog(null, "Please chose a task", "CHOOSE",
                JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);

        do {
            Task task =  annaToDo.findTask(userChoice);
            if (task.getStatus().equalsIgnoreCase("completed")) {
                annaToDo.removeCompletedTask(task);
                JOptionPane.showMessageDialog(null, annaToDo.removeTask(task));
            } else
                annaToDo.removePendingTask(task);
            JOptionPane.showMessageDialog(null, annaToDo.removeTask(task));

        }while (userChoice != exit);

        }



    public void pendingTasks(){

        JOptionPane.showMessageDialog(null,"Pending tasks: " + annaToDo.getPendingTasks(), "LOOK", 3);
//        System.out.println("Tasks pending: ");
//        System.out.println(annaToDo.getPendingTasks());
    }
    public void completedTasks(){
        JOptionPane.showMessageDialog(null,"Completed tasks: " + annaToDo.getPendingTasks(), "LOOK", 3);

//        System.out.println("Tasks completed: ");
//        System.out.println(annaToDo.getCompletedTasks());
    }
}



