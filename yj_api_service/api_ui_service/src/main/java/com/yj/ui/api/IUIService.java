package com.yj.ui.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface IUIService {

    @RequestMapping(value = "/getApiInfo",method = {RequestMethod.GET})
    public String getApiInfo();


}
