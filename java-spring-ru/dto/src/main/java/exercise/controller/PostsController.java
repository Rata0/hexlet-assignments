package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
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
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "")
    public List<PostDTO> index() {
        List<Post> posts = postRepository.findAll();
        List<PostDTO> result = posts.stream()
                .map(this::postToDto)
                .toList();

        return result;
    }

    @GetMapping(path = "/{id}")
    public PostDTO show(@PathVariable Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));

        var dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());

        List<Comment> comments = commentRepository.findByPostId(dto.getId());
        List<CommentDTO> commentDTO = comments.stream()
                .map(this::commentToDto)
                .toList();
        dto.setComments(commentDTO);

        return dto;
    }

    private CommentDTO commentToDto(Comment comment) {
        CommentDTO dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setBody(comment.getBody());
        return dto;
    }

    private PostDTO postToDto(Post post) {
        PostDTO dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());

        List<Comment> comments = commentRepository.findByPostId(dto.getId());
        List<CommentDTO> commentDTO= comments.stream()
                .map(this::commentToDto)
                .toList();

        dto.setComments(commentDTO);
        return dto;
    }
}
// END
