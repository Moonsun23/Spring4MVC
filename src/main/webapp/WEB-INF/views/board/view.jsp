<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<main>

        <h2>본문보기</h2>
        <div id="view">
                <div><label>제목</label>
                        <span>${board.title}</span></div>

                <div><label>작성자</label>
                        <span>${board.userid}</span></div>

                <div><label>작성일/조회수</label>
                        <span>${board.regdate}/${board.views}</span></div>

                <div><label class="drgup">본문</label>
                        <span id="contents">${board.contents}</span></div>

                <div><label></label>
                        <button type="button" id="newbtn" class="btn btn-success">새글쓰기</button>
                        <button type="button" class="btn btn-light">목록으로</button>

                        <c:if test = "${(not empty sessionScope.member) and (sessionScope.member.userid eq board.userid)}">
                                <button type="button" class="btn btn-warning">수정하기</button>
                                <button type="button" class="btn btn-danger">삭제하기</button>
                        </c:if>
                </div>
        </div>




</main>
<script src="/assets/js/board.js"></script>
