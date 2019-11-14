<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" ></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" >
	</head>
	<body>
	<a href="/hellow/">Back to main page</a>
	<p></p>
		    <div class="text-truncate d-block" style="width: 20rem">
		    <h4>Post text:</h4>
		    ${post.postText}
		    	<p></p>
		    <h4>Post owner:</h4>
		    ${post.postCreator}
                <p></p>
		    	 <c:if test="${user == post.postCreator}">
		    	     <button onclick="document.location='/hellow/updatePost/${post.id}'">Update</button>
                     <button onclick="document.location='/hellow/deletePost/${post.id}'">Delete</button>
                 </c:if>

                 <h4>Comments to post:</h4>
                   <button onclick="document.location='/hellow/commentCreate/${post.id}'">Add new comment</button>
                    <p></p>
                 <c:forEach var="comment" items="${comments}">
                 		    <div class="text-truncate d-block" style="width: 20rem">
                 		    	${comment.commentText}
                                <c:if test="${user == comment.commentOwner}">
		    	                    <button onclick="document.location='/hellow/updateComment/${comment.id}'">Update comment</button>
                                    <button onclick="document.location='/hellow/deleteComment/${comment.id}'">Delete comment</button>
                                </c:if>
                                 <c:if test="${user != comment.commentOwner && user == post.postCreator}">
                                     <button onclick="document.location='/hellow/deleteComment/${comment.id}'">Delete comment</button>
                                 </c:if>
                                <p></p>
                            </div>
                 </c:forEach>
                  <c:if test="${user == post.postCreator}">
                        <button onclick="document.location='/hellow/deleteAllComments/${post.id}'">Delete all comments</button>
                  </c:if>
		    </div>

	</body>
</html>