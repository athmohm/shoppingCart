package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.User;
import com.capg.exception.NotFoundException;
import com.capg.repository.UserRepository;

@Service
public class UserImplementation implements UserService {
	int log = 0;

	@Autowired
	UserRepository userRepository;

	@Override
	public String createUser(User user) throws NotFoundException {
		if (user != null) {
			userRepository.save(user);
			return "user Added Successfully";
		} else {
			throw new NotFoundException("Invalid user");
		}

	}

	public List<User> viewUser() throws NotFoundException {
		if (log == 1 || log == 2 || log == 3) {
			List<User> user = userRepository.findAll();
			if (user != null) {
				return user;
			}
		} else {
			throw new NotFoundException("Add users");
		}
		throw new NotFoundException("Please Login");
	}

	public String logOutService() {
		log = 0;
		return "Logged Out Successfully";
	}

	public String loginService(int userId, String userPassword) throws NotFoundException {

		if (userRepository.existsById(userId)) {
			String password = userRepository.getPassword(userId);
			if (password.equals(userPassword)) {
				User user = userRepository.getById(userId);

				if (user.getRole().equalsIgnoreCase("Customer")) {
					log = 1;
					System.out.println("Logged in as Customer");
					return user.getRole();

				} else if (user.getRole().equalsIgnoreCase("Admin")) {
					log = 2;
					System.out.println("Logged in as Admin");
					return user.getRole();

				} else if (user.getRole().equalsIgnoreCase("Vendor")) {
					log = 3;
					System.out.println("Logged in as Vendor");
					return user.getRole();

				}

			} else {
				throw new NotFoundException("Incorrect UserId or User Password");
			}

		} else {
			throw new NotFoundException("You are not a registered user, please sign-in to continue");
		}
		return null;

	}

	@Override
	public User updateUser(User user) throws NotFoundException {
		if (log == 2) {
			if (userRepository.existsById(user.getUserId())) {
				return userRepository.save(user);
			} else {
				return null;
			}
		}
		throw new NotFoundException("Login as Admin");

	}

	@Override
	public Optional<User> findUserById(int userId) throws NotFoundException {
		if (userRepository.existsById(userId)) {
			return userRepository.findById(userId);
		} else {
			throw new NotFoundException("Invalid userId");
		}

	}

	@Override
	public String delete(int userId) throws NotFoundException {
		if (log == 2) {
			if (userRepository.existsById(userId)) {
				userRepository.deleteById(userId);
				return "user deleted";
			} else {
				throw new NotFoundException("Invalid userId");
			}
		}
		throw new NotFoundException("Login as Admin");
	}
}