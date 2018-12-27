package com.khja021.service;

import com.khja021.dao.UserRepository;
import com.khja021.domain.User;
import com.khja021.domain.enumeration.UserRole;
import com.khja021.dto.UserDto;
import com.khja021.mapper.UserMapper;
import com.khja021.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private UserMapper userMapper;


    @Override
    public void addUser(UserDto userDto) {
        userDto.setEnabled(true);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        userDto.setDate(format.format(new Date(System.currentTimeMillis())));
        userDto.setUserRoles(UserRole.ROLE_USER);
        userRepository.save(userMapper.fromDto(userDto));
    }

    @Override
    public void blockUser(int id) {
        UserDto userDto = this.getUser(id);
        userDto.setEnabled(!userDto.isEnabled());
        this.updateUser(userDto);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getUser(int id) {
        return userMapper.toDto(userRepository.getOne(id));
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getUser(String username) {
        User user = userRepository.findUserByUsername(username);
        return (user == null) ? null : userMapper.toDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = userMapper.fromDto(userDto);
        userRepository.saveAndFlush(user);
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDto> getUsers() {
        return userMapper.toDtoList(userRepository.findAll());
    }
}
