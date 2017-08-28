<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page contentType="text/html" isELIgnored="false" %>

<portlet:defineObjects/>
<portlet:actionURL name="nameAction" var="action"></portlet:actionURL>

<fmt:setBundle basename="messages:NamePortlet"/>

<div style="display: table;">
    <form action="$action" method="POST">
        <div style="display: table-row;">
            <div style="display: table-cell;">
                <fmt:message key="label.name"/>
            </div>
            <div style="display: table-cell;">
                <input type="text" name="name" value="${requestScope.name}"></input>
            </div>
        </div>
        <div style="display: table-row;">
            <input type="submit" value="Submit">
        </div>
    </form>
</div>