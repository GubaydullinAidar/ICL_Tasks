<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>

<fmt:bundle basename="ApplicationResources "/>

<portlet:actionURL var="action"/>

<div>
    <fmt:message key="hello.message">
        <fmt:param>${name}</fmt:param>
    </fmt:message>
</div>
<a href="<portlet:renderURL></portlet:renderURL>"><fmt:message key="link.back"/></a>