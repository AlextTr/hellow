<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" ></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" >
	</head>
	<a href="/hellow/">Back to main page</a>
	<p></p>
        <button onclick="document.location='/hellow/postCreate'">Add new post</button>
	<body>
	<h4>All Posts:</h4>
		<c:forEach var="allposts" items="${posts}">
		    <div class="text-truncate d-block" style="width: 20rem">
		    	<a href="/hellow/watchPost/${allposts.id}">${allposts.postName}</a>
		    </div>
		</c:forEach>
	</body>
</html>