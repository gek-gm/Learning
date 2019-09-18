package com.app.formatter.seminar;

import com.app.formatter.FormatType;
import com.app.formatter.Formatter;
import com.app.model.Seminar;


public class SeminarFormatterFactory {
    
    public static Formatter<Seminar> fromType(FormatType type) {
        switch(type) {
            case HTML:
                return new SeminarHtmlFormatter();
            case CSV:
                return new SeminarCsvFormatter();
            case RAW:
                return new SeminarRawFormatter();
            default:
                throw new IllegalArgumentException(String.format("Formatter of type \"%s\" does not exist", type));
        }
    }
    
}
