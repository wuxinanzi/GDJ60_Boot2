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
        <link href="/css/boardSidebar.css" rel="stylesheet">
    </head>
</head>
<body>
 <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
         <!-- Navigation-->
            <c:import url="../temp/header.jsp"></c:import>
         <!-- Header-->
         <div id="sidebar" class="card my-3">
        	<a href="https://www.naver.com" class="naver-link">무엇이든 도와드리겠습니다</a>
        </div>
         
         <section class="bg-light py-5">
                <div class="container px-5 my-5">
                    <div class="text-center mb-5">
                        <h1 class="fw-bolder">${board} List</h1>
                        <p class="lead fw-normal text-muted mb-0">With our no hassle pricing plans</p>
                    </div>
                    <div>
                    	<table class="table table-hover">
                    		<thead>
                    		<tr>
                    			<th>Num</th>
								<th>Title</th>
								<th>Writer</th>
								<th>Date</th>
								<th>Hit</th>                  
                    		</tr>
                    		</thead>
                    		<tbody>
                    		<c:forEach items="${list}" var="boardVO">
                    			<tr>
                    				<td>${boardVO.num}</td>
                    				<td><a href="./detail?num=${boardVO.num}">${boardVO.title}</a></td>
                    				<td>${boardVO.writer}</td>
                    				<td>${boardVO.regDate}</td>
                    				<td>${boardVO.hit}</td>
                    			</tr>
                    		</c:forEach>
                    		</tbody>
                    	</table>
                    	<c:if test="${pager.pre}">
                    		<a href="./list?page=${pager.startNum-1}">이전</a>
                    	</c:if>
                    	
                    	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
                    			<a href="./list?page=${i}">${i}</a>
                    	</c:forEach>
                    	
                    	<c:if test="${pager.next}">
                    		<a href="./list?page=${pager.lastNum+1}">다음</a>
                    	</c:if>
                    	
                    	<form action="./list">
                    	<select>
                    		<option value="title">Title</option>
                    		<option value="contents">Contents</option>
                    		<option value="writer">Writer</option>
                    	</select>
                    	
                    	<input type="text" name="search">
                    	<button type="submit">Search</button>
                    	</form>
                    </div>
                  </div>
                  </section>
                  
                  <a href="./add">WRITE</a> 
        </main>
             <!-- Footer 적용-->
 <c:import url="../temp/footer.jsp"></c:import>
 <c:import url="../temp/roulette.jsp"></c:import>
      <!-- Footer 끝 -->
</body>
</html>