package exercise;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// BEGIN

// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies/{id}", ctx -> {

//            COMPANIES.forEach(company -> {
//                if (company.get("id") != null) {
//                    if (company.get("id").equalsIgnoreCase(ctx.pathParam("id"))) {
//                        ctx.json(company);
//                    }
//                } else {
//
//                }
//            });
            var company = COMPANIES.stream().filter(c -> c.get("id").equalsIgnoreCase(ctx.pathParam("id"))).toList();
            if (company.isEmpty()) {
                throw new NotFoundResponse("Company not found");
            } else {
                ctx.json(company.get(0));
            }
        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
