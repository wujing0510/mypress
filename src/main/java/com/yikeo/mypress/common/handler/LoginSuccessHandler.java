package com.yikeo.mypress.common.handler;

import com.yikeo.mypress.common.model.SessionSetting;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if(session != null) {
            SessionSetting setting = new SessionSetting();
            setting.setTheme("default");
            session.setAttribute("SESSION_SETTING", setting);
        }

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
