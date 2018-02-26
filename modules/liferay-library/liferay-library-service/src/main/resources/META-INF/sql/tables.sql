create table Library_Book (
	uuid_ VARCHAR(75) null,
	bookId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	bookTitle VARCHAR(75) null,
	author VARCHAR(75) null,
	quantity INTEGER,
	borrowed INTEGER
);