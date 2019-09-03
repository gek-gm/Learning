package com.gmail.gcmcolombo.csv;

import com.gmail.gcmcolombo.RandomPresenter;
import com.gmail.gcmcolombo.model.ApplicationContext;
import com.gmail.gcmcolombo.model.Person;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileWriter;
import java.net.URLDecoder;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.nio.file.Path;

public class AbsentsCsvWriter {
    private final String homeDirectory = System.getProperty("user.dir");
    private final String CSVFileName;
    private final ApplicationContext context;
    private final String[] csvHeader = new String[]{"date", "firstName", "lastName"};

    public AbsentsCsvWriter(ApplicationContext context) throws java.net.URISyntaxException{
        this.context = context;
        CSVFileName = context.getProperties().getProperty("absence_history_filename");

    }

    public void write(){
        Path path = Paths.get(homeDirectory, CSVFileName);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String eventFormatDate = context.getTalkEvent().getEventDate().format(formatter);

        try(FileWriter fileWriter = new FileWriter(path.toString(), true);
            CSVPrinter printer = isNewFile(path) ? CSVFormat.DEFAULT.withHeader(csvHeader).print(fileWriter) : CSVFormat.DEFAULT.print(fileWriter)) {
            for (Person absent : context.getAbsents() ) {
                printer.printRecord(eventFormatDate, absent.getFirstName(), absent.getLastName());
            }
        } catch (Exception e){
            System.out.println(String.format("Fatal Error while writing absences history file '%s' please check permission of executable working directory", path.toString()));
            System.exit(1);
        }

    }

    private Boolean isNewFile(Path path){
        File file = new File(path.toString());
        return (!file.exists() || file.length() == 0);

    }

}
