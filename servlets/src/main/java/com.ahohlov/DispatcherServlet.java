package com.ahohlov;


import com.ahohlov.command.Command;
import com.ahohlov.command.impl.ItemsCommand;
import com.ahohlov.command.impl.LoginCommand;
import com.ahohlov.command.impl.UsersCommand;
import com.ahohlov.model.CommandEnum;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class DispatcherServlet extends HttpServlet {

    private static final Map<CommandEnum, Command> commands = new HashMap<>();

    @Override
    public void init() {
        System.out.println("DispatcherServlet init!");
        commands.put(CommandEnum.LOGIN, new LoginCommand());
        commands.put(CommandEnum.USERS, new UsersCommand());
        commands.put(CommandEnum.ITEMS, new ItemsCommand());
    }

    @Override
    public void destroy() {
        System.out.println("DispatcherServlet destroy!");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String command = request.getParameter("command");
        Command commandAction = null;
        try {
            commandAction = commands.get(CommandEnum.getCommand(command));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        if (commandAction != null) {
            try {
                String page = commandAction.execute(request, response);
                if (page != null) {
                    getServletContext().getRequestDispatcher(page).forward(request, response);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Command " + command + " does not exists!");
        }
    }
}
