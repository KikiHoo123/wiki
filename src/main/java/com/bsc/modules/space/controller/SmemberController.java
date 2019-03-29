package com.bsc.modules.space.controller;
import com.bsc.common.utils.DictUtils;
import com.bsc.modules.space.entity.Smember;
import com.bsc.modules.space.service.SmemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
/**
 * @author YangRui
 */
@Controller
@RequestMapping("smember")
public class SmemberController {
    @Autowired    //创建实体后直接能使用getset
    private SmemberService smemberService;
    @RequestMapping(value = {"/list", "/", ""})
    private String list(Model model, Smember smember) {
        List<Smember> smemberList = smemberService.findList(smember);
        for (int i = 0;i<smemberList.size();i++){
            smemberList.get(i).setType(DictUtils.getDictLabel(smemberList.get(i).getType(),"MEMBER"));
        }
        model.addAttribute("smemberList", smemberList);
        return "smember/list";
    }
    /**
     * 查询详情信息
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    private String get(Model model, @PathVariable Integer id) {
        Smember smember = smemberService.get(id);
        smember.setType(DictUtils.getDictLabel(smember.getType(),"MEMBER"));
        model.addAttribute("smember", smember);
        return "smember/view";
    }
    /**
     * 删除模块
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/del/{id}")
    private String del(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        String msg = "删除失败";
        int successNum = smemberService.delete(id);
        if(successNum > 0) {
            msg = "成功删除" + successNum + "条记录";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/smember/list";
    }
    /**
     * 编辑（添加或修改）
     * @param model
     * @param smember
     * @return
     */
    @RequestMapping("/edit/{id}")
    private String edit(@PathVariable Integer id,Model model, Smember smember) {
        if (id != null) {
            smember = smemberService.get(id);
            smember.setType(DictUtils.getDictLabel(smember.getType(),"MEMBER"));
        }
        model.addAttribute("smember", smember);
        return "smember/edit";
    }
    @RequestMapping("/add")
    public String add(Model model, Smember smember){
        smember=new Smember();
        model.addAttribute("smember",smember);
        return "smember/edit";
    }
    /**
     * 保存（添加或修改）
     * @param smember
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = {"/save","/save/{id}"})
    private String save(Smember smember,RedirectAttributes redirectAttributes) {
        String msg = "保存失败";
        int successNum = 0;
        if (smember.getId() == null) {
            successNum = smemberService.insert(smember);
        } else {
            successNum = smemberService.update(smember);
        }
        if (successNum > 0) {
            msg = "保存成功";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/smember/list";
    }
}
