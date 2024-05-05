package exercise;

import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        var app = Javalin.create();
        var phones = Data.getPhones();
        var domains = Data.getDomains();
        app.get("/phones", cts -> cts.json(phones));
        app.get("/domains", cts -> cts.json(domains));
        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
