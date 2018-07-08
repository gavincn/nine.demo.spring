package com.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by pingping on 三月/31/15.
 */
public class MyAuthentication implements UserDetailsService{

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        MyUserDetals userDetails = new MyUserDetals();
        userDetails.setUsername("liu");
        userDetails.setPassword("liu");
        userDetails.setRole("ROLE_USER");
        return userDetails;
    }
}
