package com.emlakcepte.example2.repository;


import com.emlakcepte.example2.models.Blog;

import java.util.ArrayList;
import java.util.List;

public class BlogRepository {
    private List<Blog> blogList = new ArrayList<>();

    public void saveBlog(Blog blog)
    {
        if (blog != null)
            blogList.add(blog);
    }

    public List<Blog> getAll()
    {
        return blogList;
    }

    public void deleteBlog(Blog blog)
    {
        if (blogList.remove(blog))
            System.out.printf("%s isimli blog silindi", blog);
        else
            System.out.println("Blog bulunamadı");
    }

    public boolean updateBlog(Blog blog)
    {
        for(Blog b : blogList)
            if (b.getName().equals(blog.getName())) {
                blogList.remove(b);
                blogList.add(blog);
                return true;
            }
        return false;
    }
}
