<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <title>CyberLibrary - Strona główna</title>
    <meta name="keywords" content="książka, czytać,">
    <meta name="author" content="Krzysztof Bieńko">
    <meta http-equiv="X-Ua-Compatible" content="IE=edge">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/CyberStyle.css" />" rel="stylesheet" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/v4-shims.css">

</head>
<html>
    <body>
        <header>
            <%@include file="/WEB-INF/view/incl/menu.app"%>
        </header>

         <main>
                    <section class="mainpage">
        			<header>

                    </header>
        					<section class="mainpage">
        					     <div class="row no-gutters padds">
                            		<div class="col-sm-12 col-md-4">
                            			<figure class=" addBookBox">
                            					<i class="fas fa-user fa-5x addicon"></i>
                            					<div class="uData">
                            						<h1>Menu użytkownika:<h1>
                            					</div>
                            					<div>
                            						<a href="/cyberlibrary/admin/userlist?page=0" class="btn btn-lg btn-primary btn-block" >Lista użytkowników</a>
                            						<a href="/cyberlibrary/admin?panel=3" class="btn btn-lg btn-primary btn-block" >Wypożyczone książki</a>
                            						<a href="/cyberlibrary/books/bookList?page=0" class="btn btn-lg btn-primary btn-block" >Lista książek </a>
                            						<a href="/cyberlibrary/admin/autorlist?page=0" class="btn btn-lg btn-primary btn-block" >Lista autorów </a>
                            					<div>
                            			</figure>
                                    </div>
                            		<div class="col-sm-12 col-md-8">
                            			<figure class="lastBorrowed">
                            					<i class="fas fa-clipboard-list addIcon"></i>
                            					<c:if test="${not empty message}">
                            					    <p>Witamy na stronie admina tutaj znajdziesz listę użytkowników oraz wyporzyczone przez nich książki</p>
                            					</c:if>
                                               <c:if test="${not empty users}">
                                                   <table width="100%" class="table table-striped table-sm">
                                                       <tr>
                                                          <td>Imie:</td>
                                                          <td>Nazwisko:</td>
                                                          <td>Email:</td>
                                                          <td>Usuń:</td>
                                                       </tr>
                                                       <c:forEach var="user" items="${users}">
                                                           <c:url var="delete" value="/admin/deleteuser">
                                                              <c:param name="userId" value="${user.id}"/>
                                                           </c:url>
                                                          <tr>
                                                              <td>${user.name}</td>
                                                              <td>${user.lastName}</td>
                                                              <td>${user.email}</td>
                                                              <td><a href="${delete}" ><span class="far fa-trash-alt red"></span></a> </td>
                                                          </tr>
                                                       </c:forEach>
                                                   </table>
                                               </c:if>
                                               <c:if test="${not empty autors}">
                                                    <table width="100%" class="table table-striped table-sm">
                                                        <tr>
                                                             <td>Imie:</td>
                                                                  <td>Nazwisko:</td>
                                                                  <td>Usuń:</td>
                                                        </tr>
                                                        <c:forEach var="autor" items="${autors}">
                                                            <c:url var="delete" value="/admin/deleteautor">
                                                                <c:param name="autorId" value="${autor.id}"/>
                                                            </c:url>
                                                            <tr>
                                                                  <td>${autor.imie}</td>
                                                                  <td>${autor.nazwisko}</td>
                                                                  <td><a href="${delete}" ><span class="far fa-trash-alt red"></span></a> </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </table>
                                               </c:if>
                            			</figure>
                            		</div>
        				</section>
                </main>
        <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    </body>
</html>