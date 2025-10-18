package com.geek.config;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.geek.service.UserService;
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
   private UserService service;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       com.geek.entity.User user = service.getUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUserName())
                .password(user.getPassword()) // encoded password
                .roles(user.getRole().replace("ROLE_", "")) // Spring Security adds ROLE_ automatically
                .build();
    }
}
