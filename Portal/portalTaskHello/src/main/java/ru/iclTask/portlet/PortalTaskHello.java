package ru.iclTask.portlet;

import javax.portlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.ResourceBundle;

public class PortalTaskHello extends GenericPortlet {

    private static final String EDIT_JSP_FILE = "/WEB-INF/jsp/editHello.jsp";
    private static final String HELP_MESSAGE = "label.message.help";

    @RenderMode(name = "VIEW")
    public void view(RenderRequest request, RenderResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        String name = request.getParameter("name");
        name = (name == null) ? "" : name;
        String messagePattern = request.getPreferences().getValue("message", "Hello (0) !");
        printWriter.write(MessageFormat.format(messagePattern, name));
    }

    @RenderMode(name = "EDIT")
    public void edit(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        String messagePattern = request.getPreferences().getValue("message", "Hello (0) !");
        request.setAttribute("message", messagePattern);
        getPortletContext().getRequestDispatcher(EDIT_JSP_FILE).include(request, response);
    }

    @ProcessAction(name = "nameAction")
    public void processActionEdit(javax.portlet.ActionRequest request, javax.portlet.ActionResponse response) throws PortletModeException, IOException, ValidatorException, ReadOnlyException {
        PortletPreferences pref = request.getPreferences();
        String messagePattern = (String) request.getParameter("message");
        pref.setValue("message", messagePattern);
        pref.store();
        response.setPortletMode(PortletMode.VIEW);
    }

    @RenderMode(name = "HELP")
    public void help(RenderRequest request, RenderResponse response) throws IOException {
        ResourceBundle bundle = getPortletConfig().getResourceBundle(request.getLocale());
        String help = bundle.getString(HELP_MESSAGE);
        PrintWriter printWriter = response.getWriter();
        printWriter.write(help);
    }


    @ProcessEvent(qname = "(http://test.portlet.org)name")
    @Override
    public void processEvent(EventRequest request, EventResponse response) {
        Event event = request.getEvent();
        String name = (String) event.getValue();
        response.setRenderParameter("name", name);
    }
}
