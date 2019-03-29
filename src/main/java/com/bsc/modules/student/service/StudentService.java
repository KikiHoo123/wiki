package com.bsc.modules.student.service;
import java.util.List;

import com.bsc.common.utils.DictUtils;
import com.bsc.modules.student.dao.StudentMapper;
import com.bsc.modules.student.entity.Student;
import com.bsc.common.persistence.CrudService;
import com.bsc.modules.user.entity.User;
import com.bsc.modules.user.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class StudentService extends CrudService<StudentMapper,Student>{
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private  StudentService studentService;
    @Autowired
    private UserService userService;

    @Override // 重写方法,根据用户id来获取整个学生实体
    public Student get(int id) {
        Student student = studentMapper.get(id);
        User user=userService.get(student.getUserID().getId());
        student.setUserID(user);
        student.setGrade(DictUtils.getDictLabel(student.getGrade(),"GRADE"));
        student.setStep(DictUtils.getDictLabel(student.getStep(),"MAJOR"));
        return student;
    }

    @Override
    public Student getT(Student entity) {
        return super.getT(entity);
    }

    @Override
    public List<Student> findList(Student entity) {
        List<Student> studentList = studentMapper.findList(entity);
        for(int i = 0; i < studentList.size(); i ++){
            studentList.set(i, studentService.get(studentList.get(i).getId()));
        }
        return studentList;
    }

    @Override
    public int insert(Student entity) {
        return super.insert(entity);
    }

    @Override
    public int update(Student entity) {
        return super.update(entity);
    }

    @Override
    public int delete(int id) { return super.delete(id); }

    @Override
    public int deleteAll(int[] ids) {
        return super.deleteAll(ids);
    }

}
