package com.yikeo.mypress.modules.sys.repository;


import com.yikeo.mypress.modules.sys.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUsername(String username);
}
