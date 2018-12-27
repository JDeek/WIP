package com.khja021.service.interfaces;

import com.khja021.dto.UserDto;

import java.util.List;

/**
 * Created by ${JDEEK} on ${11.11.2018}.
 */
public interface UserService {

   void addUser(UserDto userDto);
   void blockUser(int id);
   UserDto getUser(int id);
   UserDto getUser(String username);
   UserDto updateUser(UserDto userDto);
   List<UserDto> getUsers();
}
