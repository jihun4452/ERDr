package User.ERD.service;

import User.ERD.dto.PostDTO;
import User.ERD.entity.Post;

import java.util.List;

public interface PostService {
  void addPost(Post post);

  List<Post> getPosts();

  Post getPost(Integer id);

  void updatePost(Integer id, Post post);

  void deletePost(Integer id);

  void updateContent(Integer id, PostDTO postDTO);
}