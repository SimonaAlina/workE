package com.endava.webfundamentals.signin.controller;

import com.endava.webfundamentals.signin.dto.UserCredentialDTO;
import com.endava.webfundamentals.signin.dto.UserRegisterDTO;
import com.endava.webfundamentals.signin.service.AuthenticationService;
import com.endava.webfundamentals.signin.service.UserService;
import com.endava.webfundamentals.signin.validator.UserRegisterValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRegisterValidator userRegisterValidator;

    @Resource(name = "${spring.bean.authentication}")
    private AuthenticationService authenticationService;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public Object doRegister(@ModelAttribute UserRegisterDTO userRegisterDTO,
                             BindingResult result, Model model) {
        System.out.println(userRegisterDTO);
        
        List<String> allMessages = new ArrayList<String>();
		for (ObjectError error : result.getAllErrors()) {
            allMessages.add(error.getDefaultMessage());
        }
        
        userRegisterValidator.validate(userRegisterDTO, result);
        if (result.hasErrors()) {
            model.addAttribute("message", allMessages);
            return "/register";
        }
        
        userService.saveUser(userRegisterDTO);

        RedirectView rv = new RedirectView("/user/login");
    	rv.setContextRelative(true);
        return rv;
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public Object doLogin(@ModelAttribute UserCredentialDTO userCredentialDTO, Model model,
                          HttpServletRequest request, HttpServletResponse response) {
    	if (authenticationService.login(userCredentialDTO, request, response)) {
    		RedirectView rv = new RedirectView("/dashboard");
        	rv.setContextRelative(true);
            return rv;
        } else {
            model.addAttribute("message", "Wrong user or password!");
            response.setStatus(SC_UNAUTHORIZED);
        }
        return "login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public RedirectView logout(HttpServletRequest request, HttpServletResponse response) {
        authenticationService.logout(request, response);
        RedirectView rv = new RedirectView("/");
    	rv.setContextRelative(true);
        return rv;
    }

}
