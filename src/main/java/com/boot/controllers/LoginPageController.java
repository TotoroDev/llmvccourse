package com.boot.controllers;

import com.boot.beans.LoginForm;
import com.boot.beans.User;
import com.boot.constants.configProperties.ExceptionProperties;
import com.boot.exceptions.UserAuthorizationException;
import com.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

import static com.boot.constants.Constant.Attributes.LOGIN_FORM;
import static com.boot.constants.Constant.Attributes.NEW_USER;
import static com.boot.constants.Constant.Urls.*;

@Controller
@RequestMapping("/login")
public class LoginPageController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExceptionProperties exceptionProperties;

    @GetMapping
    public String getLoginPage() {
        return LOGIN_PAGE;
    }

    @PostMapping
    public String login(@ModelAttribute("loginForm") LoginForm loginForm) throws UserAuthorizationException {
        final User user = userRepository.searchUserByName(loginForm.getUsername());
        if (Objects.nonNull(user)) {
            if (!user.getPassword().equals(loginForm.getPassword())) {
                throw new UserAuthorizationException(exceptionProperties.getInvalidPassword());
            }
        } else {
            throw new UserAuthorizationException(exceptionProperties.getInvalidUsername());
        }
        System.out.println("everything is fine, redirect to login");
        return "redirect:/goToSearch";
    }

    @ExceptionHandler(value = UserAuthorizationException.class)
    public String handleException(UserAuthorizationException exception, Model model) {
        model.addAttribute("exception", exception.getMessage());
        return ERROR_PAGE;
    }

    @ModelAttribute(LOGIN_FORM)
    public LoginForm getDefaultLoginForm() {
        return new LoginForm();
    }

    @ModelAttribute(NEW_USER)
    public User getDefaultUser() {
        return new User();
    }
}
