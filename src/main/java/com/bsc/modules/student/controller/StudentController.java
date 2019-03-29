package com.bsc.modules.student.controller;
import com.bsc.common.persistence.BaseController;
import com.bsc.common.utils.DictUtils;
import com.bsc.modules.student.entity.Student;
import com.bsc.modules.student.service.StudentService;
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
@RequestMapping(value = "student")
public class StudentController extends BaseController{
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = {"", "list"})
    private String list(Model model, Student student) {
        List<Student> studentList = studentService.findList(student);
        model.addAttribute("studentList",studentList);
        return "student/list";
    }


    /**
     * 查询student详情信息
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    private String get(Model model, @PathVariable Integer id) {
        Student student = studentService.get(id);
        model.addAttribute("student", student);
        return "student/detail";
    }

    /**
     * 删除student
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/del/{id}")
    private String del(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        String msg = "删除失败";
        int successNum = studentService.delete(id);
        if(successNum > 0) {
            msg = "成功删除" + successNum + "条记录";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/student/list";
    }

    /**
     * 编辑student（添加或修改）
     * @param model
     * @param student
     * @return
     */
    @RequestMapping("/edit/{id}")
    private String edit(@PathVariable Integer id,Model model,Student student) {
        if (id != null) {
            student = studentService.get(id);
        }
        model.addAttribute("student", student);
        return "student/edit";
    }
    @RequestMapping("/add")
    public String add(Model model,Student student){
        student=new Student();
        model.addAttribute("student",student);
        return "student/edit";
    }

    /**
     * 保存student
     * @param student
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = {"/save","/save/{id}"})    //传id是编辑，不传id是添加
    private String save(Student student, RedirectAttributes redirectAttributes){
        String msg="保存失败！";
        int successNum=0;
        if (student.getId()==null){
            successNum=studentService.insert(student);
        }
        else {
            successNum=studentService.update(student);
        }
        if (successNum>0){
            msg="保存成功"+successNum+"条记录";
        }
        redirectAttributes.addFlashAttribute("msg",msg);
        return "redirect:/student/list";
    }

}
