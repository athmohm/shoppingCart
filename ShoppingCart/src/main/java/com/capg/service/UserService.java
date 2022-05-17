package com.capg.service;

import java.util.List;
import java.util.Optional;

import com.capg.entity.User;
import com.capg.exception.NotFoundException;


public interface UserService {
	public String createUser(User user) throws NotFoundException;

	public List<User> viewUser() throws NotFoundException;

	public String logOutService();

	public String loginService(int userId, String userPassword) throws NotFoundException;

	public User updateUser(User user) throws NotFoundException;

	public Optional<User> findUserById(int userId) throws NotFoundException;

	public String delete(int userId) throws NotFoundException;

}