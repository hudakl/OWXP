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

package com.liferay.library.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.library.exception.NoSuchBookException;
import com.liferay.library.model.Book;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the book service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.library.service.persistence.impl.BookPersistenceImpl
 * @see BookUtil
 * @generated
 */
@ProviderType
public interface BookPersistence extends BasePersistence<Book> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BookUtil} to access the book persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the books where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching books
	*/
	public java.util.List<Book> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the books where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of books
	* @param end the upper bound of the range of books (not inclusive)
	* @return the range of matching books
	*/
	public java.util.List<Book> findByUuid(java.lang.String uuid, int start,
		int end);

	/**
	* Returns an ordered range of all the books where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of books
	* @param end the upper bound of the range of books (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching books
	*/
	public java.util.List<Book> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

	/**
	* Returns an ordered range of all the books where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of books
	* @param end the upper bound of the range of books (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching books
	*/
	public java.util.List<Book> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first book in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching book
	* @throws NoSuchBookException if a matching book could not be found
	*/
	public Book findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
		throws NoSuchBookException;

	/**
	* Returns the first book in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching book, or <code>null</code> if a matching book could not be found
	*/
	public Book fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

	/**
	* Returns the last book in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching book
	* @throws NoSuchBookException if a matching book could not be found
	*/
	public Book findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
		throws NoSuchBookException;

	/**
	* Returns the last book in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching book, or <code>null</code> if a matching book could not be found
	*/
	public Book fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

	/**
	* Returns the books before and after the current book in the ordered set where uuid = &#63;.
	*
	* @param bookId the primary key of the current book
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next book
	* @throws NoSuchBookException if a book with the primary key could not be found
	*/
	public Book[] findByUuid_PrevAndNext(long bookId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
		throws NoSuchBookException;

	/**
	* Removes all the books where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of books where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching books
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the books where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching books
	*/
	public java.util.List<Book> findByUuid_C(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of all the books where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of books
	* @param end the upper bound of the range of books (not inclusive)
	* @return the range of matching books
	*/
	public java.util.List<Book> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the books where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of books
	* @param end the upper bound of the range of books (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching books
	*/
	public java.util.List<Book> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

	/**
	* Returns an ordered range of all the books where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of books
	* @param end the upper bound of the range of books (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching books
	*/
	public java.util.List<Book> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first book in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching book
	* @throws NoSuchBookException if a matching book could not be found
	*/
	public Book findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
		throws NoSuchBookException;

	/**
	* Returns the first book in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching book, or <code>null</code> if a matching book could not be found
	*/
	public Book fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

	/**
	* Returns the last book in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching book
	* @throws NoSuchBookException if a matching book could not be found
	*/
	public Book findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
		throws NoSuchBookException;

	/**
	* Returns the last book in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching book, or <code>null</code> if a matching book could not be found
	*/
	public Book fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

	/**
	* Returns the books before and after the current book in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param bookId the primary key of the current book
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next book
	* @throws NoSuchBookException if a book with the primary key could not be found
	*/
	public Book[] findByUuid_C_PrevAndNext(long bookId, java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
		throws NoSuchBookException;

	/**
	* Removes all the books where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of books where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching books
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the book where bookTitle = &#63; or throws a {@link NoSuchBookException} if it could not be found.
	*
	* @param bookTitle the book title
	* @return the matching book
	* @throws NoSuchBookException if a matching book could not be found
	*/
	public Book findByBookTitle(java.lang.String bookTitle)
		throws NoSuchBookException;

	/**
	* Returns the book where bookTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param bookTitle the book title
	* @return the matching book, or <code>null</code> if a matching book could not be found
	*/
	public Book fetchByBookTitle(java.lang.String bookTitle);

	/**
	* Returns the book where bookTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param bookTitle the book title
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching book, or <code>null</code> if a matching book could not be found
	*/
	public Book fetchByBookTitle(java.lang.String bookTitle,
		boolean retrieveFromCache);

	/**
	* Removes the book where bookTitle = &#63; from the database.
	*
	* @param bookTitle the book title
	* @return the book that was removed
	*/
	public Book removeByBookTitle(java.lang.String bookTitle)
		throws NoSuchBookException;

	/**
	* Returns the number of books where bookTitle = &#63;.
	*
	* @param bookTitle the book title
	* @return the number of matching books
	*/
	public int countByBookTitle(java.lang.String bookTitle);

	/**
	* Returns the book where bookTitle = &#63; and author = &#63; or throws a {@link NoSuchBookException} if it could not be found.
	*
	* @param bookTitle the book title
	* @param author the author
	* @return the matching book
	* @throws NoSuchBookException if a matching book could not be found
	*/
	public Book findByBookTitleAuthor(java.lang.String bookTitle,
		java.lang.String author) throws NoSuchBookException;

	/**
	* Returns the book where bookTitle = &#63; and author = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param bookTitle the book title
	* @param author the author
	* @return the matching book, or <code>null</code> if a matching book could not be found
	*/
	public Book fetchByBookTitleAuthor(java.lang.String bookTitle,
		java.lang.String author);

	/**
	* Returns the book where bookTitle = &#63; and author = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param bookTitle the book title
	* @param author the author
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching book, or <code>null</code> if a matching book could not be found
	*/
	public Book fetchByBookTitleAuthor(java.lang.String bookTitle,
		java.lang.String author, boolean retrieveFromCache);

	/**
	* Removes the book where bookTitle = &#63; and author = &#63; from the database.
	*
	* @param bookTitle the book title
	* @param author the author
	* @return the book that was removed
	*/
	public Book removeByBookTitleAuthor(java.lang.String bookTitle,
		java.lang.String author) throws NoSuchBookException;

	/**
	* Returns the number of books where bookTitle = &#63; and author = &#63;.
	*
	* @param bookTitle the book title
	* @param author the author
	* @return the number of matching books
	*/
	public int countByBookTitleAuthor(java.lang.String bookTitle,
		java.lang.String author);

	/**
	* Returns all the books where author = &#63;.
	*
	* @param author the author
	* @return the matching books
	*/
	public java.util.List<Book> findByAuthor(java.lang.String author);

	/**
	* Returns a range of all the books where author = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param author the author
	* @param start the lower bound of the range of books
	* @param end the upper bound of the range of books (not inclusive)
	* @return the range of matching books
	*/
	public java.util.List<Book> findByAuthor(java.lang.String author,
		int start, int end);

	/**
	* Returns an ordered range of all the books where author = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param author the author
	* @param start the lower bound of the range of books
	* @param end the upper bound of the range of books (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching books
	*/
	public java.util.List<Book> findByAuthor(java.lang.String author,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

	/**
	* Returns an ordered range of all the books where author = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param author the author
	* @param start the lower bound of the range of books
	* @param end the upper bound of the range of books (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching books
	*/
	public java.util.List<Book> findByAuthor(java.lang.String author,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first book in the ordered set where author = &#63;.
	*
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching book
	* @throws NoSuchBookException if a matching book could not be found
	*/
	public Book findByAuthor_First(java.lang.String author,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
		throws NoSuchBookException;

	/**
	* Returns the first book in the ordered set where author = &#63;.
	*
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching book, or <code>null</code> if a matching book could not be found
	*/
	public Book fetchByAuthor_First(java.lang.String author,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

	/**
	* Returns the last book in the ordered set where author = &#63;.
	*
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching book
	* @throws NoSuchBookException if a matching book could not be found
	*/
	public Book findByAuthor_Last(java.lang.String author,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
		throws NoSuchBookException;

	/**
	* Returns the last book in the ordered set where author = &#63;.
	*
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching book, or <code>null</code> if a matching book could not be found
	*/
	public Book fetchByAuthor_Last(java.lang.String author,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

	/**
	* Returns the books before and after the current book in the ordered set where author = &#63;.
	*
	* @param bookId the primary key of the current book
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next book
	* @throws NoSuchBookException if a book with the primary key could not be found
	*/
	public Book[] findByAuthor_PrevAndNext(long bookId,
		java.lang.String author,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
		throws NoSuchBookException;

	/**
	* Removes all the books where author = &#63; from the database.
	*
	* @param author the author
	*/
	public void removeByAuthor(java.lang.String author);

	/**
	* Returns the number of books where author = &#63;.
	*
	* @param author the author
	* @return the number of matching books
	*/
	public int countByAuthor(java.lang.String author);

	/**
	* Returns all the books where quantity = &#63;.
	*
	* @param quantity the quantity
	* @return the matching books
	*/
	public java.util.List<Book> findByQuantity(int quantity);

	/**
	* Returns a range of all the books where quantity = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param quantity the quantity
	* @param start the lower bound of the range of books
	* @param end the upper bound of the range of books (not inclusive)
	* @return the range of matching books
	*/
	public java.util.List<Book> findByQuantity(int quantity, int start, int end);

	/**
	* Returns an ordered range of all the books where quantity = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param quantity the quantity
	* @param start the lower bound of the range of books
	* @param end the upper bound of the range of books (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching books
	*/
	public java.util.List<Book> findByQuantity(int quantity, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

	/**
	* Returns an ordered range of all the books where quantity = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param quantity the quantity
	* @param start the lower bound of the range of books
	* @param end the upper bound of the range of books (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching books
	*/
	public java.util.List<Book> findByQuantity(int quantity, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first book in the ordered set where quantity = &#63;.
	*
	* @param quantity the quantity
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching book
	* @throws NoSuchBookException if a matching book could not be found
	*/
	public Book findByQuantity_First(int quantity,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
		throws NoSuchBookException;

	/**
	* Returns the first book in the ordered set where quantity = &#63;.
	*
	* @param quantity the quantity
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching book, or <code>null</code> if a matching book could not be found
	*/
	public Book fetchByQuantity_First(int quantity,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

	/**
	* Returns the last book in the ordered set where quantity = &#63;.
	*
	* @param quantity the quantity
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching book
	* @throws NoSuchBookException if a matching book could not be found
	*/
	public Book findByQuantity_Last(int quantity,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
		throws NoSuchBookException;

	/**
	* Returns the last book in the ordered set where quantity = &#63;.
	*
	* @param quantity the quantity
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching book, or <code>null</code> if a matching book could not be found
	*/
	public Book fetchByQuantity_Last(int quantity,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

	/**
	* Returns the books before and after the current book in the ordered set where quantity = &#63;.
	*
	* @param bookId the primary key of the current book
	* @param quantity the quantity
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next book
	* @throws NoSuchBookException if a book with the primary key could not be found
	*/
	public Book[] findByQuantity_PrevAndNext(long bookId, int quantity,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
		throws NoSuchBookException;

	/**
	* Removes all the books where quantity = &#63; from the database.
	*
	* @param quantity the quantity
	*/
	public void removeByQuantity(int quantity);

	/**
	* Returns the number of books where quantity = &#63;.
	*
	* @param quantity the quantity
	* @return the number of matching books
	*/
	public int countByQuantity(int quantity);

	/**
	* Returns all the books where borrowed = &#63;.
	*
	* @param borrowed the borrowed
	* @return the matching books
	*/
	public java.util.List<Book> findByBorrowed(int borrowed);

	/**
	* Returns a range of all the books where borrowed = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param borrowed the borrowed
	* @param start the lower bound of the range of books
	* @param end the upper bound of the range of books (not inclusive)
	* @return the range of matching books
	*/
	public java.util.List<Book> findByBorrowed(int borrowed, int start, int end);

	/**
	* Returns an ordered range of all the books where borrowed = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param borrowed the borrowed
	* @param start the lower bound of the range of books
	* @param end the upper bound of the range of books (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching books
	*/
	public java.util.List<Book> findByBorrowed(int borrowed, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

	/**
	* Returns an ordered range of all the books where borrowed = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param borrowed the borrowed
	* @param start the lower bound of the range of books
	* @param end the upper bound of the range of books (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching books
	*/
	public java.util.List<Book> findByBorrowed(int borrowed, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first book in the ordered set where borrowed = &#63;.
	*
	* @param borrowed the borrowed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching book
	* @throws NoSuchBookException if a matching book could not be found
	*/
	public Book findByBorrowed_First(int borrowed,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
		throws NoSuchBookException;

	/**
	* Returns the first book in the ordered set where borrowed = &#63;.
	*
	* @param borrowed the borrowed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching book, or <code>null</code> if a matching book could not be found
	*/
	public Book fetchByBorrowed_First(int borrowed,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

	/**
	* Returns the last book in the ordered set where borrowed = &#63;.
	*
	* @param borrowed the borrowed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching book
	* @throws NoSuchBookException if a matching book could not be found
	*/
	public Book findByBorrowed_Last(int borrowed,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
		throws NoSuchBookException;

	/**
	* Returns the last book in the ordered set where borrowed = &#63;.
	*
	* @param borrowed the borrowed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching book, or <code>null</code> if a matching book could not be found
	*/
	public Book fetchByBorrowed_Last(int borrowed,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

	/**
	* Returns the books before and after the current book in the ordered set where borrowed = &#63;.
	*
	* @param bookId the primary key of the current book
	* @param borrowed the borrowed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next book
	* @throws NoSuchBookException if a book with the primary key could not be found
	*/
	public Book[] findByBorrowed_PrevAndNext(long bookId, int borrowed,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
		throws NoSuchBookException;

	/**
	* Removes all the books where borrowed = &#63; from the database.
	*
	* @param borrowed the borrowed
	*/
	public void removeByBorrowed(int borrowed);

	/**
	* Returns the number of books where borrowed = &#63;.
	*
	* @param borrowed the borrowed
	* @return the number of matching books
	*/
	public int countByBorrowed(int borrowed);

	/**
	* Caches the book in the entity cache if it is enabled.
	*
	* @param book the book
	*/
	public void cacheResult(Book book);

	/**
	* Caches the books in the entity cache if it is enabled.
	*
	* @param books the books
	*/
	public void cacheResult(java.util.List<Book> books);

	/**
	* Creates a new book with the primary key. Does not add the book to the database.
	*
	* @param bookId the primary key for the new book
	* @return the new book
	*/
	public Book create(long bookId);

	/**
	* Removes the book with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookId the primary key of the book
	* @return the book that was removed
	* @throws NoSuchBookException if a book with the primary key could not be found
	*/
	public Book remove(long bookId) throws NoSuchBookException;

	public Book updateImpl(Book book);

	/**
	* Returns the book with the primary key or throws a {@link NoSuchBookException} if it could not be found.
	*
	* @param bookId the primary key of the book
	* @return the book
	* @throws NoSuchBookException if a book with the primary key could not be found
	*/
	public Book findByPrimaryKey(long bookId) throws NoSuchBookException;

	/**
	* Returns the book with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bookId the primary key of the book
	* @return the book, or <code>null</code> if a book with the primary key could not be found
	*/
	public Book fetchByPrimaryKey(long bookId);

	@Override
	public java.util.Map<java.io.Serializable, Book> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the books.
	*
	* @return the books
	*/
	public java.util.List<Book> findAll();

	/**
	* Returns a range of all the books.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of books
	* @param end the upper bound of the range of books (not inclusive)
	* @return the range of books
	*/
	public java.util.List<Book> findAll(int start, int end);

	/**
	* Returns an ordered range of all the books.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of books
	* @param end the upper bound of the range of books (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of books
	*/
	public java.util.List<Book> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

	/**
	* Returns an ordered range of all the books.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of books
	* @param end the upper bound of the range of books (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of books
	*/
	public java.util.List<Book> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the books from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of books.
	*
	* @return the number of books
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}