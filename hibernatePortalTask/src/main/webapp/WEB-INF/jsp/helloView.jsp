<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>

<fmt:bundle basename="/WEB-INF/i18n/resources/ApplicationResources"/>

<portlet:actionURL var="actionFirst"/>

<div>
    <form action="${actionFirst}" method="post">
        <fieldset>
            <legend>
                <fmt:message key="hello" />
            </legend>
            <label for="name">
                <fmt:message key="lable.name" />
            </label>
            <input type="text" name="name" id="name" />
            <div>
                <button type="submit">
                    <fmt:message key="button.submit" />
                </button>
            </div>
        </fieldset>
    </form>
</div>