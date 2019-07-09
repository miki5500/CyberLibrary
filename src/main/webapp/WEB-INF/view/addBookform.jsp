<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <title>CyberLibrary - Strona Główna</title>
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
            <div class="row no-gutters padds">
					<div class="col-sm-12 col-md-4">
						<figure class=" addBookBox">
									
									<i class="fas fa-book-medical addIcon"></i>
									<h1 class="h3 mb-3 font-weight-normal">Dodaj książkę. </h1>
									<form:form id="addBook" action="/cyberlibrary/books/addBook" modelAttribute="book" method="POST">
										<label for="nameInput" class="sr-only">Imię autora:</label>
										<form:input type="text" path="name" id="nameInput" placeholder="Imię autora:"/>
										<label for="lastnameInput" class="sr-only">Nazwisko autora:</label>
										<form:input type="text" path="lastName" id="lastnameInput" placeholder="Nazwisko Autora"/>
										<label for="titleInput" class="sr-only">Tytuł:</label>
										<form:input type="text" path="title" id="titleInput" placeholder="Tytuł:"/>
										<label class="w" for="typeInput" >Dziedzina:</label>
										<label class="wrap">
											<form:select name="nazwa" path="category" id="typeInput" items="${listaD}"/>
										</label>
										<label for="phInput" class="sr-only">Wydawnictwo:</label>
										<form:input type="text" path="wydawnictwo" id="phInput" placeholder="Wydawnictwo:" />

										<button class="btn btn-lg btn-primary btn-block" type="submit">Dodaj książkę</button>
									</form:form>
							</figure>
                </div>
				</div>
        </main>
        <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    </body>
</html>