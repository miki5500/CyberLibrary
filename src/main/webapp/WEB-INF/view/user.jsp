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
                            						<a href="/cyberlibrary/profil?panel=2" class="btn btn-lg btn-primary btn-block" >Dane użytkownika</a>
                            						<a href="/cyberlibrary/profil?panel=3" class="btn btn-lg btn-primary btn-block" >Wypożyczone książki</a>
                            						<a href="/cyberlibrary/profil?panel=4" class="btn btn-lg btn-primary btn-block" >Kary za opóźnienia </a>
                            					<div>
                            			</figure>
                                    </div>
                            		<div class="col-sm-12 col-md-8">
                            			<figure class="lastBorrowed">
                            					<i class="fas fa-clipboard-list addIcon"></i>
                            					<c:if test="${not empty message}">
                            					    <p>Witamy na stronie użytkownika tutaj znajdziesz swoje dane oraz wyporzyczone książki</p>
                            					</c:if>
                            					<c:if test="${not empty data}">
                                                  <p>Imię: ${data.name}</p>
                                                  <p>Nazwisko: ${data.lastName}</p>
                                                  <p>Email: ${data.email}</p>
                                                  <a href="/cyberlibrary/profil/editPassword" class="btn btn-lg btn-primary btn-block" >Zmień hasło</a>
                                                  <a href="/cyberlibrary/profil/editData" class="btn btn-lg btn-primary btn-block" >Zmień dane</a>
                                               </c:if>
                                               <c:if test="${not empty books}">
                                                   <table width="100%">
                                                       <tr>
                                                          <td>Tytuł:</td>
                                                          <td>Dziedzina:</td>
                                                          <td>Wydawnictwo:</td>
                                                       </tr>
                                                       <c:forEach var="book" items="${books}">
                                                          <tr>
                                                              <td>${book.tytul}</td>
                                                              <td>${book.dziedzina}</td>
                                                              <td>${book.wydawnictwo}</td>
                                                              </tr>
                                                       </c:forEach>
                                                   </table>
                                               </c:if>
                                               <c:if test="${not empty warn}">
                                                    <p>Jeszcze nie oprogramowano.</p>
                                               </c:if>
                            			</figure>
                            		</div>
        				</section>
                </main>
        <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    </body>
</html>