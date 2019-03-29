package com.bsc.modules.mail.controller;

import com.bsc.modules.mail.entity.Mail;
import com.bsc.modules.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "mail")
public class MailController {
    @Autowired
    private MailService mailService;
    @RequestMapping(value = {"", "list"})
    private String list(Model model, Mail mail) {
        List<Mail> mailList = mailService.findList(mail);
        model.addAttribute("mailList",mailList);
        return "mail/list";
    }

    @RequestMapping("/get/{id}")
    private String get(Model model, @PathVariable Integer id){
        Mail mail=mailService.get(id);
        model.addAttribute("mail",mail);
        return "mail/details";
    }
    @RequestMapping("/del/{id}")
    private  String del(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        String msg = "删除失败";
        int successNum = mailService.delete(id);
        if (successNum > 0) {
            msg = "删除成功" + successNum + "条记录";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/mail/list";
    }

    /**
     * 编辑私信（添加或修改）
     * @param model
     * @param mail
     * @return
     */
    @RequestMapping("/edit/{id}")
    private String edit(@PathVariable Integer id,Model model, Mail mail) {
        if (id != null) {
            mail = mailService.get(id);
        }
        model.addAttribute("mail", mail);
        return "mail/edit";
    }
    @RequestMapping("/add")
    private String add(Mail mail,Model model){
        mail=new Mail();
        model.addAttribute("mail",mail);
        return "mail/add";
    }

    /**
     * 保存私信（添加或修改）
     * @param mail
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = {"/save","/save/{id}"})
    private String save(Mail mail, RedirectAttributes redirectAttributes) {
        String msg = "保存失败！";
        int successNum = 0;
        Date date=new Date();
        Timestamp timestamp=new Timestamp(date.getTime());
        mail.setTime(timestamp.toString().substring(0,19));
        if (mail.getId() == null) {
            successNum = mailService.insert(mail);
        } else {
            successNum = mailService.update(mail);
        }
        if (successNum > 0) {
            msg = "保存成功" + successNum + "条记录";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/mail/list";
    }
}
