package com.yj.contorller;

import com.yj.dto.User;
import com.yj.feign.IUserServiceFeign;
import com.yj.utils.JsonUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {

    @Autowired
    private IUserServiceFeign userServiceFeign;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("msg","欢迎光临");
        return "index";
    }

    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }


    @RequestMapping("/login")
    public String login(String username,String password,Model model){
        if(username == null){
            model.addAttribute("msg","用户名不能为空");
            return "login";
        }

        if(password == null){
            model.addAttribute("msg","用户密码不能为空");
            return "login";
        }
        /**
         * 认证
         */
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try{
            subject.login(token);
            model.addAttribute("msg","欢迎光临");
            return "redirect:/index";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "login";
        }

    }
}
