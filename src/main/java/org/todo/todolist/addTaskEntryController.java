package org.todo.todolist;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class addTaskEntryController extends ToDoList implements Initializable {

    @FXML
    private Button addEntry;

    @FXML
    private Button cancelbtn;

    @FXML
    private DatePicker deadLine;

    @FXML
    private ComboBox<String> taskHierarchy;

    @FXML
    private TextField taskName;

    @FXML
    private ComboBox<String> taskType ;

    public String type;
    public String name;
    public LocalDate date;
    public String priority;
    ToDoList.Hierarchy hierarchy = Hierarchy.LOW;
    MainController mController;
    ToDoList list;

    @FXML
    void AddEntrytolist(ActionEvent event) throws Exception {
        type = taskType.getValue();
        name = taskName.getText();
        date = deadLine.getValue();

        priority = taskHierarchy.getValue();


        switch(priority){
            case "Low":
                hierarchy = Hierarchy.LOW;
                break;
            case "Medium":
                hierarchy = Hierarchy.MEDIUM;
                break;
            case "High":
                hierarchy = Hierarchy.HIGH;
                break;
            case "Important":
                hierarchy = Hierarchy.IMPORTANT;
                break;
        }

        switch(type) {
            case "Default Task":
                Tasks task = new Tasks(name, hierarchy, date);
                mController.listUpdater(task, list);
                break;
            case "Activity":
                Activity activity = new Activity(name, hierarchy, date);
                mController.listUpdater(activity, list);
                break;
            case "Event":
                Events event1 = new Events(name, hierarchy, date);
                mController.listUpdater(event1, list);
        }

    }

    @FXML
    void dispose(ActionEvent event) {
        Stage stage = (Stage) cancelbtn.getScene().getWindow();
        stage.close();
    }
    public void setMainController(MainController mainController) {
        mController = mainController;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] hierarchy = new String[]{"Low", "Medium", "High", "Important"};
        String[] type = new String[]{"Default Task", "Activity", "Event"};

        taskHierarchy.getItems().addAll(hierarchy);
        taskType.getItems().addAll(type);
    }

}
