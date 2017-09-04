package ru.itpark.controller.portlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import ru.itpark.models.User;
import ru.itpark.service.UserService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.Cookie;

@Controller
@RequestMapping("VIEW")
public class HelloController {

    @Autowired
    private UserService userService;

    static private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RenderMapping
    public String render(RenderRequest request, RenderResponse response, Model model) {
        logger.info("invoke render");
        return "helloView";
    }

    @ActionMapping
    public void actionFirst(ActionRequest request, ActionResponse response,
                            @RequestParam(required = false, value = "name") String name, Model model) {
        logger.info("invoke action with name = {}", name);
        User user = userService.findByUsername(name);
        //String newName = user.getFirstName() + " " + user.getLastName();
        model.addAttribute("user", user);
        Cookie cookie = new Cookie("name", name);
        response.addProperty(cookie);
        response.setRenderParameter("page", "hello");
    }

    @RenderMapping(params = "page=hello")
    public String renderHello(RenderRequest request, RenderResponse response, Model model) {
        logger.info("invoke renderHello");
        return "hello";
    }

    @ActionMapping(params = "action=action-one")
    public void actionAccountInf(ActionRequest request, ActionResponse response, Model model) {
        Cookie cookie = request.getCookies()[0];
        String name = cookie.getValue();
        User user = userService.findByUsername(name);
        model.addAttribute("user", user);
        response.setRenderParameter("render","accountInf");
    }

    @RenderMapping(params = "render=accountInf")
    public String renderAccountInf(RenderRequest request, RenderResponse response, Model model) {
        return "accountInf";
    }

    @ActionMapping(params = "action=action-two")
    public void actionProfile(ActionRequest request, ActionResponse response, Model model) {
        Cookie cookie = request.getCookies()[0];
        String name = cookie.getValue();
        User user = userService.findByUsername(name);
        model.addAttribute("user", user);
        response.setRenderParameter("render","profile");
    }

    @RenderMapping(params = "render=profile")
    public String renderProfile(RenderRequest request, RenderResponse response, Model model) {
        return "profile";
    }
}