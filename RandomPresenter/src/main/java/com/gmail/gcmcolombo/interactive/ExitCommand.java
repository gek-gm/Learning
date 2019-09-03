package com.gmail.gcmcolombo.interactive;

public class ExitCommand implements InteractiveCommand {
    private final String description = CommandLabels.EXIT_DESCRIPTION.getText();
    private final String commandLabel = CommandLabels.EXIT_LABEL.getText();

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return String.format("[%s] - %s", commandLabel, description);
    }

    @Override
    public String getCommandLabel() {
        return commandLabel;
    }
}
