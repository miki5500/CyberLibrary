<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <title>CyberLibrary - Zarejestruj się</title>
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
               <div class="row">
                <div class="col-sm-11 loginbox">
                    <div class="avatar">
                        <i class="fas fa-user fa-5x "></i>
                    </div>
                    <h1 class="h3 mb-3 font-weight-normal">Zarejestruj się. </h1>
                    <form:form id="register" action="/cyberlibrary/profil/editPassword" modelAttribute="user" method="POST">
                            <form:hidden path="id" />
                            <form:hidden path="email"/>
                            <form:hidden path="lastName"/>
                            <form:hidden path="active" />
                            <form:hidden path="name" />

                            <label for="inputPassword" class="sr-only">Hasło:</label>
                            <form:password path="password" name="inputPassword" id="inputPassword" placeholder="Hasło:" required="true" />
                            <button class="btn btn-lg btn-primary btn-block" type="submit">Zmień hasło</button>

                    </form:form>
                </div>
                <div class="col-sm-11 footer reg-foot">
                        <p class="text-muted-w">&copy; 2019-2020</p>
                </div>

               </div>
            </section>
        </main>
        <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    </body>
</html>