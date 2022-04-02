package miu.edu.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    long id;
    String title,author,content;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name= "id_post")
    List<Comment>commentList;
}
