package miu.edu.demo.service.impl;

import miu.edu.demo.domain.Userr;

import miu.edu.demo.domain.dto.UserDto;
 import miu.edu.demo.repo.UserRepo;
import miu.edu.demo.service.UserService;
import miu.edu.demo.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepo userRepo;


    @Autowired
    ListMapper<Userr,UserDto> listMapperUserToDto;
    @Override
    public List<UserDto> findAll() {
        return (List<UserDto>)listMapperUserToDto.mapList(userRepo.findAll(),new UserDto());
    }

    @Override
    public UserDto findByIdDto(long id) {
        return modelMapper.map( userRepo.findById(id) , UserDto.class );
    }

    @Override
    public List<Userr> findAllByIdIn(List<Long> user_ids) {
        return userRepo.findAllByIdIn(user_ids);
    }

    @Override
    public Userr findById(long id) {
        return userRepo.findById(id);
    }

    @Override
    public void save(UserDto p) {
        userRepo.save(modelMapper.map(p, Userr.class));
    }

    @Override
    public void delete(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<Userr> findUsersWithGivenNumberOfPosts(int count) {
        return userRepo.findUsersWithGivenNumberOfPosts(count);
    }

}
