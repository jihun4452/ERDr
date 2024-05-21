package User.ERD.Controller;

import User.ERD.entity.Post;
import User.ERD.dto.PostDTO;
import User.ERD.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

  @Autowired
  private PostService postService;

  @PostMapping("/add")
  public String addPost(@RequestBody Post post) {
    postService.addPost(post);
    return "내용 작성 완료!";
  }

  @GetMapping
  public List<Post> getPosts() {
    return postService.getPosts();
  }

  @GetMapping("/get")
  public Post getPost(@RequestParam Integer id) {
    return postService.getPost(id);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<Void> updatePost(@PathVariable Integer id, @RequestBody Post post) {
    postService.updatePost(id, post);

    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("delete/{id}")
  public ResponseEntity<Void> deletePost(@PathVariable Integer id){
    postService.deletePost(id);

    return ResponseEntity.noContent().build();
  }

  @PatchMapping("/update-content/{id}")
  public ResponseEntity<Void> updatecontent(@PathVariable Integer id, @RequestBody PostDTO postDTO){
    postService.updateContent(id, postDTO);

    return ResponseEntity.noContent().build();
  }

}
