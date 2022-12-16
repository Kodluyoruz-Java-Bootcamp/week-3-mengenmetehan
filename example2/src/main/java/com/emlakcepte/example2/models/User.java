package com.emlakcepte.example2.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {
    private final int id;
    private final String name;
    private final String surname;
    private String password;
    private UserType type = UserType.BASIC; // İlk oluşturmada basic, sonrasında set edilebilir.
    private final List<Blog> blogList = new ArrayList<>();
    private final List<User> followerUserList = new ArrayList<>();
    private final List<Tag> tagList = new ArrayList<>();
    private LocalDateTime createDateTime;

    public User(int id, String name, String surname, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.createDateTime = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public UserType getType() {
        return type;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public boolean deleteTag(Tag tag) {
        for (Tag t : tagList)
            if (tag.getName().equals(t.getName())){
                tagList.remove(tag);
                return true;
            }
        return false;
    }
    public boolean deleteFollower(User user) {
        for (User u : followerUserList)
            if(u.getName().equals(user.getName())) {
                followerUserList.remove(u);
                return true;
            }
        return false;
    }

    public void addFollowerUser(User us){
        followerUserList.add(us);
    }

    public List<User> getFollowerUserList() {
        return followerUserList;
    }


    public List<Tag> getTagList() {
        return tagList;
    }

    public void addTag(Tag tag) {
        tagList.add(tag);
    }

    public List<Blog> getBlogList() {
        return blogList.stream().toList();
    }

    public void addBlogList(Blog bl) {
        blogList.add(bl);
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    @Override
    public String toString() {
        return String.format("%s %s isimli kullanıcı, üyelik durumu %s, toplam blog sayısı %d dir. ",
                getName(), getSurname(), getType(), blogList.size());
    }

}