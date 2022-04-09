package miu.edu.demo.service;

import miu.edu.demo.domain.Userr;
import miu.edu.demo.domain.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findByIdDto(long id);

    List<Userr> findAllByIdIn(List<Long> user_ids);

    Userr findById(long id);

    void save(UserDto user);

    void delete(long id);

    List<Userr> findUsersWithGivenNumberOfPosts(int count);

}
