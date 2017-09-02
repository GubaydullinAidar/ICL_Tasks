package ru.itpark.portlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Controller
@RequestMapping("VIEW")
public class HelloController {

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
        model.addAttribute("name", name);
        response.setRenderParameter("page", "hello");
    }

    @RenderMapping(params = "page=hello")
    public String renderHello(RenderRequest request, RenderResponse response, Model model) {
        logger.info("invoke renderHello");
        return "hello";
    }
}
