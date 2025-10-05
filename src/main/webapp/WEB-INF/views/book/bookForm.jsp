<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="actionUrl" value="/book/save" />

<form:form id="bookForm" commandName="book" method="post"
	action="${actionUrl }" class="form-horizontal">

	<form:errors path="*" cssClass="alert alert-danger" element="div" />

	<div class="form-group">
		<label for="name" class="col-xs-4 control-label">Title</label>
		<div class="col-xs-8">
			<form:input name="title" path="title" placeholder="Title"
				class="form-control" />
		</div>
	</div>

	<div class="form-group">
		<label for="authors" class="col-xs-4 control-label">Author(s)</label>
		<div class="col-xs-8">
			<form:input path="authors" placeholder="Authors" class="form-control" />
		</div>
	</div>

	<div class="form-group">
		<label for="publisher" class="col-xs-4 control-label">Publisher</label>
		<div class="col-xs-8">
			<form:input path="publisher" placeholder="Publisher"
				class="form-control" />
		</div>
	</div>

	<div class="form-group">
		<label for="publishedOn" class="col-xs-4 control-label">Published
			Date</label>
		<div class="col-xs-8">
			<form:input path="publishedOn" placeholder="YYYY-MM-DD"
				class="datepicker form-control" />
		</div>
	</div>
	
	<div class="form-group">
		<label for="numberOfPages" class="col-xs-4 control-label">Number Of Pages</label>
		<div class="col-xs-8">
			<form:input path="numberOfPages" placeholder="Number Of Pages" class="form-control" />
		</div>
	</div>
	
	<div class="form-group">
		<label for="typeOfBook" class="col-xs-4 control-label">Type Of Book</label>
		<div class="col-xs-8">
			<form:select path="typeOfBook" placeholder="Type Of Book" class="form-control">
			 <form:options items="${typeBookList}" />
			</form:select>			
		</div>
	</div>

	<form:input path="id" type="hidden" />
</form:form>