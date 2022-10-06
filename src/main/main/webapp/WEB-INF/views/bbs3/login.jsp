<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        /* 기본 */

        * {
            box-sizing: border-box;
        }

        *:focus {
            outline: none;
        }

        body {
            font-family: sans-serif;
            height: 97vh;
        }

        h2 {
            text-align: center;
            font-size: 16px;
            font-weight: 600;
            display: inline-block;
            margin: 40px 8px 10px 8px;
            color: black;
            border-bottom: 2px solid #5fbae9;
        }

        /* 구조 */

        .wrapper {
            display: flex;
            align-items: center;
            flex-direction: column;
            justify-content: center;
            width: 100%;
            min-height: 100%;
            padding: 20px;
        }

        #formContent {
            border : 1px solid black;
            border-radius: 10px 10px 10px 10px;
            background: #fff;
            width: 90%;
            max-width: 450px;
            position: relative;
            padding: 0px;
            text-align: center;
        }


        /* 폼 디자인 */

        button {
            background-color: #56baed;
            border: none;
            color: white;
            padding: 15px 80px;
            text-align: center;
            font-size: 13px;
            box-shadow: 0 10px 30px 0 rgba(95, 186, 233, 0.4);
            border-radius: 5px 5px 5px 5px;
            margin: 5px 20px 40px 20px;
            transition: all 0.3s ease-in-out;
        }

        input {
            background-color: #f6f6f6;
            color: #0d0d0d;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 5px;
            width: 85%;
            border: 2px solid #f6f6f6;
            transition: all 0.5s ease-in-out;
            border-radius: 5px 5px 5px 5px;
        }

        input:focus {
            background-color: #fff;
            border-bottom: 2px solid #5fbae9;
        }

    </style>
</head>

<body>
    <div class="wrapper fadeInDown">
        <div id="formContent">
            <!-- Tabs Titles -->
            <h2 class="active"> 로그인 </h2>

            <!-- Login Form -->
            <form:form modelAttribute="userVO" action="${pageContext.request.contextPath}/bbs3/login" method="post">
                <form:input path="userid" placeholder="아이디를 입력하세요"/>
                <form:password path="password" placeholder="패스워드를 입력하세요"/>
                <button>Log in</button>
            </form:form>

        </div>
    </div>
</body>

</html>