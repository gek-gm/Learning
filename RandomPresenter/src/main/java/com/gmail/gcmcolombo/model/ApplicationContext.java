package com.gmail.gcmcolombo.model;

import com.gmail.gcmcolombo.RandomPresenter;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class ApplicationContext {
    private final List<Person> participants = new ArrayList<>();
    private Iterator<Person> participantsIter;
    private final List<Person> absents = new ArrayList<>();
    private Event event;
    private final Properties properties = new Properties();

    public ApplicationContext(){
        loadPropertiesFile();
    }

    public List<Person> getParticipants() {
        return participants;
    }

    public List<Person> getAbsents() {
        return absents;
    }

    public Iterator<Person> getParticipantsIter() {
        return participantsIter;
    }

    public void setParticipantsIter(Iterator<Person> participantsIter) {
        this.participantsIter = participantsIter;
    }

    public Event getTalkEvent() {
        return event;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setTalkEvent(Event talkEvent) {
        event = talkEvent;
    }

    private void loadPropertiesFile(){
        try ( InputStream input = RandomPresenter.class.getClassLoader().getResourceAsStream("config.properties") ) {
            properties.load(input);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

}
