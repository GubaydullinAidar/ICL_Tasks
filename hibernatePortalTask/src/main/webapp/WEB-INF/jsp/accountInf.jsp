<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>

<%@include file="hello.jsp"%>

<h1> Информация о счете </h1> <br><br>

<p>Номер счета: ${user.primaryAccount.accountNumber}</p>
