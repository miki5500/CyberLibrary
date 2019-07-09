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
        							    <div>
                                            <span class="fas fa-clipboard-list " style=" vertical-align: middle; font-size: 60px;"></span>
                                           <span class="h3 mb-3 font-weight-normal" style="padding-down:10px;">Lista książek. </span>
                                       </div>
                                       <table width="100%" class="table table-striped table-sm">
                                            <thread>
                                                <tr>
                                                     <th scope="col">Tytuł:</td>
                                                     <th scope="col">Dziedzina:</td>
                                                     <th scope="col">Wydawnictwo:</td>
                                                     <th scope="col">Dostępna:</td>
                                                     <sec:authorize access="hasRole('ROLE_ADMIN')">
                                                        <th scope="col">Aktualizuj:</td>
                                                        <th scope="col">Usuń:</td>
                                                     </sec:authorize>
                                                     <sec:authorize access="isAuthenticated()">
                                                          <th scope="col">Wyporzycz:</td>
                                                     </sec:authorize>
                                                </tr>
                                            </thread>
                                            <tbody>
                                                <c:forEach var="book" items="${ksiazki}">
                                                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                                                        <c:url var="update" value="/books/updateBookForm">
                                                              <c:param name="bookId" value="${book.id}"/>
                                                        </c:url>
                                                        <c:url var="delete" value="/books/deleteBook">
                                                              <c:param name="bookId" value="${book.id}"/>
                                                        </c:url>
                                                    </sec:authorize>
                                                    <sec:authorize access="isAuthenticated()">
                                                         <c:url var="borrow" value="/books/borrowForm">
                                                             <c:param name="bookId" value="${book.id}"/>
                                                         </c:url>
                                                    </sec:authorize>
                                                         <tr>
                                                             <td>${book.tytul}</td>
                                                             <td>${book.dziedzina}</td>
                                                             <td>${book.wydawnictwo}</td>
                                                             <td>${book.dostepna}</td>
                                                             <sec:authorize access="hasRole('ROLE_ADMIN')">
                                                                 <td><a href="${update}" title="aktualizuj"><span class="fas fa-edit green"></span></td>
                                                                 <td><a href="${delete}" ><span class="far fa-trash-alt red"></span></a> </td>
                                                             </sec:authorize>
                                                             <sec:authorize access="isAuthenticated()">
                                                                 <td><a href="${borrow}" ><span class="fas fa-hand-paper green"></span></td>
                                                             </sec:authorize>
                                                         </tr>
                                                </c:forEach>
                                       <tbody>
                                       </table>

                                       <div class="pagination justify-content-center">
                                            <c:if test="${not empty prev}">
                                                <a href="/cyberlibrary/books/bookList?page=${prev}">&laquo;</a>
                                            </c:if>
                                            <c:forEach var="i" begin="0" end="${strony}">
                                                <a href="/cyberlibrary/books/bookList?page=${i}">${i}</a>
                                            </c:forEach>
                                            <c:if test="${not empty next}">
                                                <a href="/cyberlibrary/books/bookList?page=${next}">&raquo;</a>
                                            </c:if>
                                       </div>
                                                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                                                     <a href="/cyberlibrary/books/addBookForm" class="btn btn-lg btn-primary btn-block" type="submit">Dodaj książkę</a>
                                                          </sec:authorize>
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