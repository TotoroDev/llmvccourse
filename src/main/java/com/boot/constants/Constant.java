package com.boot.constants;

import javax.print.DocFlavor;

public interface Constant {

    interface Urls {
        String HOME_PAGE = "home";
        String SEARCH_PAGE = "/search";
        String LOGIN_PAGE = "login";
        String REGISTRATION_PAGE = "register";
        String ERROR_PAGE = "error";
    }

    interface Attributes {
        String PRODUCTS = "products";
        String NEW_USER = "newuser";
        String GENDER_ITEMS = "genderItems";
        String DATA_SAVED = "dataSaved";
        String LOGIN_FORM = "loginForm";
    }

    interface User {
        interface Gender {
            String MALE = "Male";
            String FEMALE = "Female";
            String OTHER = "Other";
        }
    }

    interface Messages {
        String USER_REGISTERED_SUCCESSFULLY = "user registered successfully";
    }
}
