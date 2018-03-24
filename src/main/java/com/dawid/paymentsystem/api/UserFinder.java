package com.dawid.paymentsystem.api;

import com.dawid.paymentsystem.api.dtos.UserDto;

import java.util.List;

public interface UserFinder {

    List<UserDto> getAll();
}
