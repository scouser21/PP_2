package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import model.User;
import dao.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UserService userService; // = new UserDaoImpl();

    public UsersController (){
    }


    /*@GetMapping(value = "/print")
    public String printWelcome(@RequestParam(value = "count", required = false) String param, ModelMap model) {

        MyService service = new MyService();
        int count;
        if (param == null){
            count = Integer.MAX_VALUE;
        } else {
            count = Integer.parseInt(param);
        }

        List<User> carsList = service.getCars(count);
        model.addAttribute("carsList", carsList);
        return "cars";
    }*/

    @GetMapping (value = "/users")
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
        return "redirect:/users";
    }

    @GetMapping (value = "deleteUser")
    public String deleteUser(@RequestParam("id") int id){
        userService.removeUserById(id);
        return "redirect:/users";
    }


    @GetMapping (value = "updateUser")
    public String updateUser(@RequestParam("id") int id, Model model){

        User user = userService.getUser(id);
        model.addAttribute("user", user);

        //userService.saveUser(user);
//        return "redirect:/addNewUser";
        return "userAddingData";
    }



}