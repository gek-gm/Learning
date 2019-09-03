package com.gmail.gcmcolombo.interactive;

import com.gmail.gcmcolombo.model.ApplicationContext;
import java.util.Collections;

public class ResetParticipantsCommand implements InteractiveCommand {
    private final ApplicationContext context;
    private final String commandLabel = CommandLabels.RESET_PARTICIPANTS_LABEL.getText();
    private final String description = CommandLabels.RESET_PARTICIPANTS_DESCRIPTION.getText();

    ResetParticipantsCommand(ApplicationContext context){
        this.context = context;

    }

    public void execute(){
        Collections.shuffle(context.getParticipants());
        context.setParticipantsIter(context.getParticipants().iterator());
    }

    public String getDescription(){
        return String.format("[%s] - %s", commandLabel, description);

    }

    public String getCommandLabel(){
        return commandLabel;
    }

}
