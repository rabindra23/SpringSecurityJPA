package com.masai.security.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.security.repository.EmployeeRepository;

@Service
public class CustomerUserDetailService implements UserDetailsService{

	@Autowired
	private EmployeeRepository empRepo;
	CustomUser user = null;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee emp = empRepo.findByUserName(username);
		
		if(emp!=null) {
			user = new CustomUser(emp);
		}
		
		return user;
	}

}
