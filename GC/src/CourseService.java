import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CourseService {
    public void addPost(Kurz kurz, EpicClass oznameni) {
       kurz.getList().add(oznameni);
    }
    public void removePost(String id, Kurz kurz) {
        kurz.setList((ArrayList<EpicClass>) kurz.getList().stream()
                .filter(i -> !i.getTitle().equals(i.getTitle())).collect(Collectors.toList())) ;
    }

    ;
}
