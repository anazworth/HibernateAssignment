package org.anazworth;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ToDoServiceTest {

    private ToDoRepository repository;
    private ToDoService service;
    @BeforeEach
     void setup() {
         repository = mock(ToDoRepository.class);
         service = new ToDoService(repository);
    }

    @Test
    void addItem() {
        ToDoItem item = new ToDoItem();
        item.setTask("test task");
        item.setDateCreated(new java.util.Date().toString());
        item.setCompleted(false);

        ToDoItem testItem = service.addItem("test task");

        assertEquals(item.getTask(), testItem.getTask());
        assertEquals(item.getDateCreated(), testItem.getDateCreated());
        assertEquals(item.getCompleted(), testItem.getCompleted());
    }

    @Test
    void completeItem() {
        ToDoItem item = new ToDoItem();
        item.setTask("test task");
        item.setDateCreated(new java.util.Date().toString());
        item.setCompleted(false);

        ToDoItem testItem = service.addItem("test task");

        when(repository.getItemById(1)).thenReturn(testItem);

        ToDoItem completedItem = service.completeItem(1);

        assertEquals(item.getTask(), completedItem.getTask());
        assertEquals(item.getDateCreated(), completedItem.getDateCreated());
        assertEquals(true, completedItem.getCompleted());
    }

    @Test
    void removeItem() {
        ToDoItem item = new ToDoItem();
        item.setTask("test task");
        item.setDateCreated(new java.util.Date().toString());
        item.setCompleted(false);

        ToDoItem testItem = service.addItem("test task");

        when(repository.getItemById(1)).thenReturn(testItem);
        ToDoItem removedItem = service.removeItem(1);

        assertEquals(item.getTask(), removedItem.getTask());
        assertEquals(item.getDateCreated(), removedItem.getDateCreated());
        assertEquals(item.getCompleted(), removedItem.getCompleted());
    }
}