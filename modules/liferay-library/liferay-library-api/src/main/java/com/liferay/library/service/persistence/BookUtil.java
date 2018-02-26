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

import com.liferay.library.model.Book;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the book service. This utility wraps {@link com.liferay.library.service.persistence.impl.BookPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookPersistence
 * @see com.liferay.library.service.persistence.impl.BookPersistenceImpl
 * @generated
 */
@ProviderType
public class BookUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Book book) {
		getPersistence().clearCache(book);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Book> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Book> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Book> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Book> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Book update(Book book) {
		return getPersistence().update(book);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Book update(Book book, ServiceContext serviceContext) {
		return getPersistence().update(book, serviceContext);
	}

	/**
	* Returns all the books where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching books
	*/
	public static List<Book> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Book> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Book> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Book> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Book> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Book> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first book in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching book
	* @throws NoSuchBookException if a matching book could not be found
	*/
	public static Book findByUuid_First(java.lang.String uuid,
		OrderByComparator<Book> orderByComparator)
		throws com.liferay.library.exception.NoSuchBookException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first book in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching book, or <code>null</code> if a matching book could not be found
	*/
	public static Book fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Book> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last book in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching book
	* @throws NoSuchBookException if a matching book could not be found
	*/
	public static Book findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Book> orderByComparator)
		throws com.liferay.library.exception.NoSuchBookException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last book in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching book, or <code>null</code> if a matching book could not be found
	*/
	public static Book fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Book> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the books before and after the current book in the ordered set where uuid = &#63;.
	*
	* @param bookId the primary key of the current book
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next book
	* @throws NoSuchBookException if a book with the primary key could not be found
	*/
	public static Book[] findByUuid_PrevAndNext(long bookId,
		java.lang.String uuid, OrderByComparator<Book> orderByComparator)
		throws com.liferay.library.exception.NoSuchBookException {
		return getPersistence()
				   .findByUuid_PrevAndNext(bookId, uuid, orderByComparator);
	}

