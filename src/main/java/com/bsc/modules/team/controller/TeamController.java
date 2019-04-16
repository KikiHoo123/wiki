package com.bsc.modules.team.controller;

import com.bsc.modules.space.entity.Space;
import com.bsc.modules.space.service.SpaceService;
import com.bsc.modules.team.entity.Team;
import com.bsc.modules.team.entity.Tmember;
import com.bsc.modules.team.service.TeamService;
import com.bsc.modules.team.service.TmemberService;
import com.bsc.modules.user.entity.User;
import com.bsc.modules.user.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    private SpaceService spaceService;
    @Autowired
    private HttpSession session;
    @Autowired
    private HttpServletRequest request;
    @RequestMapping(value = {"","list"})
    private String list(Model model,Team team){
        int pageNum=1;
        if(request.getParameter("pageNum")==null || "".equals(request.getParameter("page"))){
            pageNum=1;
        }
        else{
            pageNum=Integer.parseInt(request.getParameter("pageNum"));
        }
        PageHelper.startPage(pageNum, 5);
        List<Team> teamList=teamService.findList(team);
        PageInfo<Team> spacePageInfo = new PageInfo<>(teamList);//得到分页中的space条目对象
        List<Team> pageList = spacePageInfo.getList();
        model.addAttribute("pageInfo" , pageList); //将结果存入model进行传送
        model.addAttribute("teamList",teamList);
        return "team/list";
    }
    @RequestMapping(value = "/detail/{id}")
    private String detail(Space space,Model model,@PathVariable Integer id){
        space=spaceService.get(id);
        model.addAttribute("space",space);
        return "team/teamSpace";
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
    private String save(Team team, RedirectAttributes redirectAttributes,@RequestParam("tmember") String []users){
        String msg="保存失败！";
        int successNum=0;
        if(team.getId()==null){
            Date date=new Date();
            Timestamp timestamp=new Timestamp(date.getTime());
            team.setTime(timestamp.toString().substring(0,19));
            team.setCreator((User) session.getAttribute("user"));
            successNum=teamService.insert(team);
            Tmember tmember=new Tmember();
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
