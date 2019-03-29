package com.bsc.modules.student.dao;

import com.bsc.common.annotation.MybatisDao;
import com.bsc.common.persistence.CrudDao;
import com.bsc.modules.student.entity.Student;
import java.util.List;

@MybatisDao
public interface StudentMapper extends CrudDao<Student>{
    Student get(int id);

    Student getT(Student entity);

    List<Student> findList(Student entity);

    List<Student> findAllList(Student entity);

    int insert(Student entity);

    int update(Student entity);

    int delete(int id);
}
