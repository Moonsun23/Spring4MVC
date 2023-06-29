<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty sessionScope.member}">
        <script>location.href = "/member/myinfo";</script>
</c:if>

        <main>
                <h2>회원가입</h2>
                <form name="joinform">
                        <div><label for="userid">아이디</label>
                                <input type="text" name="userid" id="userid"></div>
                        <div><label for="passwd">비밀번호</label>
                                <input type="password" name="passwd" id="passwd"></div>
                        <div><label for="repwd">비밀번호 확인</label>
                                <input type="password" name="repwd" id="repwd"></div>
                        <div><label for="name">이름</label>
                                <input type="text" name="name" id="name"></div>
                        <div><label for="email">이멜</label>
                                <input type="email" name="email" id="email"></div>
                        <div><label></label><%--label을 써서 버튼에 앞 공간이 생긴거임--%>
                                <button type="button" class="btn btn-primary" id="joinbtn">입력완료</button>
                                <button type="reset" class="btn btn-danger">입력취소</button>
                        </div>
                </form>
        </main>

        <script src="/assets/js/member.js/"></script>
