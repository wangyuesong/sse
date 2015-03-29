package sse.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sse.dao.impl.UserDaoImpl;
import sse.domain.LoginForm;
import sse.jsonmodel.BasicJson;
import sse.model.User;

@Controller
public class LoginController {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserDaoImpl userDaoImpl;

    @ResponseBody
    @RequestMapping(value = "/login", method = { RequestMethod.POST })
    public BasicJson login(HttpServletRequest request, HttpServletResponse response, LoginForm command) {
        BasicJson json = new BasicJson();
        User user = userDaoImpl.findUserByAccount(command.getAccount());
        if (user == null || !user.getPassword().equals(command.getPassword()))
        {
            json.setSuccess(false);
            json.setMsg("用户名不存在或密码不正确");
            return json;
        }
        else {
            request.getSession().setAttribute("USER", user);
            logger.info("Login Succeed: " + user.getAccount());
            if (user.getRole().equals("Student"))
                json.setObj(new RoleObject("Student"));
            if (user.getRole().equals("Teacher"))
                json.setObj(new RoleObject("Teacher"));
            json.setSuccess(true);

        }
        return json;
    }

    public static class RoleObject {
        private String role;

        public RoleObject(String role)
        {
            this.role = role;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

    }
}