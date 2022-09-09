import java.time.LocalDateTime;

public class Material extends EpicClass{
    private String Url;

    public Material(String title, boolean visibleForStudents, String url) {
        super( title, visibleForStudents);
        Url = url;
    }

    public String getUrl() {
        return Url;
    }
}
