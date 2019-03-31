package com.bsc.modules.interaction.controller;
import com.bsc.common.utils.DictUtils;
import com.bsc.modules.interaction.entity.Interaction;
import com.bsc.modules.interaction.service.InteractionService;
import com.bsc.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
/**
 * @author YangRui
 */
@Controller
@RequestMapping("interaction")
public class InteractionController {
    @Autowired    //创建实体后直接能使用getset
    private InteractionService interactionService;
    @Autowired
    private UserService userService;
    @RequestMapping(value = {"/list", "/", ""})
    private String list(Model model, Interaction interaction) {
        List<Interaction> interactionList = interactionService.findList(interaction);
        for (int i = 0;i<interactionList.size();i++){
            interactionList.get(i).setType(DictUtils.getDictLabel(interactionList.get(i).getType(),"INTERACT"));
        }
        model.addAttribute("interactionList", interactionList);
        return "interaction/list";
    }
    /**
     * 查询
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    private String get(Model model, @PathVariable Integer id) {
        Interaction interaction = interactionService.get(id);
        interaction.setType(DictUtils.getDictLabel(interaction.getType(),"INTERACT"));
        model.addAttribute("interaction", interaction);
        return "interaction/view";
    }
    /**
     * 删除
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/del/{id}")
    private String del(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        String msg = "删除失败";
        int successNum = interactionService.delete(id);
        if(successNum > 0) {
            msg = "成功删除" + successNum + "条记录";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/interaction/list";
    }
    /**
     * 编辑（添加或修改）
     * @param model
     * @param interaction
     * @return
     */
    @RequestMapping("/edit/{id}")
    private String edit(@PathVariable Integer id,Model model, Interaction interaction) {
        if (id != null) {
            interaction = interactionService.get(id);
            interaction.setType(DictUtils.getDictLabel(interaction.getType(),"INTERACT"));
        }
        model.addAttribute("interaction", interaction);
        return "interaction/edit";
    }
    @RequestMapping("/add")
    public String add(Model model, Interaction interaction){
        interaction=new Interaction();
        model.addAttribute("interaction",interaction);
        return "interaction/edit";
    }
    /**
     * 保存（添加或修改）
     * @param interaction
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = {"/save","/save/{id}"})
    private String save(Interaction interaction,RedirectAttributes redirectAttributes) {
        String msg = "保存失败";
        int successNum = 0;
        Date date=new Date();
        Timestamp timestamp=new Timestamp(date.getTime());
        interaction.setTime(timestamp.toString().substring(0,19));
        if (interaction.getId() == null) {
            successNum = interactionService.insert(interaction);
        } else {
            successNum = interactionService.update(interaction);
        }
        if (successNum > 0) {
            msg = "保存成功";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/interaction/list";
    }
    /*
    * 获取当前用户收藏的空间
    * */
    @RequestMapping(value="/collect/{id}")
    private String collect(Interaction interaction,Model model,@PathVariable Integer id){
        interaction.setUserID(userService.get(id));
        interaction.setType("3");
        List<Interaction> interactionList=interactionService.findList(interaction);
        model.addAttribute("interactionList",interactionList);
        return "/interaction/list";
    }
    /*
    * 获取最近收藏的10个空间
    * */
    @RequestMapping(value = "/lastcollect/{id}")
    private String lastcollect(Interaction interaction,Model model,@PathVariable Integer id){
        interaction.setUserID(userService.get(id));
        interaction.setType("3");
        List<Interaction> interactionList=interactionService.findList(interaction);
        if (interactionList.size()>10){
            interactionList=interactionList.subList(0,10);
        }
        model.addAttribute("interactionList",interactionList);
        return "";
    }
}
