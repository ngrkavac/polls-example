package com.doodle.polls.model;

import org.springframework.data.mongodb.core.index.TextIndexed;

public class Options {

    @TextIndexed
    public String date;

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }
}
