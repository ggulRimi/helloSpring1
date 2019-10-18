<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
    <title>게시판</title>
</head>
<body>
<h1>
    게시판 등록하기 
</h1>
    
    <form action="create" method="POST">
        <div class="createForm">
            <label >제목</label>
            <input type="text" name="b_title" class="createForm" placeholder = "게시판 제목">
        </div>
        <div class="createForm">
            <label >내용</label>
            <textarea rows="4" cols="15" name="b_detail" class="createForm" placeholder = "게시판 내용"></textarea>
        </div>
        <div class="createForm">
            <label >작성자</label>
            <input type="text" name="b_writer" class="createForm" placeholder = "작성자">
        </div>
        
        <div class="Formfooter">
                <button type="submit" class="btn_button">작성하기</button>
        </div>            
        
    </form>
 
    
</body>
</html>


