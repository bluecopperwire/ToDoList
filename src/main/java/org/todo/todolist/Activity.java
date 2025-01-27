package org.todo.todolist;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Activity extends ToDoList {
    public Activity(String name, ToDoList.Hierarchy importance, LocalDate deadLine) {
        taskName = name;
        taskImportance = importance;
        deadline = deadLine;
    }
}
