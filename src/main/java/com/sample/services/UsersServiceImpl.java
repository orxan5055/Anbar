package com.sample.services;

import com.sample.model.Users;
import com.sample.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    UsersRepository usersRepository;

    public Users findByUsername(String username){
        return usersRepository.findByUsername(username);

    }

}
