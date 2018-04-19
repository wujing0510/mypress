package com.yikeo.mypress.modules.sys.web;

import com.yikeo.mypress.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("sys.web.site")
@RequestMapping("/site")
public class SiteController extends BaseController {

    @RequestMapping(value = "terms")
    public String terms(Model model) {
        return getViewUrl("sys/site/terms");
    }

    @RequestMapping(value = "privacy")
    public String privacy(Model model) {
        return getViewUrl("sys/site/privacy");
    }

    @RequestMapping(value = "contact")
    public String contact(Model model) {
        return getViewUrl("sys/site/contact");
    }

    @RequestMapping(value = "about")
    public String about(Model model) {
        return getViewUrl("sys/site/about");
    }

}
