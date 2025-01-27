package org.todo.todolist;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class ToDoList {
    public enum Hierarchy{
        IMPORTANT(4),
        HIGH(3),
        MEDIUM(2),
        LOW(1);

        private final int order;

        Hierarchy(int order) {
            this.order = order;
        }
        public int getOrder() {
            return order;
        }
    }
    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyy");

    Hierarchy taskImportance = Hierarchy.LOW;
    String taskName;
    LocalDate deadline;

    ArrayList<Tasks> taskList = new ArrayList<>();
    ArrayList<Tasks> taskListImportance = new ArrayList<>();
    ArrayList<Activity> activityTasklist = new ArrayList<>();
    ArrayList<Events> eventsList = new ArrayList<>();
    ArrayList<ToDoList> doneList = new ArrayList<>();

    public ToDoList(){

    }

    public void addTask(Tasks task) {
        taskListImportance.add(task);
        taskList.add(task);
        Collections.sort(taskListImportance, (a, b) -> Integer.compare(b.taskImportance.getOrder(), a.taskImportance.getOrder()));

        for(int i = 0; i<taskList.size()-1; i++){
            for(int j = 0; j<taskList.size()-1 - i; j++) {
                if (!taskList.get(j).deadline.isBefore(taskList.get(j + 1).deadline)) {
                    LocalDate temp = taskList.get(j).deadline;
                    taskList.get(j).deadline = taskList.get(j + 1).deadline;
                    taskList.get(j + 1).deadline = temp;
                }
            }
        }
    }
    public void addActivity(Activity activity){
        taskListImportance.add(new Tasks(activity.taskName, activity.taskImportance, activity.deadline));
        taskList.add(new Tasks(activity.taskName, activity.taskImportance, activity.deadline));
        activityTasklist.add(activity);

        Collections.sort(taskListImportance, (a, b) -> Integer.compare(b.taskImportance.getOrder(), a.taskImportance.getOrder()));

        for(int i = 0; i<taskList.size()-1; i++){
            for(int j = 0; j<taskList.size()-1 - i; j++) {
                if (!taskList.get(j).deadline.isBefore(taskList.get(j + 1).deadline)) {
                    LocalDate temp = taskList.get(j).deadline;
                    taskList.get(j).deadline = taskList.get(j + 1).deadline;
                    taskList.get(j + 1).deadline = temp;
                }
            }
        }
    }
    public void addEvent(Events event){
        taskListImportance.add(new Tasks(event.taskName, event.taskImportance, event.deadline));
        taskList.add(new Tasks(event.taskName, event.taskImportance, event.deadline));
        eventsList.add(event);

        Collections.sort(taskListImportance, (a, b) -> Integer.compare(b.taskImportance.getOrder(), a.taskImportance.getOrder()));

        for(int i = 0; i<taskList.size()-1; i++){
            for(int j = 0; j<taskList.size()-1 - i; j++) {
                if (!taskList.get(j).deadline.isBefore(taskList.get(j + 1).deadline)) {
                    LocalDate temp = taskList.get(j).deadline;
                    taskList.get(j).deadline = taskList.get(j + 1).deadline;
                    taskList.get(j + 1).deadline = temp;
                }
            }
        }
    }
    public void deadLineChecker() {
        LocalDate current = LocalDate.now();
        for (ToDoList t : taskListImportance) {
            if (!current.isBefore(t.deadline)) {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(null, "Deadline reached for: " + t.taskName, "Deadline Notification", JOptionPane.WARNING_MESSAGE);
                });
                doneList.add(t);
            }
        }
        taskListImportance.removeAll(doneList);
    }
    public void removeTask(Tasks task) {
        taskListImportance.remove(task);
        taskList.remove(task);
    }
}

