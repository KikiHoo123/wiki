package com.bsc.modules.dict.controller;

import com.bsc.modules.dict.dao.DictMapper;
import com.bsc.modules.dict.entity.Dict;
import com.bsc.modules.dict.service.DictService;
import com.bsc.modules.student.entity.Student;
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
@RequestMapping(value = "dict")
public class DictController {
    @Autowired
    private DictService dictService;
    @RequestMapping(value = {"","list"})
    private String List(Model model, Dict dict){
        List<Dict>dictList=dictService.findList(dict);
        model.addAttribute("dictList",dictList);
        return"dict/list";
    }

    /**
     * 查询dict详情信息
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    private String get(Model model, @PathVariable Integer id) {
        Dict dict = dictService.get(id);
        model.addAttribute("dict", dict);
        return "dict/detail";
    }

    /**
     * 删除dict
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/del/{id}")
    private String del(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        String msg = "删除失败";
        int successNum = dictService.delete(id);
        if(successNum > 0) {
            msg = "成功删除" + successNum + "条记录";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/dict/list";
    }

    /**
     * 编辑dict（添加或修改）
     * @param model
     * @param dict
     * @return
     */
    @RequestMapping("/edit/{id}")
    private String edit(@PathVariable Integer id,Model model,Dict dict) {
        if (id != null) {
            dict = dictService.get(id);
        }
        model.addAttribute("dict", dict);
        return "dict/edit";
    }

    /**
     * 保存dict（添加或修改）
     * @param dict
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = {"/save","/save/{id}"})      //传id是编辑，不传id是添加
    private String save(Dict dict, RedirectAttributes redirectAttributes){
        String msg="保存失败！";
        int successNum=0;
        if (dict.getId()==null){
            successNum=dictService.insert(dict);
        }
        else {
            successNum=dictService.update(dict);
        }
        if (successNum>0){
            msg="保存成功"+successNum+"条记录";
        }
        redirectAttributes.addFlashAttribute("msg",msg);
        return "redirect:/dict/list";
    }

    /*
     *添加
     *@param model
     *@param model
     *@return
     * */
    @RequestMapping("/add")
    private String add(Dict dict, Model model){
        dict=new Dict();
        model.addAttribute("dict",dict);
        return "dict/add";
    }
}
