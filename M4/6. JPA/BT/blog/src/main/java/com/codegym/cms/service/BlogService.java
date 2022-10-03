package com.codegym.cms.service;

import com.codegym.cms.model.BlogPrivate;
import com.codegym.cms.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public List<BlogPrivate> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public BlogPrivate findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(BlogPrivate blogPrivate) {
        blogRepository.save(blogPrivate);
    }

    @Override
    public void remove(Long id) {
        blogRepository.remove(id);
    }
}
