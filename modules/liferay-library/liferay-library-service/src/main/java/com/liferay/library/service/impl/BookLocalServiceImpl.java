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

package com.liferay.library.service.impl;

import java.util.Date;

import com.liferay.library.model.Book;
import com.liferay.library.service.base.BookLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the book local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.library.service.BookLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookLocalServiceBaseImpl
 * @see com.liferay.library.service.BookLocalServiceUtil
 */
@ProviderType
public class BookLocalServiceImpl extends BookLocalServiceBaseImpl {
	
	@Override
	public Book addBook(
			long userId, String author, String bookTitle, int quantity)
		throws PortalException {

		User user = UserLocalServiceUtil.getUser(userId);
		long bookId = counterLocalService.increment();
		Date now = new Date();

		Book book = bookPersistence.create(bookId);

		book.setAuthor(author);
		book.setBookTitle(bookTitle);
		book.setQuantity(quantity);
		book.setBorrowed(0);

		book.setCompanyId(user.getCompanyId());
		book.setUserId(userId);
		book.setUserName(user.getFullName());
		book.setCreateDate(now);
		book.setModifiedDate(now);

		return bookPersistence.update(book);
	}

	@Override
	public Book borrowBook(long bookId)
		throws PortalException {

		Book book = bookPersistence.findByPrimaryKey(bookId);

		int quantity = book.getQuantity();
		int borrowed = book.getBorrowed();

		if (quantity == borrowed) {
			throw new PortalException("All the books are borrowed.");
		}

		book.setBorrowed(++borrowed);

		return bookPersistence.update(book);
	}

	@Override
	public Book updateBook(
			long bookId, long userId, String author, String bookTitle,
			int quantity)
		throws PortalException {

		Book book = bookPersistence.findByPrimaryKey(bookId);
		User user = UserLocalServiceUtil.getUser(userId);
		Date now = new Date();

		book.setAuthor(author);
		book.setBookTitle(bookTitle);
		book.setQuantity(quantity);

		book.setCompanyId(user.getCompanyId());
		book.setUserId(userId);
		book.setUserName(user.getFullName());
		book.setModifiedDate(now);

		return bookPersistence.update(book);
	}
}