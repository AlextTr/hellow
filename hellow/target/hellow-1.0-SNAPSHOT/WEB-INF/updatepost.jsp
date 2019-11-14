<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
	<head>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" ></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" >
	</head>
	<body>
	<a href="/hellow/">Back to main page</a>
	<p></p>
<form:form action="/hellow/updatePost" class="form" method="POST" modelAttribute="updatethispost">
                        <form:hidden path="id" />
                        <div class="form-group">
                            <label for="postName">Post name</label>
                            <form:input width="100" path="postName" value="${postName}" class="form-control" placeholder="Enter post name"/>
                        </div>
                        <div class="form-group">
                            <label for="postText">Post text</label>
                            <form:textarea path="postText" value="${postText}" class="form-control" placeholder="Post's text" />
                        </div>
                        <div>
                            <form:button class="btn btn-primary">Update post</form:button>
                        </div>
                    </form:form>

	</body>
</html>