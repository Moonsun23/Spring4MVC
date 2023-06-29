<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <header>
        <h1>SemiProject</h1>
    </header>
    <nav>
        <ul>
            <li><a href="/">Home</a></li>
            <li><a href="/member/join">회원가입</a></li>

            <c:if test="${empty sessionScope.member}">
            <li><a href="/member/login">로그인</a></li></c:if>

            <c:if test="${not empty sessionScope.member}">
            <li><a href="/member/logout">로그아웃</a></li></c:if>

            <li><a href="/board/list">게시판</a></li>
            <li><a href="/member/myinfo">회원정보</a></li>
        </ul>
        <hr class="hr">
    </nav>