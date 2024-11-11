package hello.website.demo.controller;

import hello.website.demo.domain.Post;
import hello.website.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/")
    public String initial(){
        return "redirect:/posts";
    }

    @GetMapping("/posts")
    public String readPostList(Model model) {
        List<Post> posts =  postService.readAllPosts();
        model.addAttribute("posts", posts);
        return "post-list";
    }

    @GetMapping("/posts/{id}")
    public String detailPost(@PathVariable Long id, Model model){
        Post post = postService.readPostById(id);
        model.addAttribute("post", post);
        return "post-detail";
    }

    @GetMapping("/posts/new")
    public String newPost(Model model){
        model.addAttribute("post", new Post());
        return "post-form";
    }

    @GetMapping("/posts/edit/{id}")
    public String editPostForm(@PathVariable Long id, Model model){
        Post post = postService.readPostById(id);
        model.addAttribute("post", post);
        return "post-form";
    }

    @PostMapping("/posts/save")
    public String saveOrUpdatePost(Post post){
        if (post.getId() != null) {
            postService.updatePost(post);
        } else {
            postService.createPost(post);
        }
        return "redirect:/posts";
    }

    @DeleteMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/posts";
    }

//    @PostMapping("/posts/like/{id}")
//    public String likePost(){
//
//        return "redirect:/posts/" + id;
//    }
//
//    @PostMapping("/posts/comment/{postId}")
//    public String addComment() {
//
//        return "redirect:/posts/" + postId;
//    }
//
//    @PutMapping("/posts/comment/{commentId}")
//    public String updateComment() {
//
//        return "redirect:/posts/" + postId;
//    }
//
//    @DeleteMapping("/posts/comment/{commentId}")
//    public String updateComment() {
//
//        return "redirect:/posts/" + postId;
//    }

}
