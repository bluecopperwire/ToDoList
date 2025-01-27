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

    public TaskBuilder(Tasks task) {
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

    }
    public TaskBuilder(Activity activity) {
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
    }
    public TaskBuilder(Events event) {
        /*
         * Implement Switch case for icons
         * */
        name.setText(event.taskName);
        deadline.setText(event.deadline.toString());
        importance.setText(getImportance(event.taskImportance));
        innerBox.getChildren().addAll(importance, name, deadline);
        box.getStyleClass().add("task-hbox");
        innerBox.getStyleClass().add("innerHbox");
        box.getChildren().addAll(innerBox, finish, delete);
    }
    public void addBox(VBox vbox){
        vbox.setPadding(new Insets(10, 20, 15, 15));
        vbox.setSpacing(10);
        Platform.runLater(() -> {
            vbox.getChildren().add(box);
        });
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
}
