package org.todo.todolist;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class TaskBuilder {
    HBox box = new HBox();
    HBox innerBox = new HBox();
    Label importance = new Label();
    Label name = new Label();
    Button delete = new Button("Delete");
    Button finish = new Button("Finish");
    Label deadline = new Label();
    //Image icon = new Image("src");

    public TaskBuilder(Tasks task, ToDoList list, VBox container) {
        /*
        * Implement Switch case for icons
        * */
        name.setText(task.taskName);
        deadline.setText(task.deadline.toString());
        importance.setText(getImportance(task.taskImportance));

        innerBox.getChildren().addAll(importance, name, deadline);
        box.getStyleClass().add("task-hbox");
        innerBox.getStyleClass().add("innerHbox");

        box.getChildren().addAll(innerBox, finish, delete);

        finish.setOnAction(event -> deleteTask(task, list, container));
        delete.setOnAction(event -> deleteTask(task, list, container));
    }
    public TaskBuilder(Activity activity, ToDoList list, VBox container) {
        /*
         * Implement Switch case for icons
         * */
        name.setText(activity.taskName);
        deadline.setText(activity.deadline.toString());
        importance.setText(getImportance(activity.taskImportance));

        innerBox.getChildren().addAll(importance, name, deadline);
        box.getStyleClass().add("task-hbox");
        innerBox.getStyleClass().add("innerHbox");

        box.getChildren().addAll(innerBox, finish, delete);

        finish.setOnAction(event -> deleteActivity(activity, list, container));
        delete.setOnAction(event -> deleteActivity(activity, list, container));
    }
    public TaskBuilder(Events events, ToDoList list, VBox container) {
        /*
         * Implement Switch case for icons
         * */
        name.setText(events.taskName);
        deadline.setText(events.deadline.toString());
        importance.setText(getImportance(events.taskImportance));

        innerBox.getChildren().addAll(importance, name, deadline);
        box.getStyleClass().add("task-hbox");
        innerBox.getStyleClass().add("innerHbox");

        box.getChildren().addAll(innerBox, finish, delete);

        finish.setOnAction(event -> deleteEvent(events, list, container));
        delete.setOnAction(event -> deleteEvent(events, list, container));
    }
    public void addBox(VBox vbox){
        vbox.setPadding(new Insets(10, 20, 15, 15));
        vbox.setSpacing(10);

        vbox.getChildren().add(box);

    }
    public String getImportance(ToDoList.Hierarchy priority){
        if(priority == null) return "Low";
        switch(priority){
            case LOW:
                return "Low";
            case HIGH:
                return "High";
            case MEDIUM:
                return "Medium";
            case IMPORTANT:
                return "IMPORTANT";
            default:
                return "Low";
        }
    }
    public void deleteTask(Tasks entry, ToDoList list, VBox vbox){
        box.getChildren().clear();
        list.taskList.remove(entry);
        vbox.getChildren().remove(box);
        SaveController.saveTasksToCSV(list.taskList, "tasks.csv");
    }
    public void deleteActivity(Activity entry, ToDoList list, VBox vbox){
        box.getChildren().clear();
        list.activityTasklist.remove(entry);
        vbox.getChildren().remove(box);
        SaveController.saveActivityToCSV(list.activityTasklist, "activities.csv");
    }
    public void deleteEvent(Events entry, ToDoList list, VBox vbox){
        box.getChildren().clear();
        list.eventsList.remove(entry);
        vbox.getChildren().remove(box);
        SaveController.saveEventsToCSV(list.eventsList, "events.csv");
    }
}
