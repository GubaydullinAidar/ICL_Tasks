package com.ICLTask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Controller
@RequestMapping("VIEW")
public class SecondController {

    @RenderMapping
    public String renderSecond(RenderRequest request, RenderResponse response) {
        return "second";
    }
}
