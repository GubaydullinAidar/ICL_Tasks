<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>

<fmt:bundle basename="/WEB-INF/i18n/resources/ApplicationResources "/>

<portlet:actionURL var="actionAccountInfUrl">
    <portlet:param name="action" value="action-one"/>
</portlet:actionURL>
<portlet:actionURL var="actionProfileUrl">
    <portlet:param name="action" value="action-two"/>
</portlet:actionURL>

<div>
    <fmt:message key="hello.message">
        <fmt:param>${user.firstName}</fmt:param>
    </fmt:message>
</div>
<a href="${actionProfileUrl}">Информация о пользователе</a><br>
<a href="${actionAccountInfUrl}">Информация о счете</a><br>
<a href="<portlet:renderURL/>"><fmt:message key="link.back"/></a>