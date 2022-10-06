<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        .container {
            display: grid;
            grid-template-columns: 200px 1fr 200px;
            grid-template-rows: 50px 50px 20px 300px 50px;
            gap: 5px 5px;
            grid-auto-flow: row;
            grid-template-areas: ". . ." ". header ." ". . ." ". main ." ". footer .";
        }
        .header {
            grid-area: header;
            display: grid;
            grid-template-columns: 75px 1fr;
            grid-template-rows: 1fr;
            gap : 3px;
            border-bottom: 1px solid black;
        }
        .main {
            grid-area : main;
            border : 1px solid black;
        }
        .footer {
            grid-area : footer;
            display: flex;
            flex-direction: row-reverse;
        }
     </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h4>제목 :</h4>
            <h4>${bbsVO.title}</h4>
        </div>
        <div class="main">
            <p>${bbsVO.content}</p>
        </div>
        <div class="footer">
            <button id="return">뒤로가기</button>
            <c:if test="${bbsVO.ownerId eq userVO.id}">
            	<button id="modify">수정</button>
            </c:if>
            <c:if test="${bbsVO.ownerId eq userVO.id}">
            	<button id="delete">삭제</button>
            </c:if>
        </div>
    </div>
    <script type="text/javascript">
    	document.getElementById("return").addEventListener("click",function(){
    		location.href = "${pageContext.request.contextPath}/bbs6/bbs";
    	});
    	
    	document.getElementById("modify").addEventListener("click",function(){
    		location.href = "${pageContext.request.contextPath}/bbs6/bbs/put/${bbsVO.id}";
    	});
    	
    	document.getElementById("delete").addEventListener("click",function(){
    		let isDelete = confirm("정말로 삭제하시겠습니까?");
    		if(isDelete){
    			location.href = "${pageContext.request.contextPath}/bbs6/bbs/delete/${bbsVO.id}";
    		}
    	});
    </script>
</body>
</html>