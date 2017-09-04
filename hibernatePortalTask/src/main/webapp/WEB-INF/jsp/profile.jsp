<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>

<%@include file="hello.jsp"%>

<h1> Информация о пользователе. </h1> <br><br>

<p>Имя: ${user.firstName}</p> <br>
<p>Фамилия: ${user.lastName}</p> <br>
<p>Почта: ${user.email}</p> <br>
<p>Номер телефона: ${user.phone}</p>
