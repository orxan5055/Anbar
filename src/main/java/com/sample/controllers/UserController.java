package com.sample.controllers;

import com.sample.model.Users;
import com.sample.repositories.UsersRepository;
import com.sample.services.ItemService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    private String user_role;

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    private ItemService anbarService;

    @RequestMapping("/")
    public String index(Model model) {
        return "login";
    }
    @RequestMapping("/list")
    public String userCheck(@RequestParam("username") String username,@RequestParam("password") String password,Model model){
        Users user = usersRepository.findByUsername(username);
        user_role = user.getUserRole();
        if(user.getUsername().equals(username) && user.getPassword().equals(password)){
        if(user.getUserRole().equals("admin")){
            model.addAttribute("listItems", anbarService.getAllItems());
            return "profileAdmin";
        }
        else
        {
            model.addAttribute("listItems", anbarService.getAllItems());
            return "profileUser";
        }}
        else
            return "login";

    }
    @RequestMapping("/backtolist")
    public String backToList(Model model){

        if(user_role.equals("admin")){
            model.addAttribute("listItems", anbarService.getAllItems());
            return "profileAdmin";
        }
        else {
            model.addAttribute("listItems", anbarService.getAllItems());
            return "profileUser";
        }

        }

}
