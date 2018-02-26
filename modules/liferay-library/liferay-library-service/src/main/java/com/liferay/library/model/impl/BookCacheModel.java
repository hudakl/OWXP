/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.library.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.library.model.Book;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Book in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Book
 * @generated
 */
@ProviderType
public class BookCacheModel implements CacheModel<Book>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BookCacheModel)) {
			return false;
		}

		BookCacheModel bookCacheModel = (BookCacheModel)obj;

		if (bookId == bookCacheModel.bookId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bookId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", bookId=");
		sb.append(bookId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", bookTitle=");
		sb.append(bookTitle);
		sb.append(", author=");
		sb.append(author);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append(", borrowed=");
		sb.append(borrowed);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Book toEntityModel() {
		BookImpl bookImpl = new BookImpl();

		if (uuid == null) {
			bookImpl.setUuid(StringPool.BLANK);
		}
		else {
			bookImpl.setUuid(uuid);
		}

		bookImpl.setBookId(bookId);
		bookImpl.setCompanyId(companyId);
		bookImpl.setUserId(userId);

		if (userName == null) {
			bookImpl.setUserName(StringPool.BLANK);
		}
		else {
			bookImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			bookImpl.setCreateDate(null);
		}
		else {
			bookImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			bookImpl.setModifiedDate(null);
		}
		else {
			bookImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (bookTitle == null) {
			bookImpl.setBookTitle(StringPool.BLANK);
		}
		else {
			bookImpl.setBookTitle(bookTitle);
		}

		if (author == null) {
			bookImpl.setAuthor(StringPool.BLANK);
		}
		else {
			bookImpl.setAuthor(author);
		}

		bookImpl.setQuantity(quantity);
		bookImpl.setBorrowed(borrowed);

		bookImpl.resetOriginalValues();

		return bookImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		bookId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		bookTitle = objectInput.readUTF();
		author = objectInput.readUTF();

		quantity = objectInput.readInt();

		borrowed = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(bookId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (bookTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bookTitle);
		}

		if (author == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(author);
		}

		objectOutput.writeInt(quantity);

		objectOutput.writeInt(borrowed);
	}

	public String uuid;
	public long bookId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String bookTitle;
	public String author;
	public int quantity;
	public int borrowed;
}