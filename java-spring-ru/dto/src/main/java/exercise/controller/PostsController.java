package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<PostDTO> getPosts() {
        var posts = this.postRepository.findAll();

      var postDTOS = posts.stream().map(this::toDTO).toList();
        postDTOS.forEach(post -> {
            var comments = this.commentRepository.findByPostId(post.getId());
            post.setComments(comments.stream().map(this::toCommentDTO).toList());
        });
        return postDTOS;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDTO getPostById(@PathVariable Long id) {
        var post = this.postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        var postDTO = toDTO(post);
        var comments = commentRepository.findByPostId(post.getId());
        var commentsDTO = comments.stream().map(this::toCommentDTO).toList();
        postDTO.setComments(commentsDTO);
        return postDTO;
    }

    private PostDTO toDTO(Post post) {
        var dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());
        return dto;
    }

    private CommentDTO toCommentDTO(Comment comment) {
        var dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setBody(comment.getBody());
        return dto;
    }
}
// END
