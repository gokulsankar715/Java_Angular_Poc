package com.bosch.user.controller;

import com.bosch.user.dto.UserDto;
import com.bosch.user.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value = "/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/")
  public ResponseEntity<List<UserDto>> getAllUsers() {
    return ResponseEntity.ok().body(userService.getAllUsers());
  }

  @PostMapping("/")
  public ResponseEntity<UserDto> createUsers(@RequestBody UserDto user) {
    return ResponseEntity.ok().body(userService.createUser(user));
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserDto> updateUsers(@PathVariable long id,@RequestBody UserDto user) throws Exception {
    userService.getUserById(id);
    return ResponseEntity.ok().body(userService.updateUser(user));
  }

  @DeleteMapping("/{id}")
  public HttpStatus deleteUsers(@PathVariable long id) throws Exception {
    this.userService.deleteUser(id);
    return HttpStatus.OK;
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDto> getAllUserId(@PathVariable long id) throws Exception {
    return ResponseEntity.ok().body(userService.getUserById(id));
  }

}
