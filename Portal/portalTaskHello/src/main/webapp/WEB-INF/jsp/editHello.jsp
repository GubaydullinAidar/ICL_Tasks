<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page contentType="text/html" isELIgnored="false" %>

<portlet:actionURL name="messageAction" var="action"></portlet:actionURL>

<fmt:bundle basename="messages.PortalTaskHello"/>

<div style="display: table;">
    <form action="$action" method="POST">
        <div style="display: table-row;">
            <div style="display: table-cell;">
                <fmt:message key="label.message"/>
            </div>
            <div style="display: table-cell;">
                <textarea name="message" row="5" col="50" value="${requestScope.message}"></textarea>
            </div>
        </div>
        <div style="display: table-row; color: gray;">
            <fmt:message key="label.message.edit.help"/>
        </div>
        <div style="display: table-row;">
            <input type="submit" value="Submit">
        </div>
    </form>
</div>
