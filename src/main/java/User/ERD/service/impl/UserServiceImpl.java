package User.ERD.service.impl;

import User.ERD.dto.UserDTO;
import User.ERD.entity.Post;
import User.ERD.repository.PostRepository;
import User.ERD.entity.User;
import User.ERD.repository.UserRepository;
import User.ERD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  private PostRepository postRepository;

  @Override
  public void addUser(User user) {
    userRepository.save(user);
  }

  @Override
  public List<User> getUsers() {
    return userRepository.findAll();
  }

  @Override
  public User getUser(Integer id) {
    User user = userRepository
        .findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "사용자를 찾지 못했습니다. 사용자 id: " + id));
    return user;
  }

  @Override
  public void updateUser(Integer id, User user) {
    userRepository
        .findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "사용자를 업데이트 했습니다. 사용자 id: " + id));
    user.setId(id);

    userRepository.save(user);

  }

  @Override
  public void deleteUser(Integer id) {
    User user = userRepository
        .findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "사용자를 삭제 했습니다 사용자 id: " + id));

    userRepository.delete(user);
  }

  @Override
  public void updateName(Integer id, UserDTO userDTO) {
    User user = userRepository
        .findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "사용자를 업데이트 했습니다. 사용자 id: " + id));
    user.setName(userDTO.getName());
    userRepository.save(user);
  }
  @Override
  public List<Post> getUserPosts(Integer userId) {
    return postRepository.findByUserId(userId);
  }
}
