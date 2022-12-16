package com.emlakcepte.example2.repository;


import com.emlakcepte.example2.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> userList = new ArrayList<>();

    public void saveUser(User user)
    {
        if (user != null)
            userList.add(user);
    }

    public void addFollowerUser(User follower, User following)
    {
        if (userList.contains(follower))
            follower.addFollowerUser(following);
    }

    public List<User> getAllUser()
    {
        return userList;
    }

    public List<User> getAllFollowerUser(User user)
    {
        if(userList.contains(user))
            return user.getFollowerUserList();
        return null;
    }


    public void deleteUser(User user)
    {
        if (userList.remove(user))
            System.out.printf("%s isimli kullanıcı", user);
        else
            System.out.println("Kullanıcı bulunamadı");
    }

    public boolean updatePassword(User user, String password)
    {
        for(User u : userList)
            if (u.getName().equals(user.getName())) {
                u.setPassword(password);
                return true;
            }
        return false;
    }
}
