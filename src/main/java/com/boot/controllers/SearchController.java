package com.boot.controllers;

import com.boot.beans.Product;
import com.boot.constants.Constant;
import com.boot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/search")
    public String doSearch(@RequestParam("search") final String search, final Model model) {
        final List<Product> products = productRepository.searchByName(search);
        model.addAttribute(Constant.Attributes.PRODUCTS, products);
        return Constant.Urls.SEARCH_PAGE;
    }

    @GetMapping("/goToSearch")
    public String getSearchPage() {
        return Constant.Urls.SEARCH_PAGE;
    }

}
