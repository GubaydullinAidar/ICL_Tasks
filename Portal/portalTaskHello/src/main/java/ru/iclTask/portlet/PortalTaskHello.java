package ru.iclTask.portlet;

import javax.portlet.GenericPortlet;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PortalTaskHello extends GenericPortlet {

    @RenderMode(name = "VIEW")
    public void view(RenderRequest request, RenderResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.write("Hello World !");
    }

}
