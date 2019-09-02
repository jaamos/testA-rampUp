package com.prealation.test.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class TodoLists {

    @JsonProperty
    List<TotoList> todoLists = new ArrayList<>();

    @JsonCreator
    public TodoLists() {
    }

    @JsonCreator
    public TodoLists(List<TotoList> todoLists) {
        this.todoLists = todoLists;
    }

    public List<TotoList> getTodoLists() {
        return todoLists;
    }

    public void setTodoLists(List<TotoList> todoLists) {
        this.todoLists = todoLists;
    }

    public boolean addList(TotoList list){
        return todoLists.add(list);
    }

    public boolean removeList(TotoList list){
        return todoLists.remove(list);
    }

    @Override
    public String toString() {
        return "TodoLists{" +
                "todoLists=" + todoLists +
                '}';
    }
}
