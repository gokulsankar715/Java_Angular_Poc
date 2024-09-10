package com.bosch.user.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDto {

  Long id;

  String userName;

  String userAddress;

  Long userMobileNo;

  String userEmailId;

}
