package com.yikeo.mypress.modules.admin.web;

import com.yikeo.mypress.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("admin.web.index")
@RequestMapping("/admin")
public class IndexController extends BaseController {

    @RequestMapping("")
    public String index(Model model) {
        return getViewUrl("admin/index");
    }

}
