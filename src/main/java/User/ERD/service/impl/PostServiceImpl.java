package User.ERD.service.impl;

import User.ERD.dto.PostDTO;
import User.ERD.entity.Post;
import User.ERD.repository.PostRepository;
import User.ERD.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
  @Autowired
  private PostRepository postRepository;

  @Override
  public void addPost(Post post) {
    postRepository.save(post);
  }

  @Override
  public List<Post> getPosts() {
    return postRepository.findAll();
  }

  @Override
  public Post getPost(Integer id) {
    return postRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "포스트를 찾지 못했습니다. 포스트 id: " + id));
  }

  @Override
  public void updatePost(Integer id, Post post) {
    post.setId(id);
    postRepository.save(post);
  }

  @Override
  public void deletePost(Integer id) {
    Post post = postRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "포스트를 삭제 했습니다. 포스트 id: " + id));

    postRepository.delete(post);
  }

  @Override
  public void updateContent(Integer id, PostDTO postDTO) {
    Post post = postRepository
        .findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "사용자를 업데이트 했습니다. 사용자 id: " + id));
    post.setContent(postDTO.getContent());
    postRepository.save(post);

  }
}
