package com.springrest.springrest.controller;



import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Brute {
    public HashMap<String, HashMap<String, HashSet<String>>> theory = new HashMap<>();
    public HashMap<String, HashMap<String, HashSet<String>>> lab = new HashMap<>();
    public HashMap<String, HashMap<String, List<List<String>>>> embedded = new HashMap<>();

    public HashMap<String,HashSet<String>> teachers = new HashMap<>();

    public HashSet<String> slots = new HashSet<>();



    public static HashMap<String,HashSet<String>> teacherSubject = new HashMap<>();

    public static HashMap<String,HashSet<String>> teacherSubject1 = new HashMap<>();

    public Brute(Brute ob){
        this.theory = ob.theory;
        this.lab = ob.lab;
        this.embedded = ob.embedded;
        this.teachers=ob.teachers;
        this.slots=ob.slots;
    }

    public Brute(HashMap<String, HashMap<String, HashSet<String>>> theory1,HashMap<String, HashMap<String, HashSet<String>>> lab1,HashMap<String, HashMap<String, List<List<String>>>> embedded1,HashMap<String,HashSet<String>> teachers1,HashSet<String> slots1){
        this.theory = theory1;
        this.lab = lab1;
        this.embedded = embedded1;
        this.teachers=teachers1;
        this.slots=slots1;
    }

}
