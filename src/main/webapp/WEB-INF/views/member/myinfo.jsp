<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        <main>
                <h2>회원정보</h2>
                <table class="myinfo">
                        <tr><th>아이디</th><td>${member.userid}</td></tr>
                        <tr><th>이름</th><td>${member.name}</td></tr>
                        <tr><th>이메일</th><td>${member.email}</td></tr>
                        <tr><th>가입일자</th><td>${member.regdate}</td></tr>

                </table>
        </main>
