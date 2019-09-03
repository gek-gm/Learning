package com.gmail.gcmcolombo.csv;

import java.io.FileReader;

import com.gmail.gcmcolombo.model.ApplicationContext;
import com.gmail.gcmcolombo.model.Participant;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class ParticipantsCsvReader {
    private String dataFilePath;

    public ParticipantsCsvReader(String filePath){
        dataFilePath = filePath;
    }

    public void read(ApplicationContext context) {
        try (FileReader fileReader = new FileReader(dataFilePath)) {
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(fileReader);
            for (CSVRecord record : records) {
                Participant participant = new Participant();
                participant.setFirstName(record.get("firstName"));
                participant.setLastName(record.get("lastName"));
                participant.setAbsent(Boolean.parseBoolean(record.get("absent")));
                if (participant.isAbsent())
                    context.getAbsents().add(participant);
                else
                    context.getParticipants().add(participant);

            }
        } catch (Exception e) {
            System.out.println(String.format("Fatal Error while reading participants list file '%s', please check permissions and file format", dataFilePath));
            System.exit(1);
        }
    }
}
