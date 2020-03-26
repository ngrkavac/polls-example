package com.doodle.polls.model;

import org.springframework.data.mongodb.core.index.TextIndexed;

public class Initiator {

    @TextIndexed
    private String name;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

}
