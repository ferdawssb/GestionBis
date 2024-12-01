package tn.enig.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.enig.dao.IUserDao;
import tn.enig.model.User;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	IUserDao dao ;

	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User u = dao.findByUsername(username);
		if(u==null) {
			throw new UsernameNotFoundException("inexistant !!!!!");
			
		}
		return u;
	}

	
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findByUsername(username);
	}

	
	
	
}
