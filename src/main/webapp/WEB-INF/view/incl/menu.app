<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags"   prefix="sec" %>
            <nav class="navbar navbar-dark bg-primary navbar-expand-md">
                    <a class="navbar-brand" href="/cyberlibrary">CyberLibrary</a>

                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#mainmenu">
                        <span class="navbar-toggler-icon" ></span>
                    </button>
                    <div class="collapse navbar-collapse" id="mainmenu">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="/cyberlibrary/books/bookList?page=0">Lista książek</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/contact">Kontakt</a>
                            </li>
                             <li class="nav-item">
                                <a class="nav-link" href="/about">O nas</a>
                             </li>
                        </ul>
                         <ul class="navbar-nav ml-auto">
                        <sec:authorize access="hasRole('ROLE_ANONYMOUS')">

                                <li class="nav-item ml-auto">
                                      <a class="nav-link" href="/cyberlibrary/register" title="Zarejestruj się" ><i class="fas fa-user-plus fa-lg"></i></a>
                                 </li>
                                <li class="nav-item ml-auto">
                                      <a class="nav-link" href="/cyberlibrary/login" title="Zaloguj się" > <i class="fas fa-sign-in-alt fa-lg"></i> </a>
                                </li>
                         </sec:authorize>
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <li class="nav-item ml-auto">
                                     <a class="nav-link" href="/cyberlibrary/admin?panel=1" title="Panel admina" > <i class="fas fa-user-shield fa-lg"></i></a>
                                </li>
                             </sec:authorize>
                             <sec:authorize access="isAuthenticated()">
                                    <li class="nav-item ml-auto">
                                            <a class="nav-link" href="/cyberlibrary/profil?panel=1" title="Mój profil" > <i class="far fa-user fa-lg"></i></a>
                                    </li>
                                    <li class="nav-item ml-auto">
                                            <a class="nav-link" href="/cyberlibrary/logout" title="Wyloguj" > <i class="fas fa-sign-out-alt fa-lg"></i></a>
                                    </li>
                            </sec:authorize>
                         </ul>
                    </div>

            </nav>