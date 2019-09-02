package com.gmail.gcmcolombo.interactive;

public interface InteractiveCommand {

    void execute();

    String getDescription();

    String getCommandLabel();

}

enum CommandLabels {

    PRINT_RANDOM_PRESENTER_DESCRIPTION("pick random presenter from the participants list"),
    PRINT_RANDOM_PRESENTER_LABEL("n"),
    PRINT_RANDOM_PRESENTER_SUCCESS("The next presenter is: "),
    PRINT_RANDOM_PRESENTER_EMPTY("Available participants list is empty"),
    PRINT_RANDOM_PRESENTER_END("All the participants have been extracted! Reset the participants list to start the extraction again."),

    RESET_PARTICIPANTS_DESCRIPTION("reset participants list"),
    RESET_PARTICIPANTS_LABEL("r"),

    EXIT_DESCRIPTION("exit"),
    EXIT_LABEL("e");


    private String value;

    CommandLabels(String value){
        this.value = value;
    }

    public String getText(){
        return value;
    }


}

enum InteractiveMenuMessage {

    INPUT_REQUEST_MESSAGE("Please choose a command: "),
    COMMAND_NOT_FOUND("command not found. please retry");


    private String value;

    InteractiveMenuMessage(String value){
        this.value = value;
    }

    public String getText(){
        return value;
    }


}
