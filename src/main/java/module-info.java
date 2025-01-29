module org.todo.todolist {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.sun.jna;
    requires com.sun.jna.platform;

    requires com.dlsc.formsfx;
    requires java.desktop;

    opens org.todo.todolist to javafx.fxml;
    exports org.todo.todolist;
}