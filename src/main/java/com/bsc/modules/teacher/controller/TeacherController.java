package com.bsc.modules.teacher.controller;
import com.bsc.common.persistence.BaseController;
import com.bsc.modules.teacher.entity.Teacher;
import com.bsc.modules.teacher.service.TeacherService;
import com.bsc.modules.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "teacher")
public class TeacherController extends BaseController{
    @Autowired
    private TeacherService teacherService;
    @RequestMapping(value = {"", "list"})
    private String list(Model model, Teacher teacher) {
        List<Teacher> teacherList = teacherService.findList(teacher);
        model.addAttribute("teacherList",teacherList);
        return "teacher/list";
    }


    /**
     * 查询teacher详情信息
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    private String get(Model model, @PathVariable Integer id) {
        Teacher teacher = teacherService.get(id);
        model.addAttribute("teacher", teacher);
        return "teacher/detail";
    }

    /**
     * 删除teacher
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/del/{id}")
    private String del(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        String msg = "删除失败";
        int successNum = teacherService.delete(id);
        if(successNum > 0) {
            msg = "成功删除" + successNum + "条记录";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/teacher/list";
    }

    /**
     * 编辑teacher（添加或修改）
     * @param model
     * @param teacher
     * @return
     */
    @RequestMapping("/edit/{id}")
    private String edit(@PathVariable Integer id,Model model,Teacher teacher) {
        if (id != null) {
            teacher = teacherService.get(id);
        }
        model.addAttribute("teacher", teacher);
        return "teacher/edit";
    }

    /**
     * 保存teacher（添加或修改）
     * @param teacher
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = {"/save","/save/{id}"})      //传id是编辑，不传id是添加
    private String save(Teacher teacher, RedirectAttributes redirectAttributes){
        String msg="保存失败！";
        int successNum=0;
        if (teacher.getId()==null){
            successNum=teacherService.insert(teacher);
        }
        else {
            successNum=teacherService.update(teacher);
        }
        if (successNum>0){
            msg="保存成功"+successNum+"条记录";
        }
        redirectAttributes.addFlashAttribute("msg",msg);
        return "redirect:/teacher/list";
    }

    /*
     *添加
     *@param model
     *@param model
     *@return
     * */
    @RequestMapping("/add")
    private String add(Teacher teacher,Model model){
        teacher=new Teacher();
        model.addAttribute("teacher",teacher);
        return "teacher/add";
    }
}
