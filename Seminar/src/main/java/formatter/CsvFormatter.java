package formatter;

public interface CsvFormatter<T> extends Formatter<T> {
    
    public String format(T convertData, char delimiter);

}
