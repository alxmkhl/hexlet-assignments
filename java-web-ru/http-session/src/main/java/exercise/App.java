package exercise;

import io.javalin.Javalin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();


    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var map = ctx.queryParamMap();

            var result = new ArrayList<>();
            var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(-1);
            var per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(-1);
            if (page == -1) {
                result = new ArrayList<>(USERS.subList(0, 5));
            } else {
                result = new ArrayList<>(USERS.subList(per * page - per, per * page));
            }

            ctx.json(result);

//            var pag
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
