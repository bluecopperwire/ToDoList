package org.todo.todolist;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class TaskBuilder {
    HBox box = new HBox();
    Label name = new Label();
    Button delete = new Button("Delete");
    Button finish = new Button("Finish");
    Label deadline = new Label();
    //Image icon = new Image("src");

    public TaskBuilder(ToDoList list, Tasks task) {
        /*
        * Implement Switch case for icons
        * */
        name.setText(task.taskName);
        deadline.setText(task.deadline.toString());

        box.setBackground(new Background(new BackgroundFill(Color.valueOf("#FFFFFF"), null, null)));

        box.getChildren().addAll(name, deadline, finish, delete);
    }
    public TaskBuilder(ToDoList list,Activity activity) {
        /*
         * Implement Switch case for icons
         * */
        name.setText(activity.taskName);
        deadline.setText(activity.deadline.toString());

        box.setBackground(new Background(new BackgroundFill(Color.valueOf("#FFFFFF"), null, null)));

        box.getChildren().addAll(name, deadline, finish, delete);
    }
    public TaskBuilder(ToDoList list,Events event) {
        /*
         * Implement Switch case for icons
         * */
        name.setText(event.taskName);
        deadline.setText(event.deadline.toString());

        box.setBackground(new Background(new BackgroundFill(Color.valueOf("#FFFFFF"), null, null)));

        box.getChildren().addAll(name, deadline, finish, delete);
    }
    public void addBox(VBox vbox){
        vbox.getChildren().clear();
        Platform.runLater(() -> {
            vbox.getChildren().add(box);
        });
    }

}
