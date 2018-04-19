package com.yikeo.mypress.modules.sys.service;

import com.yikeo.mypress.modules.sys.dto.RegisterVo;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void register(RegisterVo registerVo);
    
}
