package com.yikeo.mypress.modules.sys.web;

import com.yikeo.mypress.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("sys.web.index")
@RequestMapping
public class IndexController extends BaseController {

    @RequestMapping("")
    public String index(Model model) {
        return getViewUrl("sys/index");
    }

    @RequestMapping(value = "login")
    public String login(Model model) {
        return getViewUrl("sys/login");
    }

    @RequestMapping(value = "register")
    public String register(Model model) {
        return getViewUrl("sys/register");
    }

    @RequestMapping(value = "findPws")
    public String findPws(Model model) {
        return getViewUrl("sys/findPws");
    }


}
