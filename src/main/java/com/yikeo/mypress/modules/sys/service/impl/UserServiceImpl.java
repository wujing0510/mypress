package com.yikeo.mypress.modules.sys.service.impl;

import com.yikeo.mypress.common.service.MessageService;
import com.yikeo.mypress.modules.sys.dto.RegisterVo;
import com.yikeo.mypress.modules.sys.model.User;
import com.yikeo.mypress.modules.sys.repository.UserRepository;
import com.yikeo.mypress.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageService messageSource;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = userRepository.findByUsername(username);
        if (users.size() > 0) {
            return users.get(0);
        }
        throw new UsernameNotFoundException(messageSource.getMessage("message.usernameOrPasswordError"));
    }

    public void register(RegisterVo registerVo) {
        User user = new User();
        user.setUuid(UUID.randomUUID().toString().toUpperCase());
        user.setUsername(registerVo.getUsername());
        user.setPassword(registerVo.getPassword());
        user.setEmail(registerVo.getEmail());
        user.setFirstName(null);
        user.setLastName(null);
        user.setGender(null);
        user.setNickname(registerVo.getUsername());
        user.setBirthDate(null);
        user.setJoinedDate(new Date());
        user.setLastLoginDate(null);
        user.setActivatedDate(new Date());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
    }
}
