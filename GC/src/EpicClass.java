import java.time.LocalDateTime;

public class EpicClass {
    private String timeAdd = LocalDateTime.now().toString();
    private String title;
    private boolean visibleForStudents;


    public EpicClass( String title, boolean visibleForStudents) {
        this.title = title;
        this.visibleForStudents = visibleForStudents;
    }

    public String getTimeAdd() {
        return timeAdd;
    }

    public String getTitle() {
        return title;
    }

    public boolean isVisibleForStudents() {
        return visibleForStudents;
    }
}
