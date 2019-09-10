package formatter;

import java.text.SimpleDateFormat;

import model.Seminar;

public class SeminarHtmlFormatter implements Formatter<Seminar> {
    private StringBuilder output;
    private Seminar seminar;

    @Override
    public String format(Seminar seminar) {
        output = new StringBuilder();
        this.seminar = seminar;
        output.append("<html>");
        formatHead();
        formatBody();
        output.append("</html>");
        return output.toString();
    }
    
    private void formatHead() {
        output.append("<head>");
        output.append(String.format("<title>%s</title>", seminar.getCourse().getName()));
        output.append("</head>");
    }
    
    private void formatBody() {
        output.append("<body>");
        formatSeminarInfo();
        formatStudentsList();
        output.append("</body>");
    }
    
    private void formatSeminarInfo() {
        output.append(String.format("<div>%s:</div>", seminar.getName()));
        if (seminar.getCourse().getStartDate() != null)
            formatSeminarStartDate();
        output.append("<ul>");
        output.append(String.format("<li>%s</li>", seminar.getDescription()));
        output.append(String.format("<li>%s</li>", seminar.getLocation() ));
        output.append(String.format("<li>%s</li>", seminar.getSeatsLeft() ));
        output.append("</ul>");
    }
    
    private void formatStudentsList() {
        output.append("<div>partecipanti:</div>");
        output.append("<ul>");
        for (String studentName : seminar.getStudentList())
            output.append(String.format("<li>%s</li>", studentName));
        output.append("</ul>");
    }
    
    private void formatSeminarStartDate() {
        String formattedDate = new SimpleDateFormat("dd/MM/yyyy, HH:mm").format(seminar.getCourse().getStartDate());
        output.append(String.format("<li>%s</li>", formattedDate));
    }
    
}
