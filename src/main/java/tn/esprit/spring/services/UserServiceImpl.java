package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;


	private static final Logger L = LogManager.getLogger(UserServiceImpl.class);
	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {

			L.info("In Method retrieveAllUsers :");
			users = (List<User>) userRepository.findAll();
			L.debug("connection a la base de donner ");
			
			for (User user : users) {

				L.debug("user :" + user.getLastName());
			} 

			L.info("Out of Method retrieveAllUsers with Success");
		}catch (Exception e) {

			L.error("Out of Method retrieveAllUsers withh Errors :" + e);
		}

		return users;
	}


	@Override
	public User addUser(User u) {

		L.info("In Method addUSer :");
		User u_saved = userRepository.save(u); 

		L.info("Out of Method addUser with Success");
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) { 

		L.info("In Method updateUSer :");
		User u_saved = userRepository.save(u); 

		L.info("Out of Method updateUser with Success");
		return u_saved; 
	}

	@Override
	public void deleteUser(String id) {

		L.info("In Method deleteUser :");
		userRepository.deleteById(Long.parseLong(id)); 

		L.info("Out of Method deleteUser with Success");
	}

	@Override
	public User retrieveUser(String id) {
	
		L.info("In Method retrieveUsers :");
	
	User u = new User();
		L.info("Out of Method retrieveUsers with Success");
		return u; 
	}

}
