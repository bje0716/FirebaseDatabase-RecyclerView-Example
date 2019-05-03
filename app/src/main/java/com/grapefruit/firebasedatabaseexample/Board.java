package com.grapefruit.firebasedatabaseexample;

public class Board {

    private String name;
    private String title;
    private String content;
    private String date;

    public Board() {}

    public Board(String name, String title, String content, String date) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
