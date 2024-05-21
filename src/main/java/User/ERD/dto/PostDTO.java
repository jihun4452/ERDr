package User.ERD.dto;


import lombok.Data;

@Data
public class PostDTO {
  private Integer id;
  private Integer user_id;
  private String title;
  private String content;
  private String write_at;
}