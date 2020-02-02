package com.boot.controllers;

import com.boot.beans.User;
import com.boot.facades.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.boot.constants.Constant.Attributes.*;
import static com.boot.constants.Constant.Messages.USER_REGISTERED_SUCCESSFULLY;
import static com.boot.constants.Constant.Urls.LOGIN_PAGE;
import static com.boot.constants.Constant.Urls.REGISTRATION_PAGE;
import static com.boot.constants.Constant.User.Gender.*;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserFacade userFacade;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
        binder.addValidators();
    }

    @GetMapping
    public String getRegistrationPage() {
        return REGISTRATION_PAGE;
    }

    @PostMapping
    public String registerUser(@Valid @ModelAttribute("newuser") final User user, final BindingResult bindingResult, final Model model) {
        if (bindingResult.hasErrors()) {
            return REGISTRATION_PAGE;
        }
        userFacade.registerUser(user);
        model.addAttribute(DATA_SAVED, USER_REGISTERED_SUCCESSFULLY);
        return LOGIN_PAGE;
    }

    @ModelAttribute(NEW_USER)
    public User getDefaultUser() {
        return new User();
    }

    @ModelAttribute(GENDER_ITEMS)
    public List<String> getGenderItems() {
        return Arrays.asList(MALE, FEMALE, OTHER);
    }
}
