package controller;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    //  到users的请求会由queryAll处理
    @RequestMapping("users")
    public String queryAll(Model model) {
//        ModelAndView mav = new ModelAndView();
        List<User> userList = userService.queryAll();
        if (null != userList) {
            model.addAttribute(userList);
        }
//        mav.addObject("userList",userList);
//        mav.setViewName("userList");
//        return mav;
        return "userList";
    }

    @RequestMapping(value = "queryUsers", method = RequestMethod.POST)
    public String queryUsers(Model model, User user) {
        List<User> userList = userService.queryByName(user);
        if (null != userList) {
            model.addAttribute(userList);
            for (User u :
                    userList) {
                System.out.println(u.getUsername());
            }
        }
        return "userList";
    }

    @RequestMapping("updateWeight")
    public String updateWeight(Model model, User user) {
        List<User> userList = userService.updateWeight(user);
        if (null != userList)
            model.addAttribute(userList);
        return "userList";
    }

    //    接收restful风格的url
    @RequestMapping("deleteUser/{id}")
    public String deleteUser(Model model, @PathVariable Integer id) {
        List<User> userList = userService.deleteUser(id);
        if (null != userList)
            model.addAttribute(userList);
        return "userList";
    }

}
