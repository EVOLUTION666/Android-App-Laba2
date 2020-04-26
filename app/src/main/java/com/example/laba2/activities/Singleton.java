package com.example.laba2.activities;

import com.example.laba2.model.Civilization;

import java.util.List;

//Класс Singleton нужен нам для того , чтобы передать наш массив данных из одного активити в другое

public class Singleton {
    private static Singleton singleObject;
    private List<Civilization> items;

    public static Singleton getInstance()
    {
        if(singleObject == null)
        {
            singleObject = new Singleton();
        }
        return singleObject;
    }

    public void setItems(List<Civilization> items) {
        this.items = items;
    }

    public List<Civilization> getItems() {
        return items;
    }

    public Civilization getItem(String name)
    {
        for(int i = 0; i < items.size(); i++)
        {
            if(items.get(i).getName().equals(name)) {
                return items.get(i);
            }
        }
        return null;
    }
}
