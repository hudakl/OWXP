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

package com.liferay.library.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Book service. Represents a row in the &quot;Library_Book&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.library.model.impl.BookModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.library.model.impl.BookImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Book
 * @see com.liferay.library.model.impl.BookImpl
 * @see com.liferay.library.model.impl.BookModelImpl
 * @generated
 */
@ProviderType
public interface BookModel extends BaseModel<Book>, ShardedModel,
	StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a book model instance should use the {@link Book} interface instead.
	 */

	/**
	 * Returns the primary key of this book.
	 *
	 * @return the primary key of this book
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this book.
	 *
	 * @param primaryKey the primary key of this book
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this book.
	 *
	 * @return the uuid of this book
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this book.
	 *
	 * @param uuid the uuid of this book
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the book ID of this book.
	 *
	 * @return the book ID of this book
	 */
	public long getBookId();

	/**
	 * Sets the book ID of this book.
	 *
	 * @param bookId the book ID of this book
	 */
	public void setBookId(long bookId);

	/**
	 * Returns the company ID of this book.
	 *
	 * @return the company ID of this book
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this book.
	 *
	 * @param companyId the company ID of this book
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this book.
	 *
	 * @return the user ID of this book
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this book.
	 *
	 * @param userId the user ID of this book
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this book.
	 *
	 * @return the user uuid of this book
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this book.
	 *
	 * @param userUuid the user uuid of this book
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this book.
	 *
	 * @return the user name of this book
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this book.
	 *
	 * @param userName the user name of this book
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this book.
	 *
	 * @return the create date of this book
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this book.
	 *
	 * @param createDate the create date of this book
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this book.
	 *
	 * @return the modified date of this book
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this book.
	 *
	 * @param modifiedDate the modified date of this book
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the book title of this book.
	 *
	 * @return the book title of this book
	 */
	@AutoEscape
	public String getBookTitle();

	/**
	 * Sets the book title of this book.
	 *
	 * @param bookTitle the book title of this book
	 */
	public void setBookTitle(String bookTitle);

	/**
	 * Returns the author of this book.
	 *
	 * @return the author of this book
	 */
	@AutoEscape
	public String getAuthor();

	/**
	 * Sets the author of this book.
	 *
	 * @param author the author of this book
	 */
	public void setAuthor(String author);

	/**
	 * Returns the quantity of this book.
	 *
	 * @return the quantity of this book
	 */
	public int getQuantity();

	/**
	 * Sets the quantity of this book.
	 *
	 * @param quantity the quantity of this book
	 */
	public void setQuantity(int quantity);

	/**
	 * Returns the borrowed of this book.
	 *
	 * @return the borrowed of this book
	 */
	public int getBorrowed();

	/**
	 * Sets the borrowed of this book.
	 *
	 * @param borrowed the borrowed of this book
	 */
	public void setBorrowed(int borrowed);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Book book);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Book> toCacheModel();

	@Override
	public Book toEscapedModel();

	@Override
	public Book toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}