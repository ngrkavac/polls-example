package com.doodle.polls.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "polls")
public class Poll {

    @Id
    private String id;

    private Initiator initiator;
    private List<Options> options;
    private long initiated;
    @TextIndexed
    private String title;

    public Initiator getInitiator() {
        return initiator;
    }

    public void setInitiator(Initiator initiator) {
        this.initiator = initiator;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Options> getOptions() {
        return options;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }

    public long getInitiated() { return initiated; }

    public void setInitiated(long initiated) { this.initiated = initiated; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }
}
