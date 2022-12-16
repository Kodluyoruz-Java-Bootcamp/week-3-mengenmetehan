package com.emlakcepte.example2.service;



import com.emlakcepte.example2.models.Blog;
import com.emlakcepte.example2.models.Tag;
import com.emlakcepte.example2.models.User;
import com.emlakcepte.example2.repository.UserRepository;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public void saveUser (User user)
    {
        userRepository.saveUser(user);
    }

    public List<User> getAllUser()
    {
        return userRepository.getAllUser();
    }

    public List<User> getAllFollower(User user)
    {
        return userRepository.getAllFollowerUser(user);
    }
    public void addFollowerUser(User follower, User following)
    {
        userRepository.addFollowerUser(follower, following);
    }

    public void deleteUser(User user)
    {
        userRepository.deleteUser(user);
    }

    public void printAllUser()
    {
        getAllUser().forEach(System.out::println);
    }

    public List<Blog> getAllBlogList ()
    {
        return userRepository.getAllUser().stream()
                .flatMap(list -> list.getBlogList().stream())
                .collect(Collectors.toList());
    }

    public List<Tag> findTagListByUser (User user)
    {
        var userList = userRepository.getAllUser()
                .stream().filter(u -> u.equals(user))
                .toList();

        return userList.stream().map(User::getTagList)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

    }

    public void updatePassword(User user, String password)
    {
       userRepository.updatePassword(user, password);
    }

}
