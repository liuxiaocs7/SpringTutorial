package com.liuxiaocs.action;


import com.liuxiaocs.entity.User;
import com.liuxiaocs.service.UserService;
import com.opensymphony.xwork2.Action;

public class RegAction implements Action {

    private UserService userService;

    // <input typ="text" name="user.name"/>
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute() throws Exception {
        userService.register(user);
        return Action.SUCCESS;
    }
}
