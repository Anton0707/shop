package com.ahohlov.command.impl;

import com.ahohlov.command.Command;
import com.ahohlov.config.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ItemsCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return ConfigurationManager.getInstance().getProperty(ConfigurationManager.ITEMS_PAGE_PATH);
    }
}
