package sse.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sse.commandmodel.LoginForm;
import sse.jsonmodel.BasicJson;
import sse.service.impl.UserServiceImpl;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    public UserServiceImpl userService;

    @ResponseBody
    @RequestMapping(value = "/login", method = { RequestMethod.POST })
    public BasicJson login(HttpServletRequest request, HttpServletResponse response, LoginForm command) {
        return userService.doLogin(command, request);

    }

}
