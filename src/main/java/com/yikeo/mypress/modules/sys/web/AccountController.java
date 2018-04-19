package com.yikeo.mypress.modules.sys.web;

import com.yikeo.mypress.common.web.BaseController;
import com.yikeo.mypress.modules.sys.dto.RegisterVo;
import com.yikeo.mypress.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller("sys.web.account")
@RequestMapping("/account")
public class AccountController extends BaseController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "login")
    public String login(Model model) {
        return getViewUrl("sys/account/login");
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("registerVo", new RegisterVo());
        return getViewUrl("sys/account/register");
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String registerPost(@ModelAttribute @Valid RegisterVo registerVo, BindingResult result, Model model) {

        if (registerVo.getPassword() != null && !registerVo.getPassword().equals(registerVo.getRepeatPassword())) {
            result.rejectValue("repeatPassword", "message.passwordDoNotMatch");
        }
        if (result.hasErrors()) {
            model.addAttribute("registerVo", registerVo);
            return getViewUrl("sys/account/register");
        }

        userService.register(registerVo);

        return getViewUrl("sys/account/registerSuccess");
    }

    @RequestMapping(value = "findPws")
    public String findPws(Model model) {
        return getViewUrl("sys/account/findPws");
    }

}