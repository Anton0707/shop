package com.ahohlov.command.impl;

import com.ahohlov.UserService;
import com.ahohlov.command.Command;
import com.ahohlov.config.ConfigurationManager;
import com.ahohlov.dao.model.User;
import com.ahohlov.impl.UserServiceImpl;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UsersCommand implements Command {

    private UserService userService = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<User> users = userService.findAll();
        request.setAttribute("users", users);
        return ConfigurationManager.getInstance().getProperty(ConfigurationManager.USERS_PAGE_PATH);

    }
}
