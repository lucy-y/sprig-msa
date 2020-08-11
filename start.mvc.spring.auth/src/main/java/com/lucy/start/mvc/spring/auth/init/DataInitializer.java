package com.lucy.start.mvc.spring.auth.init;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.lucy.start.mvc.spring.auth.security.User;
import com.lucy.start.mvc.spring.auth.security.UserDao;


@Component
public class DataInitializer implements ApplicationRunner {
	
	@Resource(name="UserDao")
	private UserDao userDao;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		User newUser = new User();	    
	    PasswordEncoder passwordEncoder;
	    passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	    newUser.setUsername("lucy");
		newUser.setPassword(passwordEncoder.encode("1234"));
		newUser.setUserType(0);
		newUser.setDate(new Date()); 
		userDao.save(newUser);
	}

}
