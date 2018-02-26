create index IX_FA732BF2 on Library_Book (author[$COLUMN_LENGTH:75$]);
create index IX_F74BAC8B on Library_Book (bookTitle[$COLUMN_LENGTH:75$], author[$COLUMN_LENGTH:75$]);
create index IX_E6A5203B on Library_Book (borrowed);
create index IX_FECA85B2 on Library_Book (quantity);
create index IX_29A6DBE7 on Library_Book (uuid_[$COLUMN_LENGTH:75$], companyId);