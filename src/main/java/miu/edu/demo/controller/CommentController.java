package miu.edu.demo.controller;


import miu.edu.demo.domain.Comment;
import miu.edu.demo.service.CommentService;
import miu.edu.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/posts/comment")
public class CommentController {

    @Autowired
    CommentService  commentService;

    @PostMapping("/users/{user_id}/posts/{post_id}")
    public void addComment(
            @PathVariable int user_id,
            @PathVariable int post_id,
            @RequestBody  Comment comment){
        commentService.addComment(post_id,comment);
    }

}
