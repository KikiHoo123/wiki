package com.bsc.modules.user.dao;

import com.bsc.common.annotation.MybatisDao;
import com.bsc.common.persistence.CrudDao;
import com.bsc.modules.user.entity.User;

import java.util.List;

@MybatisDao
public interface UserMapper extends CrudDao<User> {
    User get(int id);

    User getT(User entity);

    List<User> findList(User entity);

    List<User> findAllList(User entity);

    int insert(User entity);

    int update(User entity);

    int delete(int id);


}






