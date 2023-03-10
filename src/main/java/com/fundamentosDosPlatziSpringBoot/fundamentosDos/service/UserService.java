
package com.fundamentosDosPlatziSpringBoot.fundamentosDos.service;

import com.fundamentosDosPlatziSpringBoot.fundamentosDos.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final Log LOG = LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
@Transactional
    public void saveTransactional(List<User> users){
        users.stream()
                .peek(user -> LOG.info("Usuario insertado: "+user));
                //.forEach(userRepository::save);
               // .forEach(user -> userRepository.save(user));
    }
}
