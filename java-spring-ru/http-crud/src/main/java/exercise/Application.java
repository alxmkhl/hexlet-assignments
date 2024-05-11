package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exercise.model.Post;

@SpringBootApplication
@RestController
public class Application {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @GetMapping("/posts")
    public List<Post> getPosts(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer limit) {
//        return this.posts.stream().limit(limit).toList();
        if (posts.subList(page * limit - limit, page * limit).size() <= this.posts.size()) {
            return posts.subList(page * limit - limit, page * limit);
        }
        return posts;
    }

    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable String id) {
        var post = this.posts.stream().filter(p -> p.getId().equals(id)).findFirst().get();
        return post;
    }
//
    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        posts.add(post);
        return post;
    }
//
    @PutMapping("/posts/{id}")
    public Post updatePost(@PathVariable String id, @RequestBody Post data) {
        var post = this.posts.stream().filter(p -> p.getId().equals(id)).findFirst();
        if (post.isPresent()) {
            post.get().setBody(data.getBody());
            post.get().setTitle(data.getTitle());
        }
        return data;
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable String id) {
        this.posts.removeIf(p -> p.getId().equals(id));
    }
    // END
}
