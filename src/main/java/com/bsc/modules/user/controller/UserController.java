package com.bsc.modules.user.controller;
import com.bsc.common.persistence.BaseController;
import com.bsc.modules.user.dao.UserMapper;
import com.bsc.modules.user.entity.User;
import com.bsc.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;
import java.util.List;


/*import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tss.common.json.ResponseResult;*/

@Controller
@RequestMapping(value = "user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"", "list"})
    private String list(Model model, User user) {
        List<User> userList = userService.findList(user);
        model.addAttribute("userList", userList);
        return "user/list";
    }


    /**
     * 查询user详情信息
     *
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    private String get(Model model, @PathVariable Integer id) {
        User user = userService.get(id);
        model.addAttribute("user", user);
        return "user/detail";
    }

    /**
     * 删除user
     *
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/del/{id}")
    private String del(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        String msg = "删除失败";
        int successNum = userService.delete(id);
        if (successNum > 0) {
            msg = "成功删除" + successNum + "条记录";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/user/list";
    }

    /**
     * 编辑用户（添加或修改）
     *
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/edit/{id}")
    private String edit(@PathVariable Integer id, Model model, User user) {
        if (id != null) {
            user = userService.get(id);
        }
        model.addAttribute("user", user);
        return "user/edit";
    }

    @RequestMapping("/add")
    public String add(Model model, User user) {
        user = new User();
        model.addAttribute("user", user);
        return "user/add";
    }

    /**
     * 保存用户（添加或修改）
     *
     * @param user
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = {"/save", "/save/{id}"})   //传id是编辑，不传id是添加
    private String save(User user, RedirectAttributes redirectAttributes) {
        String msg = "保存失败！";
        int successNum = 0;
        if (user.getId() == null) {
            successNum = userService.insert(user);
        } else {
            successNum = userService.update(user);
        }
        if (successNum > 0) {
            msg = "保存成功" + successNum + "条记录";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/user/list";
    }


    /**
     * 用户登录验证
     *
     * @param num
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public String login(@RequestParam("num") String num, @RequestParam("password") String password,
                        HttpSession session) {
        String msg;
        User u=new User();
        u.setNum(num);
        User user = userService.getT(u);
        if (user == null || user.getId() == null || user.getId() == ' ') {         //判断是否获取到用户实体
            msg = "账号不存在";   //用户不存在
            return "redirect:login.jsp";
        } else if (user.getPassword().equals(password)) {           //密码匹配，则登陆成功
            session.setAttribute("user", user);
            msg = "登陆成功";   //登陆成功
            return "/home";
        } else {                                                //账号密码不匹配，登陆失败
            msg = "密码错误";   //密码错误，登录失败
            return "redirect:login.jsp";
        }
    }


        /**
         *登出
         * @param session
         * @param sessionStatus
         * @return 返回到登陆界面
         */
        @RequestMapping("/loginOut")
        public String loginOut (HttpSession session, SessionStatus sessionStatus){
            session.invalidate();
            sessionStatus.setComplete();
            return "redirect:login.jsp";
        }

        @RequestMapping("/home")      //返回首页
        public String toIndex () {
            return "/home";
        }
        @RequestMapping("/person")
    public String person(){
            return "/person";
        }
    }

