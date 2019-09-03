package com.gmail.gcmcolombo;

import com.gmail.gcmcolombo.csv.AbsentsCsvWriter;
import com.gmail.gcmcolombo.csv.ParticipantsCsvReader;
import com.gmail.gcmcolombo.interactive.InteractiveMainMenu;
import com.gmail.gcmcolombo.interactive.InteractiveMenu;
import com.gmail.gcmcolombo.model.ApplicationContext;
import com.gmail.gcmcolombo.model.TalkEvent;

import java.io.File;

public class RandomPresenter {

    public static void main(String... args){
        try {
            if (args.length == 1) {
                ParticipantsCsvReader participantsCsvReader = new ParticipantsCsvReader(args[0]);

                // Create Application context
                ApplicationContext context = new ApplicationContext();

                // Parse csv from csv
                participantsCsvReader.read(context);

                // Write current event absents to csv file
                context.setTalkEvent(new TalkEvent());
                AbsentsCsvWriter absentsCsvWriter = new AbsentsCsvWriter(context);
                absentsCsvWriter.write();

                // Start interactive session
                InteractiveMenu mainMenu = new InteractiveMainMenu(context);
                mainMenu.show();
            } else
                RandomPresenter.printUsageInfo();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static void printUsageInfo(){
        System.out.println("usage: java -jar [JARFILEPATH] [PARTICIPANTS_CSV_FILE] ");
        System.out.println("[PARTICIPANTS_CSV_FILE] is the participants csv list, it must include headers, example:");
        System.out.println("firstName,lastName,absent");
        System.out.println("John,Doe,true");
        System.out.println("Terry,ivan,");
    }

}
