package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

@Controller
@RequestMapping("/login")
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        //设置模型数据，用于传递到jsp
        mav.addObject("msg", "");
        //设置视图名字，用于响应用户
        mav.setViewName("/WEB-INF/page/index.jsp");

        return mav;
    }

    @Resource(name = "userService")
    private UserService userService;

//    @RequestMapping("/test/login4.do")
//    public String testLogin4(User user) {
//        if (userService.login(user) == false) {
//            return "loginError";
//        }
//        return "loginSuccess";
//
//    }
}
