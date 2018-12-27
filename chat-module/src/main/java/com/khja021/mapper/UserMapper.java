package com.khja021.mapper;

import com.khja021.domain.User;
import com.khja021.domain.enumeration.UserRole;
import com.khja021.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ${JDEEK} on ${11.11.2018}.
 */
@Component("userMapper")
public class UserMapper implements Mapper<User, UserDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserMapper.class);


    @Override
    public User fromDto(UserDto userDto) {
        User user = new User();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        user.setId(userDto.getId());
        user.setFirstname(userDto.getFirstName());
        user.setLastname(userDto.getLastName());
        user.setGender(userDto.getGender());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getLogin());

        try {
            user.setDate(formatter.parse(userDto.getDate()));
        } catch (ParseException e) {
            LOGGER.error("Cannot convert date");
        }
        user.setPhone(userDto.getPhone());
        user.setRole(UserRole.ROLE_USER);
        user.setEnabled(userDto.isEnabled());
        return user;
    }

    @Override
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstname());
        userDto.setLastName(user.getLastname());
        userDto.setGender(user.getGender());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setLogin(user.getUsername());
        userDto.setDate(formatter.format(user.getDate()));
        userDto.setPhone(user.getPhone());
        userDto.setUserRoles(UserRole.ROLE_USER);
        userDto.setEnabled(user.isEnabled());

        return userDto;
    }

    @Override
    public List<UserDto> toDtoList(List<User> users) {
        return users.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<User> fromDtoList(List<UserDto> userDtos) {
        return userDtos.stream().map(this::fromDto).collect(Collectors.toList());
    }
}

