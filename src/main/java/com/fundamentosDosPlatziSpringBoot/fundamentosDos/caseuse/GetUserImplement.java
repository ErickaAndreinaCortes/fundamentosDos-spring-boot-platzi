package com.fundamentosDosPlatziSpringBoot.fundamentosDos.caseuse;

import com.fundamentosDosPlatziSpringBoot.fundamentosDos.entity.User;

import java.util.List;

public class GetUserImplement implements GetUser{
    private UserService userService;

    @Override
    public List<User> getAll() {
        return null;
    }
}
