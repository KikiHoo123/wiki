package com.bsc.modules.team.controller;

import com.bsc.modules.team.entity.Tmember;
import com.bsc.modules.team.service.TmemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "tmember")
public class TmemberController {
    @Autowired
    private TmemberService tmemberService;
    @RequestMapping("/del/{id}")
    private String del(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        String msg="删除失败！";
        int successNum=tmemberService.delete(id);
        if (successNum>0)
            msg="删除成功"+successNum+"条记录";
        redirectAttributes.addFlashAttribute("msg",msg);
        return "redirect:/team/list";
    }
    /*
    * needn't use
    * */
    /*@RequestMapping("/edit/{id}")
    private String edit(@PathVariable Integer id, Model model, Tmember tmember){
        if (id!=null){
            tmember=tmemberService.get(id);
        }
        model.addAttribute("tmember",tmember);
        return "team/edit";
    }*/
    @RequestMapping("/add")
    private String add(Tmember tmember,Model model){
        tmember=new Tmember();
        model.addAttribute("tmember",tmember);
        return "team/add";
    }
    /*@RequestMapping("/edit")
    private String edit(Tmember tmember){

    }*/
    @RequestMapping(value = {"/save"})
    private String save(Tmember tmember,RedirectAttributes redirectAttributes){
        String msg="添加失败！";
        int successNum=0;
        if(tmember.getId()==null){
            successNum=tmemberService.insert(tmember);
        }
        if (successNum>0){
            msg="添加成功"+successNum+"名成员";
        }
        redirectAttributes.addFlashAttribute("msg",msg);
        return "redirect:/team/list";
    }
}
