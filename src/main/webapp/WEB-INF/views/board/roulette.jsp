<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Modern Business - Start Bootstrap Template</title>
        <!-- css favicon -->
        <c:import url="../temp/style.jsp"></c:import>
        <!-- css favicon -->
        <link href="/css/roulette.css" rel="stylesheet">
    </head>
</head>
<body>
 <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
         <!-- Navigation-->
            <c:import url="../temp/header.jsp"></c:import>
         <!-- Header-->
        <div>
		  <canvas width="380" height='380'></canvas>  
		  <button onclick="rotate()">룰렛 돌리기</button>
		</div>
         
            
        </main>
             <!-- Footer 적용-->
             
 <c:import url="../temp/footer.jsp"></c:import>
 			 <!-- Footer 끝 -->
 <script type="text/javascript" src="../js/boardform.js"></script>
 <script type="text/javascript" src="../js/roulette.js"></script>
</body>
</html>