package formatter;

import model.Seminar;

public abstract class SeminarFormatter {
    protected final StringBuilder output;
    protected final Seminar seminar;
    
    public SeminarFormatter(Seminar seminar) {
        output = new StringBuilder();
        this.seminar = seminar;
    }
    
    public abstract String format();
    
}
