

import userTask.Task;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;


public class ToDoList extends Task {
    public final ArrayList<Task> allTasks = new ArrayList<>();
    ArrayList<Task> completedTasks = new ArrayList<>();
    ArrayList<Task> pendingTasks = new ArrayList<>();
    ArrayList<String> taskNames = new ArrayList<>();


    public ArrayList<Task> getAllTasks() {
        return allTasks;
    }

    public ArrayList<Task> getCompletedTasks() {
        return completedTasks;
    }

    public ArrayList<Task> getPendingTasks() {
        return pendingTasks;
    }

    public void addTaskNames(String name){
        this.taskNames.add(name);
    }

    public ArrayList<String> getTaskNames() {
        return taskNames;
    }

    String addTask(Task task) throws Exception {
        if (validateTask(task))
            if (task.getStatus().equalsIgnoreCase("COMPLETED")) {
                this.completedTasks.add(task);
                this.allTasks.add(task);


            } else if (task.getStatus().equalsIgnoreCase("NOT COMPLETED")) {
                this.pendingTasks.add(task);
                this.allTasks.add(task);

                return "Task added successfully";
            } else {
                return "Invalid answer, please choose COMPLETED or NOT COMPLETED";
            }

        return "Returning to the main menu..";
    }

    private boolean validateTask(Task task) throws Exception {
        if (task.getName() == null) {
            throw new Exception("please write the name");
        }
        if (task.getDeadline() == null) {
            throw new Exception("please provide a valid date");
        }
        if (task.getNote() == null) {
            throw new Exception("please provide a comment");
        }
        return true;
    }

    public Task findTask(String name) {
            for (Task task : allTasks) {
                if (Objects.equals(task.getName(), name))
                    return task;
            }

        return null;
    }

    public String removeTask(Task task) {
        try {
            allTasks.remove(task);
        } catch (Exception ex) {
            return "Unable to remove specified task";
        }
        return "task removed successfully";
    }

    public String removeCompletedTask(Task task) {
        try {
            completedTasks.remove(task);
        } catch (Exception ex) {
            return "Unable to remove specified task";
        }
        return "task removed successfully";
    }
    public String removePendingTask(Task task) {
        try {
            pendingTasks.remove(task);
        } catch (Exception ex) {
            return "Unable to remove specified task";
        }
        return "task removed successfully";
    }

    public String editTaskName (String newName){
        Task task = new Task();
        task.setName(newName);
        return "Task name has been changed to " + newName;
    }

    public String editTaskDeadline (String newDeadline){
        Task task = new Task();
        task.setDeadline(newDeadline);
        return "Task deadline has been changed to " + newDeadline;
    }
    public String editTaskComment (String newComment){
        Task task = new Task();
        task.setDeadline(newComment);
        return "Task comment has been changed to " + newComment;
    }
    public String editTaskStatus(String newStatus){
        Task task = new Task();
        task.setDeadline(newStatus);
        return "Task comment has been changed to " + newStatus;
    }

    @Override
    public String toString() {
        return "ToDoList{" +
                "taskNames=" + taskNames +
                '}';
    }
}







