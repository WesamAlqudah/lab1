package miu.edu.demo.controller;

import miu.edu.demo.domain.Post;
import miu.edu.demo.domain.dto.PostDto;
import miu.edu.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    public void savePost(@RequestBody PostDto p, Principal principal) {
        postService.save(p, principal.getName());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Post> getPosts() {
        return postService.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{postId}")
    public Post getPost(@PathVariable("postId") long id) {
        return postService.findById(id);
    }

    @GetMapping("/filter/title/{title}")
    public List<Post> findTitle(@PathVariable("title") String title) {
        return postService.findTitle(title);
    }
}

//
//@RestController
//@RequestMapping("/users/posts")
//public class PostController {
//
//    @Autowired
//    PostService service;
//
//
//    @GetMapping("/")
//    public List<PostDto> getPosts(){
//        return service.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<PostDto> getById(@PathVariable int id) {
//        var post = service.getPostById(id);
//        return ResponseEntity.ok(post);
//    }
//
//    @PostMapping
//    public void save(@RequestBody PostDto p) {
//        service.save(p);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable int id) {
//        service.delete(id);
//    }
//
//    @PutMapping("/{id}")
//    public void update(@PathVariable("id") int postId, @RequestBody PostDto pDto) {
//        service.update(postId, pDto);
//    }
//    public void savePost(@RequestBody PostDto p, Principal principal){
//        service.save(p, principal.getName());
//    }
//
//    @GetMapping("/v2")
//    public ResponseEntity<PostV2> getPostV2(){
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Custom-Header", "someValue");
//        return ResponseEntity.ok()
//                .headers(headers)
//                .body(new PostV2(111,"title v2", "content v2", "author v2"));
//    }
//
//    @GetMapping
//    public List<PostDto> getAll(@RequestParam(value = "author", required = false) String author) {
//        return author == null ? service.findAll() : service.findAllPostsByAuthor(author);
//    }
//
//
//}
