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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

    @FXML
    private TabPane mainTabPane;

    @FXML
    private ImageView tabImageView;

    ToDoList list;

    public void setList(ToDoList list){
        this.list = list;
    }

    public void addTaskPane(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("addTaskEntry.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 355, 360);

        addTaskEntryController tControl = fxmlLoader.getController();
        tControl.setMainController(this);
        tControl.list = list;

        Stage stage = new Stage();

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public void listUpdater(Tasks task, ToDoList list) {
        list.addTask(task);
        vboxTK.getChildren().clear();
        System.out.println("Task added");
        for(Tasks t : list.taskList){
            TaskBuilder build = new TaskBuilder(t, list, vboxTK);
            build.addBox(vboxTK);
        }
        SaveController.saveTasksToCSV(list.taskList, "tasks.csv");
    }
    public void listUpdater(Activity activity,ToDoList list) {
        list.addActivity(activity);
        vboxAT.getChildren().clear();
        for(Activity a : list.activityTasklist){
            TaskBuilder build = new TaskBuilder(a, list, vboxAT);
            build.addBox(vboxAT);
        }
    }
    public void listUpdater(Events event,ToDoList list) {
        list.addEvent(event);
        vboxEV.getChildren().clear();
        for(Events e : list.eventsList){
            TaskBuilder build = new TaskBuilder(event, list, vboxEV);
            build.addBox(vboxEV);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tabImageView.setImage(new Image(getClass().getResource("/images/Task-Backsplash.png").toExternalForm()));
        mainTabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldTab, newTab) -> {
            if (newTab != null) {
                switch (newTab.getText().trim()) {
                    case "Tasks":
                        tabImageView.setImage(new Image(getClass().getResource("/images/Task-Backsplash.png").toExternalForm()));
                        break;
                    case "Activities":
                        tabImageView.setImage(new Image(getClass().getResource("/images/Activities.png").toExternalForm()));
                        break;
                    case "Events":
                        tabImageView.setImage(new Image(getClass().getResource("/images/Untitled-3Events.png").toExternalForm()));
                        break;
                    case "Screen Time":
                        tabImageView.setImage(new Image(getClass().getResource("/images/Untitled-3Screentime.png").toExternalForm()));
                        break;
                    default:
                        tabImageView.setImage(null); // Clear image if no match
                }
            }
        });
    }
    public void taskInitializer(ArrayList<Tasks> task) {
        for(Tasks t : task){
            TaskBuilder build = new TaskBuilder(t, list, vboxTK);
            build.addBox(vboxTK);
        }
        SaveController.saveTasksToCSV(list.taskList, "tasks.csv");
    }
    public void activityInitializer(ArrayList<Activity> activity) {
        for(Activity a : activity){
            TaskBuilder build = new TaskBuilder(a, list, vboxAT);
            build.addBox(vboxAT);
        }
        SaveController.saveActivityToCSV(list.activityTasklist, "activities.csv");
    }
    public void eventInitialer(ArrayList<Events> event) {
        for(Events e : event){
            TaskBuilder build = new TaskBuilder(e, list, vboxEV);
            build.addBox(vboxEV);
        }
        SaveController.saveEventsToCSV(list.eventsList, "events.csv");
    }
}