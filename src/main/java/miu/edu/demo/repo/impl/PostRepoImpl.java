//package miu.edu.demo.repo.impl;
//
//import miu.edu.demo.domain.Post;
//import miu.edu.demo.repo.PostRepo;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Repository
//public class PostRepoImpl implements PostRepo {
//
//
//    private static int postId = 200;
//
//    private static ArrayList<Post> postList;
//
//    static {
//        postList = new ArrayList<>();
//        postList.add(
//                new Post(1, "test1", "Author1 ", "Content1")
//        );
//        postList.add(
//                new Post(2, "test2", "Author1 ", "Content1")
//        );
//        postList.add(
//                new Post(3, "test3", "Author3 ", "Content3")
//        );
//    }
//
//
//    @Override
//    public List<Post> findAll() {
//        return postList;
//    }
//
//    @Override
//    public Post getPostById(int id) {
//        return postList.stream()
//                .filter(l -> l.getId() == id).findFirst().orElse(null);
//    }
//
//    @Override
//    public void save(Post POST) {
//        POST.setId(postId);
//        postId++;
//        postList.add(POST);
//    }
//
//    @Override
//    public void delete(int id) {
//        var post = postList.stream().filter(l -> l.getId() == id).findFirst().get();
//        postList.remove(post);
//    }
//
//    @Override
//    public void update(int id, Post p) {
//        Post toUpdate = getPostById(id);
//        toUpdate.setTitle(p.getTitle());
//        toUpdate.setContent(p.getContent());
//        toUpdate.setAuthor(p.getAuthor());
//    }
//
//    @Override
//    public List<Post> getPostByAuthor(String test) {
//        return postList.stream().filter(p -> p.getAuthor().equals(test)).collect(Collectors.toList());
//    }
//}
