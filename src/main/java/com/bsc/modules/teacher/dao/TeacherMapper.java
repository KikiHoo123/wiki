package com.bsc.modules.teacher.dao;

import com.bsc.common.annotation.MybatisDao;
import com.bsc.common.persistence.CrudDao;
import com.bsc.modules.teacher.entity.Teacher;

import java.util.List;

@MybatisDao
public interface TeacherMapper extends CrudDao<Teacher>{
    Teacher get(int id);

    Teacher getT(Teacher entity);

    List<Teacher> findList(Teacher entity);

    List<Teacher> findAllList(Teacher entity);

    int insert(Teacher entity);

    int update(Teacher entity);

    int delete(int id);

}
