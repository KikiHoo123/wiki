package com.bsc.modules.sys.controller;

import com.bsc.common.persistence.BaseController;
import com.bsc.modules.user.entity.User;
import com.bsc.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/sys")
public class SysController extends BaseController {
    @Autowired
    private UserService userService;
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
            return "sys/login";
        } else if (user.getPassword().equals(password)) {           //密码匹配，则登陆成功
            session.setAttribute("user", user);
            msg = "登陆成功";   //登陆成功
            return "sys/home";
        } else {                                                //账号密码不匹配，登陆失败
            msg = "密码错误";   //密码错误，登录失败
            return "sys/login";
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
        return "sys/login";
    }

    @RequestMapping("/home")      //返回首页
    public String toIndex () {
        return "sys/home";
    }
}
