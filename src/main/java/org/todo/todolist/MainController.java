package org.todo.todolist;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

//import static org.todo.todolist.Main.list;

public class MainController implements Initializable {
    @FXML
    private ScrollPane activitiesPane;

    @FXML
    private Button addEvent;

    @FXML
    private Button addTask;

    @FXML
    private ScrollPane eventsPane;

    @FXML
    private Button options;

    @FXML
    private ScrollPane screenTimePane;

    @FXML
    private ScrollPane tasksPane;

    @FXML
    private VBox vboxAT;

    @FXML
    private VBox vboxEV;

    @FXML
    private VBox vboxST;

    @FXML
    private VBox vboxTK;

    ToDoList list;

    public void setList(ToDoList list){
        this.list = list;
    }

    public void addTaskPane(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("addTaskEntry.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 355, 360);

        addTaskEntryController tControl = fxmlLoader.getController();
        tControl.setMainController(this);

        Stage stage = new Stage();

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public void listUpdater(Tasks task) {
        TaskBuilder build = new TaskBuilder(list, task);
        build.addBox(vboxTK);
        list.taskList.add(task);
        list.taskListImportance.add(task);
    }
    public void listUpdater(Activity activity) {
        TaskBuilder build = new TaskBuilder(list, activity);
        build.addBox(vboxAT);
        list.activityTasklist.add(activity);
    }
    public void listUpdater(Events event) {
        TaskBuilder build = new TaskBuilder(list, event);
        build.addBox(vboxEV);
        list.eventsList.add(event);
    }

        @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            //vboxAT.getChildren().add(new Label("someting"));
        // Consider moving list update logic to a separate method called after FXML injection
    }
}
