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
        					<div class="row no-gutters">
        						<div class="col-sm-11 kontener">
        							<figure class="containeer">
        							<h1 class="h1 mb-3 font-weight-normal">Witamy w systemie bibliotecznym CyberLibrary. </h1>
        								<hr/>

        										Aplikacja została stworzona przez studenta I roku studiów II-stopnia kierunku informatyka.</br>
        										Strona kożysta z:
        										<ul>
        											<li>Springboot <a href="https://spring.io/"> https://spring.io/ </a></li>
        											<li>Bootstrap <a href="https://getbootstrap.com/" >https://getbootstrap.com/</a></li>
        											<li>Fontawesome <a href="https://fontawesome.com/" >https://fontawesome.com/</a></li>
        										</ul>
        								<hr/>
        								</figure>
        						</div>
        						<div class="col-sm-11 footer" >
        							<p class="text-muted-w">&copy; 2019-2020</p>
        						</div>
        					</div>
        				</section>
                </main>
        <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    </body>
</html>