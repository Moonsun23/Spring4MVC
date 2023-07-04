<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--<c:if test="${empty sessionScope.member}">--%>
<%--        <script>location.href = "/member/login";</script>--%>
<%--</c:if>--%>
<%--로그인 하지 않으면 게시글을 볼 수 없게 함--%>

        <main>
                <script src="http://www.google.com/recaptcha/api.js"></script>
                <h2>새글쓰기</h2>
                <form name ="writefrm" id="writefrm">
                        <div><label for="title">제목</label>
                        <input type="text" name="title" id="title"></div>
                        <div><label for="userid">작성자</label>
                                <input type="text" name="userid" id="userid" value="${sessionScope.member.userid}" readonly></div>
                        <div><label for="contents" class="drgup">본문</label>
                                <textarea rows="7" cols="55"
                                        name="contents" id="contents"></textarea></div>

                        <div><label>자동쓰기방지</label>
                              <div class="g-recaptcha cptaalgn" data-sitekey="6LfLW-EmAAAAAP_kUAHZceCkTx0FoPehsJY67DML"></div>
                              <input type="hidden" name="grecaptcha" id="g-recaptcha"></div>


                        <div><label></label>
                                <button type="button" id="newbdbtn" class="btn btn-primary">입력완료</button>
                                <button type="reset" class="btn btn-danger">입력취소</button></div>




                </form>
        </main>
<script src="/assets/js/board.js"></script>