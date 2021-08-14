package com.liuxiaocs.action;


import com.liuxiaocs.entity.User;
import com.liuxiaocs.service.UserService;
import com.opensymphony.xwork2.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("regAction")
@Scope("prototype")
public class RegAction implements Action {

    @Autowired
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
