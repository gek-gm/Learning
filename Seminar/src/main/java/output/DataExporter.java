package output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import formatter.Formatter;

public class DataExporter<T, U extends Formatter<T>> {
    private final T exportData;
    private final U csvConverter;
    
    public DataExporter(T exportData,U csvConverter){
        this.exportData = exportData;
        this.csvConverter = csvConverter;
    }
    
    public File exportTo(String filePath) throws IOException {
        File csvFile = new File(filePath);
        try ( FileWriter fw = new FileWriter(csvFile)) { 
            fw.write(csvConverter.format(exportData));
        }
        return csvFile;  
    }

}
