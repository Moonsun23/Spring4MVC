<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        <main>
                <h2>로그인</h2>
                <form name="loginform">
                        <div><label for="userid">아이디</label>
                                <input type="text" name="userid" id="userid"></div>
                        <div><label for="passwd">비밀번호</label>
                                <input type="password" name="passwd" id="passwd"></div>
                        <div><label></label>
                                <button type="button" class="btn btn-primary" id="loginbtn">로그인</button>

                        </div>
                </form>
        </main>

        <script src="/assets/js/member.js/"></script>