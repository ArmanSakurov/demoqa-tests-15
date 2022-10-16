package com.demoqa.model;

import java.util.List;

public class Student {

    public String name;
    public int age;
    public boolean isStudent;
    public List<String> lessons;
    public Education education;

    public static class Education {
        public String type;
        public int groupId;
    }
}
