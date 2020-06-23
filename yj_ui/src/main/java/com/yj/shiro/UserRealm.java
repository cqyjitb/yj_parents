//package com.yj.shiro;
//
//import com.yj.ui.dto.User;
//import com.yj.ui.feign.IUserServiceFeign;
//import com.yj.utils.JsonUtil;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class UserRealm extends AuthorizingRealm {
//    @Autowired
//    private IUserServiceFeign userServiceFeign;
//    private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        logger.info("-----进入授权逻辑------");
//        return null;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        logger.info("-----进入验证逻辑------");
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        String userInfo = userServiceFeign.getUserInfo(token.getUsername());
//        if (userInfo == null){
//            return null;
//        }
//        return new SimpleAuthenticationInfo("",
//                JsonUtil.getObject(userInfo,User.class).getPassword(),"");
//    }
//}
