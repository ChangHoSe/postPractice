package hello.website.demo.service;

import hello.website.demo.domain.Post;
import hello.website.demo.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    //c
    public void createPost(Post post){
        postRepository.save(post);
    }

    //r
    public Post readPostById(Long id){
        Post post = findById(id);
        return post;
    }

    public List<Post> readAllPosts(){
        return postRepository.findAll();
    }

    //u
    public void updatePost(Post newPost) {
        Post post = findById(newPost.getId());
        if (newPost.getContent() != null){
            post.setContent(newPost.getContent());
        }
        if (newPost.getAuthor() != null){
            post.setAuthor(newPost.getAuthor());
        }
        if (newPost.getTitle() != null){
            post.setTitle(newPost.getTitle());
        }
        postRepository.save(post);
    }

    //d
    public void deletePost(Long postId){
        Post post = findById(postId);
        postRepository.delete(post);
    }

    private Post findById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("글 없음"));
    }
}
