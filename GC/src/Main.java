public class Main {
    public static void main(String[] args) {
        CourseRepository courseRepository = new CourseRepository();
        CourseService courseService = new CourseService();
        Kurz PRG = new Kurz("PRG", "Nejlepší kurz", courseRepository.loadCourse());
        courseService.addPost();
    }
}
