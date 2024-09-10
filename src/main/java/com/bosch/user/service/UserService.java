package com.bosch.user.service;

import com.bosch.user.dto.UserDto;
import com.bosch.user.entity.Users;
import com.bosch.user.mapper.UserMapper;
import com.bosch.user.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public List<UserDto> getAllUsers() {
    return userMapper.toDtoList(userRepository.findAll());
  }

  public UserDto createUser(UserDto userDto) {
    return userMapper.toDto(userRepository.save(userMapper.toEntity(userDto)));
  }

  public UserDto updateUser(UserDto users) throws Exception {
    Optional<Users> optionalUsers = userRepository.findById(users.getId());

    if (optionalUsers.isPresent()) {

      return userMapper.toDto(userRepository.save(userMapper.toEntity(users)));
    } else {
      throw new Exception("Record not found with id : " + users.getId());
    }
  }

  public void deleteUser(long userId) throws Exception {
    Optional<Users> optionalUsers = userRepository.findById(userId);

    if (optionalUsers.isPresent()) {
      userRepository.delete(optionalUsers.get());
    } else {
      throw new Exception("Record not found with id : " + userId);
    }
  }

  public UserDto getUserById(Long id) throws Exception {
    var user = userRepository.findById(id);
    if (user.isPresent()) {
      return userMapper.toDto(user.get());
    } else {
      throw new Exception("Record not found with id : " + id);
    }
  }
  }
