package com.yj.ui.contorller;

import com.yj.ui.api.IUIService;
import com.yj.ui.feign.IEquptServiceFeign;
import com.yj.ui.feign.IUserServiceFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value="WEB开放接口",tags={"WEB开放接口"})
public class UserController {

    @Autowired
    private IUIService iuiService;

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

        return "redirect:/index";

    }
    @Autowired
    private IUserServiceFeign iUserServiceFeign;
    @Autowired
    private IEquptServiceFeign equptServiceFeign;

    @ApiOperation(value = "获取端口",notes = "获取服务所在端口")
    @RequestMapping(value = "/getApiInfo",method = {RequestMethod.GET})
    public String getPort(){
        return iuiService.getApiInfo() + " " + equptServiceFeign.getApiInfo();
    }
}
