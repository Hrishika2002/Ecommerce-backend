package org.example.Controller;
import org.example.Model.User;
import org.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins ="*",allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/registration")
    public User save(@RequestBody User obj) {

        User savedUser = userService.saveuser(obj);
        return savedUser;
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        String email = user.getEmail();
        String password = user.getPassword1();
        return userService.userLogin(email, password);
    }
}




