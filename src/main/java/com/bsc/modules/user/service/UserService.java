package com.bsc.modules.user.service;
import java.util.List;

import com.bsc.common.utils.DictUtils;
import com.bsc.modules.user.dao.UserMapper;
import com.bsc.modules.user.entity.User;
import com.bsc.common.persistence.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserService extends CrudService<UserMapper,User> {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Override // 重写方法,根据用户id来获取整个用户实体
    public User get(int id) {
        User user = userMapper.get(id);
        user.setType(DictUtils.getDictLabel(user.getType(), "USER"));
        user.setSex(DictUtils.getDictLabel(user.getSex(), "GENDER"));
        user.setAcademy(DictUtils.getDictLabel(user.getAcademy(), "ACADEMY"));
        return user;
    }

    @Override
    public User getT(User entity) {
        return super.getT(entity);
    }

    @Override
    public List<User> findList(User entity) {
        List<User> userList = userMapper.findList(entity);
        for (int i = 0; i < userList.size(); i++) {
            userList.set(i, userService.get(userList.get(i).getId()));
        }
        return userList;
    }

    @Override
    public int insert(User entity) {
        return super.insert(entity);
    }

    @Override
    public int update(User entity) {
        entity.setType(DictUtils.getDictValue(entity.getType(), "USER"));
        entity.setSex(DictUtils.getDictValue(entity.getSex(), "GENDER"));
        entity.setAcademy(DictUtils.getDictValue(entity.getAcademy(), "ACADEMY"));
        return userMapper.update(entity);
    }

    @Override
    public int delete(int id) {
        return super.delete(id);
    }

    @Override
    public int deleteAll(int[] ids) {
        return super.deleteAll(ids);
    }

}

