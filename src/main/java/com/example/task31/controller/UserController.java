package com.example.task31.controller;

import com.example.task31.model.User;
import com.example.task31.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String getString(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping (value = "/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/update")
    public String update(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @PatchMapping
    public String edit(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "delete";
    }

    @DeleteMapping(value = "/{id}")
    public String remove(@ModelAttribute("user") User user) {
        userService.deleteUser(user.getId());
        return "redirect:/users";
    }
}
