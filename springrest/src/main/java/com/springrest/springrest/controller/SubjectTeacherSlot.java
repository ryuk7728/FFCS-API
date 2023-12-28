package com.springrest.springrest.controller;


import java.util.HashSet;

public class SubjectTeacherSlot {
    public final String subject;
    public final String teacher;
    public final HashSet<String> slot;

    public SubjectTeacherSlot(String subject, String teacher, HashSet<String> slot) {
        this.subject = subject;
        this.teacher = teacher;
        this.slot = slot;
    }
}
