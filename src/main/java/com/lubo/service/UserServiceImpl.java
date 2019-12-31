package com.lubo.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.lubo.dao.UseMapper;
import com.lubo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UseMapper useMapper;
    @Override
    public boolean login(String userCode, String userPassword) {
        User u=new User();
        u.setUserCode(userCode);
        User user=useMapper.selectOne(u);
        if(user!=null && user.getUserPassword().equals(userPassword)){
            System.out.println("查找成功");
            return true;
        }else{
            System.out.println("查找失败");
            return false;
        }
    }

    @Override
    public List<User> findAll() {
        List<User> list=useMapper.selectList(null);
        return list;
    }

    @Override
    public List<User> findPage(int pageNum,int pageSize) {
        List<User> list=useMapper.selectPage(new Page<User>(pageNum,pageSize),null);
        return list;
    }

    @Override
    public Page<User> getPage(int pageNum,int pageSize) {
        Page<User> page=new Page<>(pageNum,pageSize);
        List<User> list=useMapper.selectPage(page,null);
        page.setRecords(list);
        assert list!=null:list;
        return page;
    }

}
