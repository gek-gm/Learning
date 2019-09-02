package com.gmail.gcmcolombo.interactive;

import com.gmail.gcmcolombo.model.ApplicationContext;

import java.util.LinkedHashMap;
import java.util.Map;

public final class InteractiveMainMenu implements InteractiveMenu{
    private final Map<String,InteractiveCommand> commandsMap = new LinkedHashMap<>();

    public InteractiveMainMenu(ApplicationContext context){
        InteractiveCommand[] tmpCommands = new InteractiveCommand[] {
                new PrintRandomPresenterCommand(context),
                new ResetParticipantsCommand(context),
                new ExitCommand()
        };

        for (InteractiveCommand command : tmpCommands) {
            commandsMap.put(command.getCommandLabel(),command);
        }
    }

    public void show(){
        while(true){
            printCommandsDescription();

            String userInput = System.console().readLine(InteractiveMenuMessage.INPUT_REQUEST_MESSAGE.getText());

            if(commandsMap.containsKey(userInput))
                commandsMap.get(userInput).execute();
            else
                System.out.println(InteractiveMenuMessage.COMMAND_NOT_FOUND.getText());
        }
    }

    private void printCommandsDescription(){
        System.out.println();
        for (InteractiveCommand command : commandsMap.values()) {
            System.out.println(command.getDescription());
        }
        System.out.println();
    }

}
