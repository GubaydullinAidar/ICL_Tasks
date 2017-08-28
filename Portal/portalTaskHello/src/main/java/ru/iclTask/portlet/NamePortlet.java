package ru.iclTask.portlet;

import javax.portlet.*;
import javax.xml.namespace.QName;
import java.io.IOException;

public class NamePortlet extends GenericPortlet {

    private static final String JSP_FILE = "/WEB-INF/jsp/viewName.jsp";

    @RenderMode(name = "VIEW")
    public void view(RenderRequest request, RenderResponse response) throws IOException, PortletException {
        getPortletContext().getRequestDispatcher(JSP_FILE).include(request, response);
    }

    @ProcessAction(name = "nameAction")
    @Override
    public void processAction(ActionRequest request, ActionResponse response) {
        QName eventName = new QName("http://test/portlet/org", "name");
        String name = request.getParameter("name");
        response.setEvent(eventName, name);
    }
}
