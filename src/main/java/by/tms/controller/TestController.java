package by.tms.controller;

import by.tms.dao.UserDao;
import by.tms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/saveUser")
    public void saveUser() {
        userDao.save(new User(0, "Test", "Test", "1"));
    }

    @GetMapping("/deleteUser")
    public void deleteUser() {
        userDao.delete(new User(1, "Test", "Test", "1"));
    }

    @GetMapping("/deleteUserById")
    public void deleteUserById() {
        userDao.deleteById(2);
    }

    @GetMapping("/updateUser")
    public void updateUser() {
        userDao.update(new User(2, "Test", "Test", "1"));
    }

    @GetMapping("/updateName")
    public void updateUserName() {
        userDao.update(1, "Ryhor");
    }

    @GetMapping("/getAllUsers")
    public void getAll() {
        userDao.getAll();
    }


    @GetMapping("/getByUserName")
    public void getByUserName() {
        userDao.getUserByUsername("Test");
    }
}
