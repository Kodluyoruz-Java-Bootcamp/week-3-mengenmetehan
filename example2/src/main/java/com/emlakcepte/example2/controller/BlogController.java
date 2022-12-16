package com.emlakcepte.example2.controller;

import com.emlakcepte.example2.models.Blog;
import com.emlakcepte.example2.models.User;
import com.emlakcepte.example2.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/blogs")
public class BlogController {

    private final BlogService m_blogService;

    public BlogController(BlogService blogService)
    {
        m_blogService = blogService;
    }

    @GetMapping("/get")
    public List<Blog> getAll()
    {
        return m_blogService.getAll();
    }

    @GetMapping("/get_active_blog")
    public List<Blog> getAllActiveBlog()
    {
        return m_blogService.getAllActiveBlog();
    }

    @GetMapping("/get_draft_blog")
    public List<Blog> getAllDraftBlog()
    {
        return m_blogService.getAllDraftBlog();
    }

    @GetMapping("/get_removed_blog")
    public List<Blog> getAllRemovedBlog()
    {
        return m_blogService.getAllRemovedBlog();
    }

    @GetMapping("/getallbaccbl")
    public List<Blog> getAllRemovedBlog(@RequestParam("u") User user)
    {
        return m_blogService.getBasicAccountByUsername(user);
    }

    @PostMapping("/publish_blog")
    public ResponseEntity<Blog> publishBlog (Blog blog)
    {
        m_blogService.publishBlog(blog);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping("/delete_blog")
    public ResponseEntity<Blog> deleteBlog (Blog blog)
    {
        m_blogService.deleteBlog(blog);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

}
