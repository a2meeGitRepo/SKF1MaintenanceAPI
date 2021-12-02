package com.maintenance.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.maintenance.model.Usermst;
import com.maintenance.repo.UserMstRepo;
import com.maintenance.repo.UserRepo;


@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	UserRepo userRepo;
	@Autowired
	UserMstRepo usermstRepo;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		try {
			Usermst usermst=userRepo.findByUserName(userName);
		
			return new User(usermst.getUsername(), usermst.getPassword(),
	                new ArrayList<>());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null; 
		}
		
		
    }

	/**
	 * @param userId
	 * @param password
	 * @return
	 */
	public Usermst getUserByUserNamePassword(String userId, String password) {
		// TODO Auto-generated method stub
		return userRepo.getUserByUserNamePassword(userId,password);
	}

	/**
	 * @param usermst
	 */
	public void saveUserMst(Usermst usermst) {
		// TODO Auto-generated method stub
		usermstRepo.save(usermst);
	}

	/**
	 * @return
	 */
	public String getNewUserName() {
		// TODO Auto-generated method stub
		String maxId=usermstRepo.getMaxId();
		System.out.println("MAX ID :: "+maxId);
		return maxId;
	}



}
