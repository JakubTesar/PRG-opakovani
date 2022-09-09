import java.time.LocalDateTime;

public class Ukol extends EpicClass{
    private String finishTime;

    public Ukol(String title, boolean visibleForStudents, String finishTime) {
        super( title, visibleForStudents);
        this.finishTime = finishTime;
    }

    public String getFinishTime() {
        return finishTime;
    }
}
