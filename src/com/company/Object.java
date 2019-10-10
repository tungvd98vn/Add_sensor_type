package com.company;
import java.util.*;

public class Object {
    private ArrayList<String> properties;
    private ArrayList<String> methods;
    private String name;


    public Object(String name){
        this.name = name;
        properties = new ArrayList<String>();
        methods = new ArrayList<String>();
    }
    public void addProperties(String s){
        this.properties.add(s);
    }

    public void addMethods(String s){
        this.methods.add(s);
    }

    public ArrayList<String> getMethods(){
        return methods;
    }

    public ArrayList<String> getProperties(){
        return properties;
    }

    public String getName(){
        return this.name;
    }
}