	/**
	* Removes all the books where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of books where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching books
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the books where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching books
	*/
	public static List<Book> findByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<Book> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<Book> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Book> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<Book> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Book> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first book in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching book
	* @throws NoSuchBookException if a matching book could not be found
	*/
	public static Book findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Book> orderByComparator)
		throws com.liferay.library.exception.NoSuchBookException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first book in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching book, or <code>null</code> if a matching book could not be found
	*/
	public static Book fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Book> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last book in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching book
	* @throws NoSuchBookException if a matching book could not be found
	*/
	public static Book findByUuid_C_Last(java.lang.String uuid, long companyId,
		OrderByComparator<Book> orderByComparator)
		throws com.liferay.library.exception.NoSuchBookException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last book in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching book, or <code>null</code> if a matching book could not be found
	*/
	public static Book fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Book> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static Book[] findByUuid_C_PrevAndNext(long bookId,
		java.lang.String uuid, long companyId,
		OrderByComparator<Book> orderByComparator)
		throws com.liferay.library.exception.NoSuchBookException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(bookId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the books where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of books where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching books
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns the book where bookTitle = &#63; or throws a {@link NoSuchBookException} if it could not be found.
	*
	* @param bookTitle the book title
	* @return the matching book
	* @throws NoSuchBookException if a matching book could not be found
	*/
	public static Book findByBookTitle(java.lang.String bookTitle)
		throws com.liferay.library.exception.NoSuchBookException {
		return getPersistence().findByBookTitle(bookTitle);
	}

	/**
	* Returns the book where bookTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param bookTitle the book title
	* @return the matching book, or <code>null</code> if a matching book could not be found
	*/
	public static Book fetchByBookTitle(java.lang.String bookTitle) {
		return getPersistence().fetchByBookTitle(bookTitle);
	}

	/**
	* Returns the book where bookTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param bookTitle the book title
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching book, or <code>null</code> if a matching book could not be found
	*/
	public static Book fetchByBookTitle(java.lang.String bookTitle,
		boolean retrieveFromCache) {
		return getPersistence().fetchByBookTitle(bookTitle, retrieveFromCache);
	}

	/**
	* Removes the book where bookTitle = &#63; from the database.
	*
	* @param bookTitle the book title
	* @return the book that was removed
	*/
	public static Book removeByBookTitle(java.lang.String bookTitle)
		throws com.liferay.library.exception.NoSuchBookException {
		return getPersistence().removeByBookTitle(bookTitle);
	}

	/**
	* Returns the number of books where bookTitle = &#63;.
	*
	* @param bookTitle the book title
	* @return the number of matching books
	*/
	public static int countByBookTitle(java.lang.String bookTitle) {
		return getPersistence().countByBookTitle(bookTitle);
	}

	/**
	* Returns the book where bookTitle = &#63; and author = &#63; or throws a {@link NoSuchBookException} if it could not be found.
	*
	* @param bookTitle the book title
	* @param author the author
	* @return the matching book
	* @throws NoSuchBookException if a matching book could not be found
	*/
	public static Book findByBookTitleAuthor(java.lang.String bookTitle,
		java.lang.String author)
		throws com.liferay.library.exception.NoSuchBookException {
		return getPersistence().findByBookTitleAuthor(bookTitle, author);
	}

	/**
	* Returns the book where bookTitle = &#63; and author = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param bookTitle the book title
	* @param author the author
	* @return the matching book, or <code>null</code> if a matching book could not be found
	*/
	public static Book fetchByBookTitleAuthor(java.lang.String bookTitle,
		java.lang.String author) {
		return getPersistence().fetchByBookTitleAuthor(bookTitle, author);
	}

	/**
	* Returns the book where bookTitle = &#63; and author = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param bookTitle the book title
	* @param author the author
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching book, or <code>null</code> if a matching book could not be found
	*/
	public static Book fetchByBookTitleAuthor(java.lang.String bookTitle,
		java.lang.String author, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByBookTitleAuthor(bookTitle, author, retrieveFromCache);
	}

	/**
	* Removes the book where bookTitle = &#63; and author = &#63; from the database.
	*
	* @param bookTitle the book title
	* @param author the author
	* @return the book that was removed
	*/
	public static Book removeByBookTitleAuthor(java.lang.String bookTitle,
		java.lang.String author)
		throws com.liferay.library.exception.NoSuchBookException {
		return getPersistence().removeByBookTitleAuthor(bookTitle, author);
	}

	/**
	* Returns the number of books where bookTitle = &#63; and author = &#63;.
	*
	* @param bookTitle the book title
	* @param author the author
	* @return the number of matching books
	*/
	public static int countByBookTitleAuthor(java.lang.String bookTitle,
		java.lang.String author) {
		return getPersistence().countByBookTitleAuthor(bookTitle, author);
	}

	/**
	* Returns all the books where author = &#63;.
	*
	* @param author the author
	* @return the matching books
	*/
	public static List<Book> findByAuthor(java.lang.String author) {
		return getPersistence().findByAuthor(author);
	}

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
	public static List<Book> findByAuthor(java.lang.String author, int start,
		int end) {
		return getPersistence().findByAuthor(author, start, end);
	}

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
	public static List<Book> findByAuthor(java.lang.String author, int start,
		int end, OrderByComparator<Book> orderByComparator) {
		return getPersistence()
				   .findByAuthor(author, start, end, orderByComparator);
	}

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
	public static List<Book> findByAuthor(java.lang.String author, int start,
		int end, OrderByComparator<Book> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByAuthor(author, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first book in the ordered set where author = &#63;.
	*
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching book
	* @throws NoSuchBookException if a matching book could not be found
	*/
	public static Book findByAuthor_First(java.lang.String author,
		OrderByComparator<Book> orderByComparator)
		throws com.liferay.library.exception.NoSuchBookException {
		return getPersistence().findByAuthor_First(author, orderByComparator);
	}

	/**
	* Returns the first book in the ordered set where author = &#63;.
	*
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching book, or <code>null</code> if a matching book could not be found
	*/
	public static Book fetchByAuthor_First(java.lang.String author,
		OrderByComparator<Book> orderByComparator) {
		return getPersistence().fetchByAuthor_First(author, orderByComparator);
	}

	/**
	* Returns the last book in the ordered set where author = &#63;.
	*
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching book
	* @throws NoSuchBookException if a matching book could not be found
	*/
	public static Book findByAuthor_Last(java.lang.String author,
		OrderByComparator<Book> orderByComparator)
		throws com.liferay.library.exception.NoSuchBookException {
		return getPersistence().findByAuthor_Last(author, orderByComparator);
	}

	/**
	* Returns the last book in the ordered set where author = &#63;.
	*
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching book, or <code>null</code> if a matching book could not be found
	*/
	public static Book fetchByAuthor_Last(java.lang.String author,
		OrderByComparator<Book> orderByComparator) {
		return getPersistence().fetchByAuthor_Last(author, orderByComparator);
	}

	/**
	* Returns the books before and after the current book in the ordered set where author = &#63;.
	*
	* @param bookId the primary key of the current book
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next book
	* @throws NoSuchBookException if a book with the primary key could not be found
	*/
	public static Book[] findByAuthor_PrevAndNext(long bookId,
		java.lang.String author, OrderByComparator<Book> orderByComparator)
		throws com.liferay.library.exception.NoSuchBookException {
		return getPersistence()
				   .findByAuthor_PrevAndNext(bookId, author, orderByComparator);
	}

	/**
	* Removes all the books where author = &#63; from the database.
	*
	* @param author the author
	*/
	public static void removeByAuthor(java.lang.String author) {
		getPersistence().removeByAuthor(author);
	}

	/**
	* Returns the number of books where author = &#63;.
	*
	* @param author the author
	* @return the number of matching books
	*/
	public static int countByAuthor(java.lang.String author) {
		return getPersistence().countByAuthor(author);
	}

	/**
	* Returns all the books where quantity = &#63;.
	*
	* @param quantity the quantity
	* @return the matching books
	*/
	public static List<Book> findByQuantity(int quantity) {
		return getPersistence().findByQuantity(quantity);
	}

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
	public static List<Book> findByQuantity(int quantity, int start, int end) {
		return getPersistence().findByQuantity(quantity, start, end);
	}

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
	public static List<Book> findByQuantity(int quantity, int start, int end,
		OrderByComparator<Book> orderByComparator) {
		return getPersistence()
				   .findByQuantity(quantity, start, end, orderByComparator);
	}

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
	public static List<Book> findByQuantity(int quantity, int start, int end,
		OrderByComparator<Book> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByQuantity(quantity, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first book in the ordered set where quantity = &#63;.
	*
	* @param quantity the quantity
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching book
	* @throws NoSuchBookException if a matching book could not be found
	*/
	public static Book findByQuantity_First(int quantity,
		OrderByComparator<Book> orderByComparator)
		throws com.liferay.library.exception.NoSuchBookException {
		return getPersistence().findByQuantity_First(quantity, orderByComparator);
	}

	/**
	* Returns the first book in the ordered set where quantity = &#63;.
	*
	* @param quantity the quantity
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching book, or <code>null</code> if a matching book could not be found
	*/
	public static Book fetchByQuantity_First(int quantity,
		OrderByComparator<Book> orderByComparator) {
		return getPersistence()
				   .fetchByQuantity_First(quantity, orderByComparator);
	}

	/**
	* Returns the last book in the ordered set where quantity = &#63;.
	*
	* @param quantity the quantity
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching book
	* @throws NoSuchBookException if a matching book could not be found
	*/
	public static Book findByQuantity_Last(int quantity,
		OrderByComparator<Book> orderByComparator)
		throws com.liferay.library.exception.NoSuchBookException {
		return getPersistence().findByQuantity_Last(quantity, orderByComparator);
	}

	/**
	* Returns the last book in the ordered set where quantity = &#63;.
	*
	* @param quantity the quantity
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching book, or <code>null</code> if a matching book could not be found
	*/
	public static Book fetchByQuantity_Last(int quantity,
		OrderByComparator<Book> orderByComparator) {
		return getPersistence().fetchByQuantity_Last(quantity, orderByComparator);
	}

	/**
	* Returns the books before and after the current book in the ordered set where quantity = &#63;.
	*
	* @param bookId the primary key of the current book
	* @param quantity the quantity
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next book
	* @throws NoSuchBookException if a book with the primary key could not be found
	*/
	public static Book[] findByQuantity_PrevAndNext(long bookId, int quantity,
		OrderByComparator<Book> orderByComparator)
		throws com.liferay.library.exception.NoSuchBookException {
		return getPersistence()
				   .findByQuantity_PrevAndNext(bookId, quantity,
			orderByComparator);
	}

	/**
	* Removes all the books where quantity = &#63; from the database.
	*
	* @param quantity the quantity
	*/
	public static void removeByQuantity(int quantity) {
		getPersistence().removeByQuantity(quantity);
	}

	/**
	* Returns the number of books where quantity = &#63;.
	*
	* @param quantity the quantity
	* @return the number of matching books
	*/
	public static int countByQuantity(int quantity) {
		return getPersistence().countByQuantity(quantity);
	}

	/**
	* Returns all the books where borrowed = &#63;.
	*
	* @param borrowed the borrowed
	* @return the matching books
	*/
	public static List<Book> findByBorrowed(int borrowed) {
		return getPersistence().findByBorrowed(borrowed);
	}

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
	public static List<Book> findByBorrowed(int borrowed, int start, int end) {
		return getPersistence().findByBorrowed(borrowed, start, end);
	}

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
	public static List<Book> findByBorrowed(int borrowed, int start, int end,
		OrderByComparator<Book> orderByComparator) {
		return getPersistence()
				   .findByBorrowed(borrowed, start, end, orderByComparator);
	}

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
	public static List<Book> findByBorrowed(int borrowed, int start, int end,
		OrderByComparator<Book> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByBorrowed(borrowed, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first book in the ordered set where borrowed = &#63;.
	*
	* @param borrowed the borrowed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching book
	* @throws NoSuchBookException if a matching book could not be found
	*/
	public static Book findByBorrowed_First(int borrowed,
		OrderByComparator<Book> orderByComparator)
		throws com.liferay.library.exception.NoSuchBookException {
		return getPersistence().findByBorrowed_First(borrowed, orderByComparator);
	}

	/**
	* Returns the first book in the ordered set where borrowed = &#63;.
	*
	* @param borrowed the borrowed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching book, or <code>null</code> if a matching book could not be found
	*/
	public static Book fetchByBorrowed_First(int borrowed,
		OrderByComparator<Book> orderByComparator) {
		return getPersistence()
				   .fetchByBorrowed_First(borrowed, orderByComparator);
	}

	/**
	* Returns the last book in the ordered set where borrowed = &#63;.
	*
	* @param borrowed the borrowed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching book
	* @throws NoSuchBookException if a matching book could not be found
	*/
	public static Book findByBorrowed_Last(int borrowed,
		OrderByComparator<Book> orderByComparator)
		throws com.liferay.library.exception.NoSuchBookException {
		return getPersistence().findByBorrowed_Last(borrowed, orderByComparator);
	}

	/**
	* Returns the last book in the ordered set where borrowed = &#63;.
	*
	* @param borrowed the borrowed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching book, or <code>null</code> if a matching book could not be found
	*/
	public static Book fetchByBorrowed_Last(int borrowed,
		OrderByComparator<Book> orderByComparator) {
		return getPersistence().fetchByBorrowed_Last(borrowed, orderByComparator);
	}

	/**
	* Returns the books before and after the current book in the ordered set where borrowed = &#63;.
	*
	* @param bookId the primary key of the current book
	* @param borrowed the borrowed
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next book
	* @throws NoSuchBookException if a book with the primary key could not be found
	*/
	public static Book[] findByBorrowed_PrevAndNext(long bookId, int borrowed,
		OrderByComparator<Book> orderByComparator)
		throws com.liferay.library.exception.NoSuchBookException {
		return getPersistence()
				   .findByBorrowed_PrevAndNext(bookId, borrowed,
			orderByComparator);
	}

	/**
	* Removes all the books where borrowed = &#63; from the database.
	*
	* @param borrowed the borrowed
	*/
	public static void removeByBorrowed(int borrowed) {
		getPersistence().removeByBorrowed(borrowed);
	}

	/**
	* Returns the number of books where borrowed = &#63;.
	*
	* @param borrowed the borrowed
	* @return the number of matching books
	*/
	public static int countByBorrowed(int borrowed) {
		return getPersistence().countByBorrowed(borrowed);
	}

	/**
	* Caches the book in the entity cache if it is enabled.
	*
	* @param book the book
	*/
	public static void cacheResult(Book book) {
		getPersistence().cacheResult(book);
	}

	/**
	* Caches the books in the entity cache if it is enabled.
	*
	* @param books the books
	*/
	public static void cacheResult(List<Book> books) {
		getPersistence().cacheResult(books);
	}

	/**
	* Creates a new book with the primary key. Does not add the book to the database.
	*
	* @param bookId the primary key for the new book
	* @return the new book
	*/
	public static Book create(long bookId) {
		return getPersistence().create(bookId);
	}

	/**
	* Removes the book with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookId the primary key of the book
	* @return the book that was removed
	* @throws NoSuchBookException if a book with the primary key could not be found
	*/
	public static Book remove(long bookId)
		throws com.liferay.library.exception.NoSuchBookException {
		return getPersistence().remove(bookId);
	}

	public static Book updateImpl(Book book) {
		return getPersistence().updateImpl(book);
	}

	/**
	* Returns the book with the primary key or throws a {@link NoSuchBookException} if it could not be found.
	*
	* @param bookId the primary key of the book
	* @return the book
	* @throws NoSuchBookException if a book with the primary key could not be found
	*/
	public static Book findByPrimaryKey(long bookId)
		throws com.liferay.library.exception.NoSuchBookException {
		return getPersistence().findByPrimaryKey(bookId);
	}

	/**
	* Returns the book with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bookId the primary key of the book
	* @return the book, or <code>null</code> if a book with the primary key could not be found
	*/
	public static Book fetchByPrimaryKey(long bookId) {
		return getPersistence().fetchByPrimaryKey(bookId);
	}

	public static java.util.Map<java.io.Serializable, Book> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the books.
	*
	* @return the books
	*/
	public static List<Book> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Book> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Book> findAll(int start, int end,
		OrderByComparator<Book> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Book> findAll(int start, int end,
		OrderByComparator<Book> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the books from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of books.
	*
	* @return the number of books
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static BookPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BookPersistence, BookPersistence> _serviceTracker =
		ServiceTrackerFactory.open(BookPersistence.class);
}