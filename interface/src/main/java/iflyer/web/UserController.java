package iflyer.web;

import iflyer.model.User;
import iflyer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by liuxin on 17/1/20.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ModelAndView getUserInfo(@PathVariable(name = "name") String name, ModelMap modelMap) {
        User user = userService.getUser(name);
        modelMap.put("user", user);
        return new ModelAndView("user", modelMap);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Object saveUserInfo(@RequestParam("name") String name, @RequestParam("age") String age, ModelMap modelMap) {
        System.out.println("我是interface");
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        User user = userService.saveUser(name, age);
        modelMap.put("user", user);
        return new ModelAndView("user", modelMap);
    }

}