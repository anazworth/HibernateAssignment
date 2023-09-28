package org.anazworth;


import java.util.List;

public interface ToDoStorage {
    List<ToDoItem> getAllItems();
    void addItem(ToDoItem item);
    void completeItem(int id);
    void removeItem(int id);

    List<ToDoItem> getAllUncompletedItems();
}
