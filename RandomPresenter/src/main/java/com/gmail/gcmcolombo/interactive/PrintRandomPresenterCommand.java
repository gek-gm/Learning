package com.gmail.gcmcolombo.interactive;

import com.gmail.gcmcolombo.model.ApplicationContext;
import com.gmail.gcmcolombo.model.Person;

import java.util.Collections;
import java.util.Iterator;

public class PrintRandomPresenterCommand implements InteractiveCommand {
    private final ApplicationContext context;
    private final String commandLabel = CommandLabels.PRINT_RANDOM_PRESENTER_LABEL.getText();
    private final String description = CommandLabels.PRINT_RANDOM_PRESENTER_DESCRIPTION.getText();

    PrintRandomPresenterCommand(ApplicationContext context){
        this.context = context;

        Collections.shuffle(context.getParticipants());
        context.setParticipantsIter(context.getParticipants().iterator());

    }

    public String getCommandLabel(){ return commandLabel; }

    public String getDescription(){
        return String.format("[%s] - %s", commandLabel, description);
    }

    public void execute(){
        Iterator<Person> participantIter = context.getParticipantsIter();
        if(context.getParticipants().size() == 0) {
            System.out.println(CommandLabels.PRINT_RANDOM_PRESENTER_EMPTY.getText());
            return;
        }
        if (participantIter.hasNext()) {
            Person nextPresenter = participantIter.next();
            System.out.println();
            System.out.println(CommandLabels.PRINT_RANDOM_PRESENTER_SUCCESS.getText() + nextPresenter.getFullName());
            System.out.println();
        } else
            System.out.println(CommandLabels.PRINT_RANDOM_PRESENTER_END.getText());

    }

}
