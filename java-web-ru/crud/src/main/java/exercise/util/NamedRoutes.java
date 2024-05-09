package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    // BEGIN
    public static String postPath() {
        return "/posts/{id}";
    }
    public static String postsPath() {
        return "/posts";
    }
    // END
}
