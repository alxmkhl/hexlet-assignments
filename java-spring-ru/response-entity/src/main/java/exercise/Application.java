package exercise;

import java.net.URI;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

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
    public ResponseEntity<List<Post>> getPosts(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer limit) {
        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(this.posts.size()))
                .body(posts.stream().skip((page - 1) * limit).limit(limit).toList());
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPost(@PathVariable String id) {
        var post = this.posts.stream().filter(p -> p.getId().equals(id)).findFirst();
        if (post.isPresent()) {
            return ResponseEntity.ok().body(post.get());
        }
        return ResponseEntity.of(post);
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post data) {
        this.posts.add(data);
        return ResponseEntity.status(201).body(data);
    }
    // END

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable("id") String id, @RequestBody Post data) {
        var currentPost = this.posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if (currentPost.isPresent()) {
            currentPost.get().setBody(data.getBody());
            currentPost.get().setTitle(data.getTitle());
            return ResponseEntity.ok().body(currentPost.get());
        }
        return ResponseEntity.status(204).body(null);
    }

    @DeleteMapping("/posts/{id}")
    public void destroy(@PathVariable String id) {
        posts.removeIf(p -> p.getId().equals(id));
    }
}
