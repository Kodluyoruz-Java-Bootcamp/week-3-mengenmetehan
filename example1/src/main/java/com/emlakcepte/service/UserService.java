package com.emlakcepte.service;


import com.emlakcepte.model.Realty;
import com.emlakcepte.model.User;
import com.emlakcepte.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

//@Service // kapalı çünkü @Bean olarak tanımladık fakat bu da doğru bir yöntem
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// Singleton Pattern
	/*
	 * private static UserService userService = new UserService();
	 * 
	 * private UserService() {
	 * 
	 * }
	 * 
	 * public static UserService getDifferentInstance() { return new UserService();
	 * }
	 * 
	 * public static UserService getSameInstance() { return userService; }
	 */
	public void createUser(User user) {
		// UserDao userDao = new UserDao(); tekrar tekrar oluşturmamıza gerek yok
		System.out.println("ben bir userDao objesiyim:" + userRepository.toString());

		if (user.getPassword().length() < 5) {
			System.out.println("Şifre en az 5 karakterli olmalı");
		}
		userRepository.createUser(user);
		System.out.println("[createUser] user oluşturuldu :: " + user);
	}

	public List<User> getAllUser() {
		// UserDao userDao = new UserDao();
		return userRepository.findAllUsers();
	}

	public void printAllUser() {

		getAllUser().forEach(user -> System.out.println(user.getName()));

	}

	public void updatePassword(User user, String newPassword) {
		getAllUser().stream()
				.filter(u -> u.equals(user))
				.forEach(u -> u.setPassword(newPassword));
	}

	public User getByEmail(String email) {

		//// @formatter:off
		return userRepository.findAllUsers()
				.stream()
				.filter(user -> user.getMail().equals(email))
				.findFirst()
				.get();
		// @formatter:on
	}

	public Realty saveRecordedRealty (User user, Realty realty)
	{
		Optional<User> us = getAllUser().stream()
				.filter(u -> u.getName().equals(user.getName()))
				.findFirst();

		us.ifPresent(u -> u.saveRecordedRealty(realty));

		return realty;
	}

	public List<Realty> getRecordedRealty (User user)
	{
		return getAllUser().stream()
				.filter(u -> u.getName().equals(user.getName()))
				.map(User::getRecordedRealtyList)
				.flatMap(Collection::stream)
				.toList();
	}



}
