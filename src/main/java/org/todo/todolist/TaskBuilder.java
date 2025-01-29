package org.todo.todolist;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.awt.image.PackedColorModel;
import java.util.ArrayList;

public class TaskBuilder {
    HBox box = new HBox();
    HBox innerBox = new HBox();
    HBox buttonBox = new HBox();
    HBox deadlinebox = new HBox();
    HBox nameBox = new HBox();
    VBox rightPanel = new VBox();

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
        name.setStyle("-fx-font-size: 14px");
        deadline.setText("Due on: " + task.deadline.toString());
        deadline.setStyle("-fx-text-fill: #ffffff");
        deadlinebox.getChildren().add(deadline);
        deadlinebox.setAlignment(Pos.CENTER);
        deadlinebox.setStyle("-fx-background-radius: 20; -fx-border-radius: 20");

        switch(task.taskImportance){
            case ToDoList.Hierarchy.LOW:
                deadlinebox.setStyle("-fx-background-color: #91a975;-fx-background-radius: 20; -fx-border-radius: 20; -fx-min-height:12; -fx-max-height:12;-fx-pref-height:12");
                break;
            case ToDoList.Hierarchy.MEDIUM:
                deadlinebox.setStyle("-fx-background-color: #aeb072;-fx-background-radius: 20; -fx-border-radius: 20; -fx-min-height:12; -fx-max-height:12;-fx-pref-height:12");
                break;
            case ToDoList.Hierarchy.HIGH:
                deadlinebox.setStyle("-fx-background-color: #ae985f;-fx-background-radius: 20; -fx-border-radius: 20; -fx-min-height:12; -fx-max-height:12;-fx-pref-height:12");
                break;
            case ToDoList.Hierarchy.IMPORTANT:
                deadlinebox.setStyle("-fx-background-color: #ae7e5f;-fx-background-radius: 20; -fx-border-radius: 20; -fx-min-height:12; -fx-max-height:12;-fx-pref-height:12");
                break;
        }

        buttonBox.getChildren().addAll(finish, delete);
        buttonBox.setSpacing(5);
        rightPanel.getChildren().addAll(deadlinebox, buttonBox);
        rightPanel.setSpacing(5);
        rightPanel.setStyle("-fx-padding: 4");

        innerBox.getChildren().addAll(name, rightPanel);
        box.getStyleClass().add("task-hbox");
        innerBox.getStyleClass().add("innerHbox");

        box.getChildren().addAll(innerBox, rightPanel);

        finish.setOnAction(event -> deleteTask(task, list, container));
        delete.setOnAction(event -> deleteTask(task, list, container));
    }
    public TaskBuilder(Activity activity, ToDoList list, VBox container) {
        /*
         * Implement Switch case for icons
         * */
        name.setText(activity.taskName);
        name.setStyle("-fx-font-size: 14px");
        deadline.setStyle("-fx-text-fill: #ffffff");
        deadline.setText("Due on: " + activity.deadline.toString());
        deadlinebox.getChildren().add(deadline);
        deadlinebox.setAlignment(Pos.CENTER);
        deadlinebox.setStyle("-fx-background-radius: 20; -fx-border-radius: 20; -fx-min-height:12; -fx-max-height:12;-fx-pref-height:12");

        switch(activity.taskImportance){
            case ToDoList.Hierarchy.LOW:
                deadlinebox.setStyle("-fx-background-color: #91a975;-fx-background-radius: 20; -fx-border-radius: 20; -fx-min-height:12; -fx-max-height:12;-fx-pref-height:12");
                break;
            case ToDoList.Hierarchy.MEDIUM:
                deadlinebox.setStyle("-fx-background-color: #aeb072;-fx-background-radius: 20; -fx-border-radius: 20; -fx-min-height:12; -fx-max-height:12;-fx-pref-height:12");
                break;
            case ToDoList.Hierarchy.HIGH:
                deadlinebox.setStyle("-fx-background-color: #ae985f;-fx-background-radius: 20; -fx-border-radius: 20; -fx-min-height:12; -fx-max-height:12;-fx-pref-height:12");
                break;
            case ToDoList.Hierarchy.IMPORTANT:
                deadlinebox.setStyle("-fx-background-color: #ae7e5f;-fx-background-radius: 20; -fx-border-radius: 20; -fx-min-height:12; -fx-max-height:12;-fx-pref-height:12");
                break;
        }
        buttonBox.getChildren().addAll(finish, delete);
        buttonBox.setSpacing(5);
        rightPanel.getChildren().addAll(deadlinebox, buttonBox);
        rightPanel.setSpacing(5);
        rightPanel.setStyle("-fx-padding: 4");

        innerBox.getChildren().addAll(name, rightPanel);
        box.getStyleClass().add("task-hbox");
        innerBox.getStyleClass().add("innerHbox");

        box.getChildren().addAll(innerBox, rightPanel);

        finish.setOnAction(event -> deleteActivity(activity, list, container));
        delete.setOnAction(event -> deleteActivity(activity, list, container));
    }
    public TaskBuilder(Events events, ToDoList list, VBox container) {
        /*
         * Implement Switch case for icons
         * */
        name.setText(events.taskName);
        name.setStyle("-fx-font-size: 14px");
        deadline.setStyle("-fx-text-fill: #ffffff");
        deadline.setText("Marked on: " + events.deadline.toString());
        deadlinebox.getChildren().add(deadline);
        deadlinebox.setAlignment(Pos.CENTER);
        deadlinebox.setStyle("-fx-background-radius: 20; -fx-border-radius: 20; -fx-min-height:15; -fx-max-height:15;-fx-pref-height:15");

        switch(events.taskImportance){
            case ToDoList.Hierarchy.LOW:
                deadlinebox.setStyle("-fx-background-color: #91a975;-fx-background-radius: 20; -fx-border-radius: 20; -fx-min-height:12; -fx-max-height:12;-fx-pref-height:12");
                break;
            case ToDoList.Hierarchy.MEDIUM:
                deadlinebox.setStyle("-fx-background-color: #aeb072;-fx-background-radius: 20; -fx-border-radius: 20; -fx-min-height:12; -fx-max-height:12;-fx-pref-height:12");
                break;
            case ToDoList.Hierarchy.HIGH:
                deadlinebox.setStyle("-fx-background-color: #ae985f;-fx-background-radius: 20; -fx-border-radius: 20; -fx-min-height:12; -fx-max-height:12;-fx-pref-height:12");
                break;
            case ToDoList.Hierarchy.IMPORTANT:
                deadlinebox.setStyle("-fx-background-color: #ae7e5f;-fx-background-radius: 20; -fx-border-radius: 20; -fx-min-height:12; -fx-max-height:12;-fx-pref-height:12");
                break;
        }

        rightPanel.getChildren().add(deadlinebox);
        buttonBox.getChildren().addAll(finish, delete);
        buttonBox.setSpacing(5);
        rightPanel.getChildren().add(buttonBox);
        rightPanel.setSpacing(5);
        rightPanel.setStyle("-fx-padding: 4");
        innerBox.getChildren().addAll(name, rightPanel);
        box.getStyleClass().add("task-hbox");
        innerBox.getStyleClass().add("innerHbox");

        box.getChildren().addAll(innerBox, rightPanel);

        finish.setOnAction(event -> deleteEvent(events, list, container));
        delete.setOnAction(event -> deleteEvent(events, list, container));
    }
    public void addBox(VBox vbox){
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.setSpacing(15);
        vbox.setStyle("-fx-max-height: 20");
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
