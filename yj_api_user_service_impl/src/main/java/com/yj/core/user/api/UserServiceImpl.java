package com.yj.core.user.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{
    private final static Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public String getUserInfo(String username) {
        logger.info("my name is zhangtao");
        return "my name is zhangtao";
    }
}
