package org.todo.todolist;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Events extends ToDoList{
    public Events(String name, Hierarchy importance, LocalDate deadLine) {
        taskName = name;
        taskImportance = importance;
        deadline = deadLine;
    }
}
