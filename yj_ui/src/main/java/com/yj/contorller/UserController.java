package com.yj.contorller;

import com.yj.dto.User;
import com.yj.feign.IEquptServiceFeign;
import com.yj.feign.IUserServiceFeign;
import com.yj.utils.JsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value="WEB开放接口",tags={"WEB开放接口"})
public class UserController {

    @Autowired
    private IUserServiceFeign userServiceFeign;

    @Autowired
    private IEquptServiceFeign equptServiceFeign;

//    @RequestMapping("/")
//    public String index(Model model){
//        model.addAttribute("msg","欢迎光临");
//        return "index";
//    }
//
//    @RequestMapping("/index")
//    public String toIndex(){
//        return "index";
//    }
//
//    @RequestMapping("/toLogin")
//    public String toLogin(){
//        return "login";
//    }
//
//
//    @RequestMapping("/login")
//    public String login(String username,String password,Model model){
//        if(username == null){
//            model.addAttribute("msg","用户名不能为空");
//            return "login";
//        }
//
//        if(password == null){
//            model.addAttribute("msg","用户密码不能为空");
//            return "login";
//        }
//        /**
//         * 认证
//         */
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
//        String userInfo = userServiceFeign.getUserInfo(token.getUsername());
//        try{
//            subject.login(token);
//            model.addAttribute("msg","欢迎光临");
//            return "redirect:/index";
//        }catch (UnknownAccountException e){
//            model.addAttribute("msg","用户名不存在");
//            return "login";
//        }catch (IncorrectCredentialsException e){
//            model.addAttribute("msg","密码错误");
//            return "login";
//        }
//
//    }

    @Value("${server.port}")
    private String port;

    @ApiOperation(value = "获取端口",notes = "获取服务所在端口")
    @RequestMapping(value = "/getPort",method = {RequestMethod.GET})
    public String getPort(){
        Integer eqptId = 1;
        String eqptinfo = equptServiceFeign.getEquptInfo(eqptId);
        return "这是端口："+ port + "" + "设备为：" + eqptinfo;
    }
}
