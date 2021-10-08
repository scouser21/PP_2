package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UserService userService; // = new UserDaoImpl();

    public UsersController (){
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUserInfo(@RequestParam("userName") String userName , ModelMap model) {
        User user = userService.getUserByLogin(userName);
//        User user = userService.getUser(1);
        model.addAttribute("user", user);
        return "userInfo";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "logOut", method = RequestMethod.GET)
    public String logOut() {
        return "redirect:/login";
    }

    @GetMapping (value = "/admin")
    public String getAllUsers(Model model) {
        List<User> listUser = userService.getAllUsers();
        model.addAttribute("usersList", listUser);
        return "allUsers";
    }

    @GetMapping (value = "/")
    public String getStartView() {
        return "startView";

    }

    @GetMapping (value = "addNewUser")
    public String addNewUser(Model model){

        User user = new User();
        model.addAttribute("user", user);

        return "userAddingData";
    }

    @GetMapping (value = "saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping (value = "deleteUser")
    public String deleteUser(@RequestParam("id") int id){
        userService.removeUserById(id);
        return "redirect:/admin";
    }


    @GetMapping (value = "updateUser")
    public String updateUser(@RequestParam("id") int id, Model model){

        User user = userService.getUser(id);
        model.addAttribute("user", user);

        return "userAddingData";
    }



}