<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <title>CyberLibrary - Zaloguj się</title>
    <meta name="keywords" content="książka, czytać,">
    <meta name="author" content="Krzysztof Bieńko">
    <meta http-equiv="X-Ua-Compatible" content="IE=edge">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/CyberStyle.css" />" rel="stylesheet" />
</head>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <title>CyberLibrary - Zaloguj się</title>
    <meta name="keywords" content="książka, czytać,">
    <meta name="author" content="Krzysztof Bieńko">
    <meta http-equiv="X-Ua-Compatible" content="IE=edge">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/CyberStyle.css" />" rel="stylesheet" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/v4-shims.css">

</head>
<html>
    <body class="text-center">
        <header>
          <%@include file="/WEB-INF/view/incl/menu.app"%>

        </header>

        <main>
            <section class="mainpage">

            	<div class="loginbox register">
            	<c:url var="cancel" value="/books/borrow">
                     <c:param name="bookId" value="${ksiazka.id}"/>
                     <c:param name="confirm" value="false" />
                </c:url>
                <c:url var="confirm" value="/books/borrow">
                     <c:param name="bookId" value="${ksiazka.id}"/>
                     <c:param name="confirm" value="true" />
                </c:url>
            		<div class="avatar">
            			<i class="fas fa-user fa-5x "></i>
            		</div>
            		<h1 class="h3 mb-3 font-weight-normal">Potwierdź wyporzyczenie </h1>

            		<div>Tytuł: ${ksiazka.tytul}
            		</div>
            		<div>
            			Wydawnictwo: ${ksiazka.wydawnictwo}
            		</div>
            		<div>
            			Autor:
            			    <c:forEach var="autor" items="${autorzy}">
            			    <p>${autor.imie} ${autor.nazwisko}</p>
            			    </c:forEach>
            		</div>
            		    <c:if test = "${message == 1}">
                           <a href="${confirm}" class="btn btn-lg btn-primary btn-block">Potwierdź</a>
                           <a href="${cancel}" class="btn btn-lg btn-primary btn-block" >Anuluj</a>
                        </c:if>
                        <c:if test = "${message == 0}">
                            <p>Niestety dana książka została już wyporzyczona.</p>
                            <a href="/cyberlibrary/bookList?page=0" class="btn btn-lg btn-primary btn-block" >Anuluj</a>

                        </c:if>

            		<p class="mt-5 mb-3 text-muted-w">&copy; 2019-2020</p>

            	</div>
            </section>
        </main>
        <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    </body>
</html>