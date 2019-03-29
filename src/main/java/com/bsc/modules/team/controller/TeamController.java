package com.bsc.modules.team.controller;

import com.bsc.modules.team.entity.Team;
import com.bsc.modules.team.entity.Tmember;
import com.bsc.modules.team.service.TeamService;
import com.bsc.modules.team.service.TmemberService;
import com.bsc.modules.user.entity.User;
import com.bsc.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "team")
public class TeamController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private TmemberService tmemberService;
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest request;
    @RequestMapping(value = {"","list"})
    private String list(Model model,Team team){
        List<Team> teamList=teamService.findList(team);
        model.addAttribute("teamList",teamList);
        return "team/list";
    }
    @RequestMapping("/get/{id}")
    private String get(Model model, @PathVariable Integer id,Tmember tmember){
        Team team=teamService.get(id);
        model.addAttribute("team",team);
        List<Tmember> tmemberList=tmemberService.findListForgein(team,tmember);
        model.addAttribute("tmemberList",tmemberList);
        return "team/details";
    }
    @RequestMapping("/del/{id}")
    private String del(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        String msg="删除失败！";
        int successNum=teamService.delete(id);
        if (successNum>0)
            msg="删除成功"+successNum+"条记录";
        redirectAttributes.addFlashAttribute("msg",msg);
        return "redirect:/team/list";
    }
    @RequestMapping("/edit/{id}")
    private String edit(@PathVariable Integer id,Model model,Team team,Tmember tmember){
        if (id!=null){
            team=teamService.get(id);
        }
        model.addAttribute("team",team);
        List<Tmember> tmemberList=tmemberService.findListForgein(team,tmember);
        model.addAttribute("tmemberList",tmemberList);
        return "team/edit";
    }
    @RequestMapping("/add")
    private String add(Team team,Model model,User user){
        model.addAttribute("team",team);
        List<User> userList=userService.findList(user);
        model.addAttribute("userList",userList);
        return "team/add";
    }
    @RequestMapping(value = {"/save","/save/{id}"})
    private String save(Team team,RedirectAttributes redirectAttributes,Tmember tmember){
        String msg="保存失败！";
        int successNum=0;
        if(team.getId()==null){
            Date date=new Date();
            Timestamp timestamp=new Timestamp(date.getTime());
            team.setTime(timestamp.toString().substring(0,19));
            successNum=teamService.insert(team);
            String []users=request.getParameterValues("tmember");
            for(int i = 0; i<users.length; i++){
                tmember.setTeam(team);
                tmember.setMember(userService.get(Integer.valueOf(users[i])));
                tmemberService.insert(tmember);
            }
        }
        else {
            successNum=teamService.update(team);
        }
        if (successNum>0){
            msg="保存成功"+successNum+"条记录";
        }
        redirectAttributes.addFlashAttribute("msg",msg);
        return "redirect:/team/list";
    }
}