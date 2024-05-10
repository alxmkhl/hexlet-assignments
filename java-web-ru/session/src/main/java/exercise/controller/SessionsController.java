package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void index( Context ctx) {
        var cookie = ctx.sessionAttribute("currentUser");
        if (cookie == null) {
            var loginPage = new MainPage(null);
            ctx.render("index.jte", model("page", loginPage));
        } else {
            var user = UsersRepository.find(Long.valueOf(Integer.valueOf((String) cookie)));
            var loginPage = new MainPage(user.getName());
            ctx.render("index.jte", model("page", loginPage));
        }

    }
    public static void build(Context ctx) {
        var loginPage = new LoginPage(null, null);
        ctx.render("build.jte", model("page", loginPage));
    }

    public static void login(Context ctx) {
        var userName = ctx.formParam("name");
        var password = ctx.formParam("password");
        var encryptPassword = Security.encrypt(password);
        var user = UsersRepository.findByName(userName);
        if (UsersRepository.existsByName(userName) && encryptPassword.equals(user.getPassword())) {
            var mainPage = new MainPage(userName);
            ctx.sessionAttribute("currentUser", String.valueOf(user.getId()));
            ctx.render("index.jte", model("page", mainPage));
            ctx.status(302);
        } else {
            var userPage = new LoginPage(userName, "Wrong username or password");
            ctx.render("build.jte", model("page", userPage));
        }
    }

    public static void logout(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.status(302);
        ctx.redirect(NamedRoutes.buildSessionPath());
    }


    // END
}
