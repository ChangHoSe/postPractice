package hello.website.demo.controller;

import hello.website.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/")
    public String initial(){
        return "redirect:/posts";
    }

    @GetMapping("/posts")
    public String readPostList() {

        return "post-list";
    }

    @GetMapping("/posts/{id}")
    public String detailPost(){

        return "post-detail";
    }

    @GetMapping("/posts/new")
    public String newPost(){

        return "post-form";
    }

    @GetMapping("/posts/edit/{id}")
    public String editPostForm(){

        return "post-form";
    }

    @PostMapping("/posts/save")
    public String saveOrUpdatePost(){

        return "redirect:/posts";
    }

    @DeleteMapping("/posts/delete/{id}")
    public String deletePost() {

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
