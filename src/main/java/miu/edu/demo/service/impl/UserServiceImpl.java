package miu.edu.demo.service.impl;

import miu.edu.demo.domain.Post;
import miu.edu.demo.domain.User;

import miu.edu.demo.domain.dto.PostDto;
import miu.edu.demo.domain.dto.UserDto;
 import miu.edu.demo.repo.UserRepo;
import miu.edu.demo.service.UserService;
import miu.edu.demo.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired

    ListMapper<User, UserDto> listMapperUser2Dto;
    @Autowired
    ListMapper<Post, PostDto> listMapperPost2Dto;

    @Override
    public List<UserDto> findAll() {
        return (List<UserDto>) listMapperUser2Dto.mapList((List<User>) userRepo.findAll(), new UserDto());
    }

    @Override
    public UserDto getUserById(long id) {
        return modelMapper.map(userRepo.findById(id).get(), UserDto.class);
    }

    @Override
    public List<PostDto> getPostsOfUserById(long id) {
        return (List<PostDto>) listMapperPost2Dto.mapList(userRepo.findById(id).get().getPost(), new PostDto());
    }

    @Override
    public void save(User userr) {
        userRepo.save(userr);
    }

    @Override
    public void delete(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void update(int id, UserDto userDto) {
        userRepo.save(modelMapper.map(userDto, User.class));
    }
}
