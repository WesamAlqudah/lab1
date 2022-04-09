package miu.edu.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.demo.domain.Post;
import miu.edu.demo.domain.Role;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private long id;
    private String name;
    private List<Role> roles;

}
