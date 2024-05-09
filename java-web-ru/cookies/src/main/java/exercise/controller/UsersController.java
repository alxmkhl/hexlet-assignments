package exercise.controller;

import io.javalin.validation.ValidationException;
import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void show(Context ctx) throws Exception {
        try {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            var user = UserRepository.find(id).orElseThrow(() -> new NotFoundResponse("user not found"));
            var cookie = ctx.cookie("ucook");
            System.out.println("cookie: " + cookie);
            System.out.println("user id: " + user.getToken());
            if (cookie != null && cookie.equals(user.getToken())) {
                var userPage = new UserPage(user);
                ctx.render("users/show.jte", model("page", userPage));
            }

        } catch (ValidationException e) {

        }
    }

    public static void create(Context ctx) {
        try {
            var firstName = ctx.formParamAsClass("firstName", String.class).get();
            var lastName = ctx.formParamAsClass("lastName", String.class).get();
            var email = ctx.formParamAsClass("email", String.class).get();
            var password = ctx.formParamAsClass("password", String.class).get();

            var user = new User(firstName, lastName, email, password, Security.generateToken());

            UserRepository.save(user);
            ctx.cookie("ucook", user.getToken());
            ctx.redirect(NamedRoutes.userPath(user.getId()));

        } catch (ValidationException e) {
//            var name = ctx.formParam("name");
//            var body = ctx.formParam("body");
//            var page = new BuildPostPage(name, body, e.getErrors());
//            ctx.render("posts/build.jte", model("page", page)).status(422);
        }
    }
    // END
}
