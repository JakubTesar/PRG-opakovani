import java.time.LocalDateTime;

public class Oznameni extends EpicClass{

    private String obsah;

    public Oznameni( String title, boolean visibleForStudents, String obsah) {
        super(title, visibleForStudents);
        this.obsah = obsah;
    }

    public String getObsah() {
        return obsah;
    }
}
