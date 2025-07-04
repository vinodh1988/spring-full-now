package com.rest.services;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rest.entities.User;
import com.rest.repositories.UserRepository;







@Service
public class UserService implements UserDetailsService {
@Autowired
    private UserRepository userRepository;
    

    private PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();;
    
 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		   User user = userRepository.findUserByUsername(username);
	        if (user == null) {
	            throw new UsernameNotFoundException("User not found with username: " + username);
	        }
	        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),new ArrayList());
	}

    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
