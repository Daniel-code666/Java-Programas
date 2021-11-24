/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sergioarboleda.divinacomedia.app.service;

import com.sergioarboleda.divinacomedia.app.model.User;
import com.sergioarboleda.divinacomedia.app.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Daniel
 */
@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getAll(){
        return repository.getAll();
    }
    
    public User save(User user){
        if(user.getId() == null){
            List<User> existUser = repository.getUserByNameOrEmail(user.getName(), user.getEmail());
            if(existUser.isEmpty()){
                return repository.save(user);
            }else{
                return user;
            }
        }else{
            Optional<User> existUsers = repository.getUserById(user.getId());
            
            if(existUsers.isPresent()){
                return repository.save(user);
            }else{
                return user;
            }
        }
    }
    
    public boolean checkEmailServ(String email){
        return repository.getUserByEmail(email).isPresent();
    }
    
    public User getUserByEmailAndPassword(String email, String password){
        Optional<User> user = repository.getUserByEmailAndPassword(email, password);
        
        if(user.isPresent()){
            return user.get();
        }else{
            return new User(null, email, password, "NO DEFINIDO");
        }
    }
}
