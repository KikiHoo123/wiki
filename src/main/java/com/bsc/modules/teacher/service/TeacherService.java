package com.bsc.modules.teacher.service;
import java.util.List;
import com.bsc.modules.teacher.dao.TeacherMapper;
import com.bsc.modules.teacher.entity.Teacher;
import com.bsc.common.persistence.CrudService;
import com.bsc.modules.user.entity.User;
import com.bsc.modules.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TeacherService extends CrudService<TeacherMapper,Teacher>{
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private TeacherService teacherService;

    @Override // 重写方法,根据用户id来获取整个教师实体
    public Teacher get(int id) {
        Teacher teacher = teacherMapper.get(id);
        User user=userService.get(teacher.getUserID().getId());
        teacher.setUserID(user);
        return teacher;
    }

    @Override
    public Teacher getT(Teacher entity) {
        return super.getT(entity);
    }

    @Override
    public List<Teacher> findList(Teacher entity) {
        List<Teacher> teacherList = teacherMapper.findList(entity);
        for(int i = 0; i < teacherList.size(); i ++){
            teacherList.set(i, teacherService.get(teacherList.get(i).getId()));
        }
        return teacherList;
    }

    @Override
    public int insert(Teacher entity) {
        return super.insert(entity);
    }

    @Override
    public int update(Teacher entity) {
        return super.update(entity);
    }

    @Override
    public int delete(int id) { return super.delete(id); }

    @Override
    public int deleteAll(int[] ids) {
        return super.deleteAll(ids);
    }

}
