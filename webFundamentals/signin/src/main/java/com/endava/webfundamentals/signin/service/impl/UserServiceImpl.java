package com.endava.webfundamentals.signin.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.endava.webfundamentals.signin.dto.UserRegisterDTO;
import com.endava.webfundamentals.signin.model.User;
import com.endava.webfundamentals.signin.repository.UserRepository;
import com.endava.webfundamentals.signin.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Mapper mapper;
	
	@Override
	public UserRegisterDTO saveUser(UserRegisterDTO userRegisterDTO) {
      User user = new User(userRegisterDTO.getUsername(), userRegisterDTO.getPassword());
      UserRegisterDTO r = mapper.map(userRepository.save(user), UserRegisterDTO.class);
      return r;
	}

	@Override
	public List<UserRegisterDTO> findAll() {
		List<UserRegisterDTO> users = Collections.emptyList();
        Iterable<User> userEntities = userRepository.findAll();
        if(userEntities != null) {
            users = new ArrayList<UserRegisterDTO>();
            for(User userEntity : userEntities) {
                users.add(mapper.map(userEntity, UserRegisterDTO.class));
            }
        }
        return users;
	}

	@Override
	public UserRegisterDTO findByUsername(String username) {
		User user = userRepository.findByUsername(username);
        return user != null ? mapper.map(user, UserRegisterDTO.class) : null;
	}

	@Override
	public UserRegisterDTO findByUsernameAndPassword(String username, String password) {
		User user = userRepository.findByUsernameAndPassword(username, password);
        return user != null ? mapper.map(user, UserRegisterDTO.class) : null;
	}

}
