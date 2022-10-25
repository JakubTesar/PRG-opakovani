package cz.educanet.TodoList;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.ArrayList;

@Named
@ApplicationScoped

public class todoList {
    private String taskName;
    private ArrayList<String> tasks = new ArrayList<>();
    private ArrayList<String> doneTasks = new ArrayList<>();

    public void addTask(String taskName){
        tasks.add(taskName);
    }
    public void markAsFinish(int taskID){
        doneTasks.add(tasks.get(taskID));
        tasks.remove(taskID);
    }
    public void deleteTask(int taskID){
        doneTasks.remove(taskID);
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public ArrayList<String> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<String> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<String> getDoneTasks() {
        return doneTasks;
    }

    public void setDoneTasks(ArrayList<String> doneTasks) {
        this.doneTasks = doneTasks;
    }
}
