package org.example;

public class Student {
    private  String name;
    private int bangla;
    private int english;
    private int math;

    public Student (String name,int bangla, int english,int math){
        this.name=name;
        this.bangla=bangla;
        this.english=english;
        this.math=math;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBangla() {
        return bangla;
    }

    public void setBangla(int bangla) {
        this.bangla = bangla;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }
}
