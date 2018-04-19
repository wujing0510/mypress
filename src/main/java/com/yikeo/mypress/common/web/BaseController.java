package com.yikeo.mypress.common.web;

import com.yikeo.mypress.common.model.SessionSetting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession session;


    public String getViewUrl(String urlPath) {
        return "themes/" + getTheme() + "/" + urlPath;
    }

    public String getTheme() {
        String theme = "default";
        if (session != null) {
            SessionSetting sessionSetting = (SessionSetting) session.getAttribute("SESSION_SETTING");
            if (sessionSetting != null) {
                theme = sessionSetting.getTheme();
            }
        }
        return theme;
    }


    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
