<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="Liferay Library"/></b>
</p>



<div class="container-fluid-1280">
	<div class="flex-container">

	<liferay-ui:search-container
		emptyResultsMessage="No books found."
		var="bookSearchContainer"
	>

	<liferay-ui:search-container-results results="<%= BookLocalServiceUtil.getBooks(searchContainer.getStart(), searchContainer.getEnd()) %>" />

		<liferay-ui:search-container-row
			className="com.liferay.library.model.Book"
			escapedModel="<%= true %>"
			keyProperty="bookId"
			modelVar="book"
		>
			<liferay-ui:search-container-column-text
				cssClass="table-cell-content"
				name="author"
				orderable="<%= true %>"
				value="<%= book.getAuthor() %>"
			/>

			<liferay-ui:search-container-column-text
				cssClass="table-cell-content"
				name="bookTitle"
				orderable="<%= true %>"
				value="<%= book.getTitle() %>"
			/>
			
			<liferay-ui:search-container-column-text
				cssClass="table-cell-content"
				name="quantity"
				orderable="<%= true %>"
				value="<%= book.getQuantity() %>"
			/>

			<liferay-ui:search-container-column-text
				cssClass="table-cell-content"
				name="borrowed"
				orderable="<%= true %>"
				value="<%= book.getBorrowed() %>"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator markupView="lexicon" />
	</liferay-ui:search-container>