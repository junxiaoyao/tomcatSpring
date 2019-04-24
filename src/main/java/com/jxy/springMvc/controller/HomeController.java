package com.jxy.springMvc.controller;

import com.jxy.springMvc.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: ybl
 * @Date: 2018/12/14 0014 11:07
 * @Description:
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private HomeService homeService;
    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        String say=homeService.say();
        Map<String, Object> user = new HashMap<>();
        user.put("userName", "测试用户");
        model.addAttribute("user", user);
        return "homePage";
    }

    @RequestMapping("login")
    public String loginGet(Model model, String error) {
        model.addAttribute("error", error);
        return "login";
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
        SecurityContextHolder.clearContext();
        return "login";
    }
}
