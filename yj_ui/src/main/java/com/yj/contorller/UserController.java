package com.yj.contorller;

import com.yj.feign.IUserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private IUserServiceFeign userServiceFeign;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("msg","欢迎光临");
        return "login";
    }

    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(String username,Model model){
        String user = userServiceFeign.getUserInfo(username);
        System.out.println(user);
        if (StringUtils.isEmpty(user) || user.equals("")){
            model.addAttribute("msg","用户名不存在");
            return "login";
        }else{
            return "redirect:/index";
        }
        //return "redirect:/index";
    }
}
