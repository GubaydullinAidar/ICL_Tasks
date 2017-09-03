<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>

<fmt:bundle basename="/WEB-INF/i18n/resources/ApplicationResources "/>

<portlet:actionURL var="actionFirstUrl"/>
<portlet:renderURL var="renderAccountInfUrl">
    <portlet:param name="render" value="accountInf"/>
</portlet:renderURL>
<portlet:renderURL var="renderProfileUrl">
    <portlet:param name="render" value="profile"/>
</portlet:renderURL>

<div>
    <fmt:message key="hello.message">
        <fmt:param>${name}</fmt:param>
    </fmt:message>
</div>
<a href="${renderProfileUrl}">Информация пользователя</a><br>
<a href="${renderAccountInfUrl}">Информация о счете</a><br>
<a href="<portlet:renderURL/>"><fmt:message key="link.back"/></a>