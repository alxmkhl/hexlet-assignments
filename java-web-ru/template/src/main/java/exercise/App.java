package exercise;

import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;

import io.javalin.http.NotFoundResponse;
import exercise.model.User;

import static io.javalin.rendering.template.TemplateUtil.model;

import io.javalin.rendering.template.JavalinJte;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        List<User> users = new ArrayList<>();
        USERS.forEach(user -> {
            users.add(new User(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail()));
        });
        // END
        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/users", ctx -> {
            UsersPage usersPage = new UsersPage(users);
            ctx.render("users/index.jte", model("page", usersPage));
        });

        app.get("/users/{id}", ctx -> {

            var user = users.stream().filter(u -> String.valueOf(u.getId()).equals(ctx.pathParam("id"))).toList();
            if (user.isEmpty()) {
                throw new NotFoundResponse("user with " + ctx.pathParam("id") + " not found");
            } else {
                UserPage userPage = new UserPage(user.get(0));
                ctx.render("users/show.jte", model("page", userPage));
            }

        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
