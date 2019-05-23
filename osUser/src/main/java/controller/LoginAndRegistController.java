package controller;

import entity.Message;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import util.EncryptUtil;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginAndRegistController {

    @Resource
    private UserService userService;

    @RequestMapping("judgeUsername")
    @ResponseBody
    public Message judgeUsername(Model model, @RequestParam String username) {
        Message message = new Message();
        if (userService.existUsername(username)) {
            message.setMsg("该用户名已存在，请重新输入!");
        } else {
            message.setMsg("");
        }
        return message;
    }

    @RequestMapping("judgeTelephone")
    @ResponseBody
    public Message judgeTelephone(Model model, @RequestParam String telephone) {
        Message message = new Message();
        if (userService.existTelephone(telephone)) {
            message.setMsg("该电话已被注册，请重新输入!");
        } else {
            message.setMsg("");
        }
        return message;
    }

    @RequestMapping("judgeQQ")
    @ResponseBody
    public Message judgeQQ(Model model, @RequestParam String qq) {
        Message message = new Message();
        if (userService.existQQ(qq)) {
            message.setMsg("该QQ已被注册，请重新输入!");
        } else {
            message.setMsg("");
        }
        return message;
    }

    @RequestMapping("registerUser")
    public String registerUser(HttpSession httpSession, User user, Model model, HttpServletResponse httpServletResponse) {
        user = userService.registerUser(user);
        if (null != user) {

            String userId = user.getId().toString();
            try {
                userId = EncryptUtil.encryptAes(userId);
            }
            catch(Exception e){
                System.out.println("id加密出异常");
            }

            if (httpSession.getAttribute(userId) != null) {
                httpSession.removeAttribute(userId);
            }
            model.addAttribute("user", user);
            httpSession.setAttribute(userId, user);
            Cookie cookie = new Cookie("login",userId);
            cookie.setPath("/");
            httpServletResponse.addCookie(cookie);
        }
        return "forward:index.jsp";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Message login(@RequestParam String username, @RequestParam String password, HttpSession httpSession, HttpServletResponse httpServletResponse) {
        Message message = new Message();
        User user = userService.loginUser(username, password);
        if (null != user) {

            String userId = user.getId().toString();
            try {
                userId = EncryptUtil.encryptAes(userId);
            }
            catch(Exception e){
                System.out.println("id加密出异常");
            }

            httpSession.setAttribute(userId, user);

            Cookie cookie = new Cookie("login",userId);
            cookie.setPath("/");
            httpServletResponse.addCookie(cookie);

            message.setMsg("");
        } else
            message.setMsg("用户名或密码错误");
        return message;
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest httpServletRequest) {
        Cookie[] cookies = httpServletRequest.getCookies();

        String userId = "";
        if (null != cookies)
            for (Cookie c : cookies
                    ) {
                if ("login".equals(c.getName())){
                    userId = c.getValue();
                    c.setMaxAge(0);
                }
            }

        HttpSession httpSession = httpServletRequest.getSession();
        if (null != httpSession && null != httpSession.getAttribute(userId))
            httpSession.removeAttribute(userId);
        return "forward:index.jsp";
    }

    @RequestMapping(value = "loginSuccess")
    public String loginSuccess(Model model, HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        Cookie[] cookies = request.getCookies();

        String userId = "";
        if (null != cookies)
            for (Cookie c : cookies
                    ) {
                if ("login".equals(c.getName()))
                    userId = c.getValue();
            }

        if (null != httpSession && null != httpSession.getAttribute(userId))
            model.addAttribute("user", httpSession.getAttribute(userId));
        return "forward:index.jsp";
    }

    @RequestMapping("entryLogin")
    public String entryLogin() {
        return "login";
    }

    @RequestMapping("entryRegister")
    public String entryRegister() {
        return "register";
    }
}
