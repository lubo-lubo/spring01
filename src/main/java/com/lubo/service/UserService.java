package com.lubo.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.lubo.pojo.User;

import java.util.List;

public interface UserService {
    public boolean login(String userCode, String userPassword);
    public List<User> findAll();
    public List<User> findPage(int PageNum,int pageSize);
    public Page<User> getPage(int pageNum,int pageSize);
}
