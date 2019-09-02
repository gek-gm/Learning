package com.gmail.gcmcolombo.model;

import java.time.LocalDateTime;

public class TalkEvent implements Event {
    private final LocalDateTime talkEventDateTime;

    public TalkEvent(){
        this.talkEventDateTime = LocalDateTime.now();

    }

    public LocalDateTime getEventDate(){
        return talkEventDateTime;
    }

}