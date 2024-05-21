package User.ERD.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Post {
  @Id
  @GeneratedValue
  private Integer id;
  private String title;
  private String content;
  private String write_at;
  private Integer userId;
}
