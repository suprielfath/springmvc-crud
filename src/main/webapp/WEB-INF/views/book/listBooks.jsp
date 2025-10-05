<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<html>
<head>
<title>List Of Books</title>

<s:url value="/resources/lib/bootstrap-3.3.6/css/bootstrap.min.css" var="bootstrapCssUrl" />
<s:url value="/resources/lib/jquery/jquery-ui-1.10.4.custom.css" var="jqueryUiCssUrl" />
<link rel="stylesheet" href="${bootstrapCssUrl}">
<link rel="stylesheet" href="${jqueryUiCssUrl}">

<style type="text/css">
th {
	text-align: left
}
</style>

</head>

<body>
	<div style="width: 95%; margin: 0 auto;">

		<div id="bookDialog" style="display: none;">
			<%@ include file="bookForm.jsp"%>
		</div>

		<h1>List Of Books</h1>

		<button class="btn btn-primary" onclick="addBook()">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add Book
		</button>
		<br>
		<br>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="4%">No.</th>
					<th width="12%">Title</th>
					<th width="12%">Authors</th>
					<th width="12%">Publisher</th>
					<th width="12%">Published Date</th>
					<th width="12%">Number Of Pages</th>
					<th width="12%">Type Of Book</th>
					<th width="12%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${bookList}" var="book" varStatus="loopCounter">
					<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<td><c:out value="${book.title}" /></td>
						<td><c:out value="${book.authors}" /></td>
						<td><c:out value="${book.publisher}" /></td>
						<td><c:out value="${book.publishedOn}" /></td>
						<td><c:out value="${book.numberOfPages}" /></td>
						<td><c:out value="${book.typeOfBook}" /></td>
						<td><nobr>
								<button class="btn btn-primary"
									onclick="editBook(${book.id});">

									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Edit
								</button>

								<s:url value="/book/delete/${book.id}" var="deleteUrl" />
								<a class="btn btn-primary"
									onclick="return confirm('Are you sure you want to delete this book?');"
									href="${deleteUrl}">
									<span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Delete
								</a>

							</nobr></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<s:url value="/resources/lib/jquery/jquery-1.10.2.js" var="jqueryUrl" />
	<s:url value="/resources/lib/jquery/jquery-ui-1.10.4.custom.js" var="jqueryUiUrl" />
	<s:url value="/resources/lib/jquery/jquery.ui.datepicker.js" var="datepickerUrl" />
	<s:url value="/resources/lib/bootstrap-3.3.6/js/bootstrap.min.js" var="bootstrapJsUrl" />
	<s:url value="/resources/js/js-for-listBooks.js" var="mainJsUrl" />

	<script type="text/javascript" src="${jqueryUrl}"></script>
	<script type="text/javascript" src="${jqueryUiUrl}"></script>
	<script type="text/javascript" src="${datepickerUrl}"></script>
	<script type="text/javascript" src="${bootstrapJsUrl}"></script>
	<script type="text/javascript" src="${mainJsUrl}"></script>
</body>
</html>