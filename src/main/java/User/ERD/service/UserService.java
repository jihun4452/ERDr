package User.ERD.service;

import User.ERD.dto.UserDTO;
import User.ERD.entity.Post;
import User.ERD.entity.User;

import java.util.List;

public interface UserService {
  void addUser(User user);

  List<User> getUsers();

  User getUser(Integer id);

  void updateUser(Integer id, User user);

  void deleteUser(Integer id);

  void updateName(Integer id, UserDTO userDTO);

  List<Post> getUserPosts(Integer userId);

}