package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.Validator;

public class PostsController {
    // BEGIN
    public static void post(Context ctx) {
        Validator<Long> id = ctx.pathParamAsClass("id", Long.class);
        System.out.println(id.get());
        var post = PostRepository.find(id).orElseThrow(() -> new NotFoundResponse("Page not found"));
        var postPage = new PostPage(post);
        ctx.render("posts/show.jte", model("page", postPage));
    }

    public static void posts(Context ctx) {
        var pageNumber = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var posts = PostRepository.findAll(pageNumber, 5);

//        var nextPage = posts.size() == 5 ? pageNumber++ : null;
//        System.out.println(prevPage + " " + nextPage);
        var postsPage = new PostsPage(posts, pageNumber);
        ctx.render("posts/index.jte", model("page", postsPage));
    }
    // END
}
