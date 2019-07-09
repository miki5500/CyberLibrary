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

						<div class="loginbox">
						<div class="avatar">
						<i class="fas fa-user fa-5x "></i>
						</div>
						<h1 class="h3 mb-3 font-weight-normal">Zaloguj się. </h1>
						<c:if test="${not empty error}">
                        			<div class="error">${error}</div>
                        		</c:if>
                      <form:form class="form-signin" action="/perform_login" method="post">
                            <p>
                               <label for="username" class="sr-only">E-mail:</label>
                               <input name="username" id="username" class="form-control loginboxmail" placeholder="E-mail:" required="true" autofocus="true" />
                            </p>
                            <p>
                               <label for="password" class="sr-only">Hasło:</label>
                               <input name="password" id="password" class="loginboxpass" placeholder="Hasło:" required="true" />
                            </p>
                            <p>
								<a href="/register">Nie mam konta?</a>
							</p>
						    <input type="hidden" name="${_csrf}" value="${_csrf.token}" />
                           <button class="btn btn-lg btn-primary btn-block" type="submit" value="submit" >Zaloguj</button>
							<p class="mt-5 mb-3 text-muted-w">&copy; 2019-2020</p>

                        </form:form>
							</div>

            </div>
            </section>
        </main>
     <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
     <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    </body>
</html>