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

package com.liferay.library.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.library.exception.NoSuchBookException;
import com.liferay.library.model.Book;
import com.liferay.library.model.impl.BookImpl;
import com.liferay.library.model.impl.BookModelImpl;
import com.liferay.library.service.persistence.BookPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the book service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookPersistence
 * @see com.liferay.library.service.persistence.BookUtil
 * @generated
 */
@ProviderType
public class BookPersistenceImpl extends BasePersistenceImpl<Book>
	implements BookPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BookUtil} to access the book persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BookImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			BookModelImpl.UUID_COLUMN_BITMASK |
			BookModelImpl.BOOKTITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the books where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching books
	 */
	@Override
	public List<Book> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Book> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Book> findByUuid(String uuid, int start, int end,
		OrderByComparator<Book> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Book> findByUuid(String uuid, int start, int end,
		OrderByComparator<Book> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Book> list = null;

		if (retrieveFromCache) {
			list = (List<Book>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Book book : list) {
					if (!Objects.equals(uuid, book.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_BOOK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BookModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Book>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Book>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first book in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	@Override
	public Book findByUuid_First(String uuid,
		OrderByComparator<Book> orderByComparator) throws NoSuchBookException {
		Book book = fetchByUuid_First(uuid, orderByComparator);

		if (book != null) {
			return book;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookException(msg.toString());
	}

	/**
	 * Returns the first book in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book, or <code>null</code> if a matching book could not be found
	 */
	@Override
	public Book fetchByUuid_First(String uuid,
		OrderByComparator<Book> orderByComparator) {
		List<Book> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last book in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	@Override
	public Book findByUuid_Last(String uuid,
		OrderByComparator<Book> orderByComparator) throws NoSuchBookException {
		Book book = fetchByUuid_Last(uuid, orderByComparator);

		if (book != null) {
			return book;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookException(msg.toString());
	}

	/**
	 * Returns the last book in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book, or <code>null</code> if a matching book could not be found
	 */
	@Override
	public Book fetchByUuid_Last(String uuid,
		OrderByComparator<Book> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Book> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Book[] findByUuid_PrevAndNext(long bookId, String uuid,
		OrderByComparator<Book> orderByComparator) throws NoSuchBookException {
		Book book = findByPrimaryKey(bookId);

		Session session = null;

		try {
			session = openSession();

			Book[] array = new BookImpl[3];

			array[0] = getByUuid_PrevAndNext(session, book, uuid,
					orderByComparator, true);

			array[1] = book;

			array[2] = getByUuid_PrevAndNext(session, book, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Book getByUuid_PrevAndNext(Session session, Book book,
		String uuid, OrderByComparator<Book> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOK_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(BookModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(book);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Book> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the books where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Book book : findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(book);
		}
	}

	/**
	 * Returns the number of books where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching books
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOOK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "book.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "book.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(book.uuid IS NULL OR book.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			BookModelImpl.UUID_COLUMN_BITMASK |
			BookModelImpl.COMPANYID_COLUMN_BITMASK |
			BookModelImpl.BOOKTITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the books where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching books
	 */
	@Override
	public List<Book> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Book> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Book> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Book> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Book> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Book> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Book> list = null;

		if (retrieveFromCache) {
			list = (List<Book>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Book book : list) {
					if (!Objects.equals(uuid, book.getUuid()) ||
							(companyId != book.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_BOOK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BookModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Book>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Book>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Book findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Book> orderByComparator) throws NoSuchBookException {
		Book book = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (book != null) {
			return book;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookException(msg.toString());
	}

	/**
	 * Returns the first book in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book, or <code>null</code> if a matching book could not be found
	 */
	@Override
	public Book fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Book> orderByComparator) {
		List<Book> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Book findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Book> orderByComparator) throws NoSuchBookException {
		Book book = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (book != null) {
			return book;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookException(msg.toString());
	}

	/**
	 * Returns the last book in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book, or <code>null</code> if a matching book could not be found
	 */
	@Override
	public Book fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Book> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Book> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Book[] findByUuid_C_PrevAndNext(long bookId, String uuid,
		long companyId, OrderByComparator<Book> orderByComparator)
		throws NoSuchBookException {
		Book book = findByPrimaryKey(bookId);

		Session session = null;

		try {
			session = openSession();

			Book[] array = new BookImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, book, uuid, companyId,
					orderByComparator, true);

			array[1] = book;

			array[2] = getByUuid_C_PrevAndNext(session, book, uuid, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Book getByUuid_C_PrevAndNext(Session session, Book book,
		String uuid, long companyId, OrderByComparator<Book> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_BOOK_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(BookModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(book);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Book> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the books where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Book book : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(book);
		}
	}

	/**
	 * Returns the number of books where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching books
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BOOK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "book.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "book.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(book.uuid IS NULL OR book.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "book.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_BOOKTITLE = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByBookTitle",
			new String[] { String.class.getName() },
			BookModelImpl.BOOKTITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BOOKTITLE = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBookTitle",
			new String[] { String.class.getName() });

	/**
	 * Returns the book where bookTitle = &#63; or throws a {@link NoSuchBookException} if it could not be found.
	 *
	 * @param bookTitle the book title
	 * @return the matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	@Override
	public Book findByBookTitle(String bookTitle) throws NoSuchBookException {
		Book book = fetchByBookTitle(bookTitle);

		if (book == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("bookTitle=");
			msg.append(bookTitle);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchBookException(msg.toString());
		}

		return book;
	}

	/**
	 * Returns the book where bookTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param bookTitle the book title
	 * @return the matching book, or <code>null</code> if a matching book could not be found
	 */
	@Override
	public Book fetchByBookTitle(String bookTitle) {
		return fetchByBookTitle(bookTitle, true);
	}

	/**
	 * Returns the book where bookTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param bookTitle the book title
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching book, or <code>null</code> if a matching book could not be found
	 */
	@Override
	public Book fetchByBookTitle(String bookTitle, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { bookTitle };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_BOOKTITLE,
					finderArgs, this);
		}

		if (result instanceof Book) {
			Book book = (Book)result;

			if (!Objects.equals(bookTitle, book.getBookTitle())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_BOOK_WHERE);

			boolean bindBookTitle = false;

			if (bookTitle == null) {
				query.append(_FINDER_COLUMN_BOOKTITLE_BOOKTITLE_1);
			}
			else if (bookTitle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKTITLE_BOOKTITLE_3);
			}
			else {
				bindBookTitle = true;

				query.append(_FINDER_COLUMN_BOOKTITLE_BOOKTITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBookTitle) {
					qPos.add(bookTitle);
				}

				List<Book> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_BOOKTITLE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BookPersistenceImpl.fetchByBookTitle(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Book book = list.get(0);

					result = book;

					cacheResult(book);

					if ((book.getBookTitle() == null) ||
							!book.getBookTitle().equals(bookTitle)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_BOOKTITLE,
							finderArgs, book);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_BOOKTITLE,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Book)result;
		}
	}

	/**
	 * Removes the book where bookTitle = &#63; from the database.
	 *
	 * @param bookTitle the book title
	 * @return the book that was removed
	 */
	@Override
	public Book removeByBookTitle(String bookTitle) throws NoSuchBookException {
		Book book = findByBookTitle(bookTitle);

		return remove(book);
	}

	/**
	 * Returns the number of books where bookTitle = &#63;.
	 *
	 * @param bookTitle the book title
	 * @return the number of matching books
	 */
	@Override
	public int countByBookTitle(String bookTitle) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BOOKTITLE;

		Object[] finderArgs = new Object[] { bookTitle };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOOK_WHERE);

			boolean bindBookTitle = false;

			if (bookTitle == null) {
				query.append(_FINDER_COLUMN_BOOKTITLE_BOOKTITLE_1);
			}
			else if (bookTitle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKTITLE_BOOKTITLE_3);
			}
			else {
				bindBookTitle = true;

				query.append(_FINDER_COLUMN_BOOKTITLE_BOOKTITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBookTitle) {
					qPos.add(bookTitle);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BOOKTITLE_BOOKTITLE_1 = "book.bookTitle IS NULL";
	private static final String _FINDER_COLUMN_BOOKTITLE_BOOKTITLE_2 = "book.bookTitle = ?";
	private static final String _FINDER_COLUMN_BOOKTITLE_BOOKTITLE_3 = "(book.bookTitle IS NULL OR book.bookTitle = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_BOOKTITLEAUTHOR = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByBookTitleAuthor",
			new String[] { String.class.getName(), String.class.getName() },
			BookModelImpl.BOOKTITLE_COLUMN_BITMASK |
			BookModelImpl.AUTHOR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BOOKTITLEAUTHOR = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBookTitleAuthor",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the book where bookTitle = &#63; and author = &#63; or throws a {@link NoSuchBookException} if it could not be found.
	 *
	 * @param bookTitle the book title
	 * @param author the author
	 * @return the matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	@Override
	public Book findByBookTitleAuthor(String bookTitle, String author)
		throws NoSuchBookException {
		Book book = fetchByBookTitleAuthor(bookTitle, author);

		if (book == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("bookTitle=");
			msg.append(bookTitle);

			msg.append(", author=");
			msg.append(author);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchBookException(msg.toString());
		}

		return book;
	}

	/**
	 * Returns the book where bookTitle = &#63; and author = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param bookTitle the book title
	 * @param author the author
	 * @return the matching book, or <code>null</code> if a matching book could not be found
	 */
	@Override
	public Book fetchByBookTitleAuthor(String bookTitle, String author) {
		return fetchByBookTitleAuthor(bookTitle, author, true);
	}

	/**
	 * Returns the book where bookTitle = &#63; and author = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param bookTitle the book title
	 * @param author the author
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching book, or <code>null</code> if a matching book could not be found
	 */
	@Override
	public Book fetchByBookTitleAuthor(String bookTitle, String author,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { bookTitle, author };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_BOOKTITLEAUTHOR,
					finderArgs, this);
		}

		if (result instanceof Book) {
			Book book = (Book)result;

			if (!Objects.equals(bookTitle, book.getBookTitle()) ||
					!Objects.equals(author, book.getAuthor())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_BOOK_WHERE);

			boolean bindBookTitle = false;

			if (bookTitle == null) {
				query.append(_FINDER_COLUMN_BOOKTITLEAUTHOR_BOOKTITLE_1);
			}
			else if (bookTitle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKTITLEAUTHOR_BOOKTITLE_3);
			}
			else {
				bindBookTitle = true;

				query.append(_FINDER_COLUMN_BOOKTITLEAUTHOR_BOOKTITLE_2);
			}

			boolean bindAuthor = false;

			if (author == null) {
				query.append(_FINDER_COLUMN_BOOKTITLEAUTHOR_AUTHOR_1);
			}
			else if (author.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKTITLEAUTHOR_AUTHOR_3);
			}
			else {
				bindAuthor = true;

				query.append(_FINDER_COLUMN_BOOKTITLEAUTHOR_AUTHOR_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBookTitle) {
					qPos.add(bookTitle);
				}

				if (bindAuthor) {
					qPos.add(author);
				}

				List<Book> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_BOOKTITLEAUTHOR,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BookPersistenceImpl.fetchByBookTitleAuthor(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Book book = list.get(0);

					result = book;

					cacheResult(book);

					if ((book.getBookTitle() == null) ||
							!book.getBookTitle().equals(bookTitle) ||
							(book.getAuthor() == null) ||
							!book.getAuthor().equals(author)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_BOOKTITLEAUTHOR,
							finderArgs, book);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_BOOKTITLEAUTHOR,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Book)result;
		}
	}

	/**
	 * Removes the book where bookTitle = &#63; and author = &#63; from the database.
	 *
	 * @param bookTitle the book title
	 * @param author the author
	 * @return the book that was removed
	 */
	@Override
	public Book removeByBookTitleAuthor(String bookTitle, String author)
		throws NoSuchBookException {
		Book book = findByBookTitleAuthor(bookTitle, author);

		return remove(book);
	}

	/**
	 * Returns the number of books where bookTitle = &#63; and author = &#63;.
	 *
	 * @param bookTitle the book title
	 * @param author the author
	 * @return the number of matching books
	 */
	@Override
	public int countByBookTitleAuthor(String bookTitle, String author) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BOOKTITLEAUTHOR;

		Object[] finderArgs = new Object[] { bookTitle, author };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BOOK_WHERE);

			boolean bindBookTitle = false;

			if (bookTitle == null) {
				query.append(_FINDER_COLUMN_BOOKTITLEAUTHOR_BOOKTITLE_1);
			}
			else if (bookTitle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKTITLEAUTHOR_BOOKTITLE_3);
			}
			else {
				bindBookTitle = true;

				query.append(_FINDER_COLUMN_BOOKTITLEAUTHOR_BOOKTITLE_2);
			}

			boolean bindAuthor = false;

			if (author == null) {
				query.append(_FINDER_COLUMN_BOOKTITLEAUTHOR_AUTHOR_1);
			}
			else if (author.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKTITLEAUTHOR_AUTHOR_3);
			}
			else {
				bindAuthor = true;

				query.append(_FINDER_COLUMN_BOOKTITLEAUTHOR_AUTHOR_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBookTitle) {
					qPos.add(bookTitle);
				}

				if (bindAuthor) {
					qPos.add(author);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BOOKTITLEAUTHOR_BOOKTITLE_1 = "book.bookTitle IS NULL AND ";
	private static final String _FINDER_COLUMN_BOOKTITLEAUTHOR_BOOKTITLE_2 = "book.bookTitle = ? AND ";
	private static final String _FINDER_COLUMN_BOOKTITLEAUTHOR_BOOKTITLE_3 = "(book.bookTitle IS NULL OR book.bookTitle = '') AND ";
	private static final String _FINDER_COLUMN_BOOKTITLEAUTHOR_AUTHOR_1 = "book.author IS NULL";
	private static final String _FINDER_COLUMN_BOOKTITLEAUTHOR_AUTHOR_2 = "book.author = ?";
	private static final String _FINDER_COLUMN_BOOKTITLEAUTHOR_AUTHOR_3 = "(book.author IS NULL OR book.author = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHOR = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAuthor",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHOR =
		new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAuthor",
			new String[] { String.class.getName() },
			BookModelImpl.AUTHOR_COLUMN_BITMASK |
			BookModelImpl.BOOKTITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AUTHOR = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAuthor",
			new String[] { String.class.getName() });

	/**
	 * Returns all the books where author = &#63;.
	 *
	 * @param author the author
	 * @return the matching books
	 */
	@Override
	public List<Book> findByAuthor(String author) {
		return findByAuthor(author, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Book> findByAuthor(String author, int start, int end) {
		return findByAuthor(author, start, end, null);
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
	@Override
	public List<Book> findByAuthor(String author, int start, int end,
		OrderByComparator<Book> orderByComparator) {
		return findByAuthor(author, start, end, orderByComparator, true);
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
	@Override
	public List<Book> findByAuthor(String author, int start, int end,
		OrderByComparator<Book> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHOR;
			finderArgs = new Object[] { author };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHOR;
			finderArgs = new Object[] { author, start, end, orderByComparator };
		}

		List<Book> list = null;

		if (retrieveFromCache) {
			list = (List<Book>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Book book : list) {
					if (!Objects.equals(author, book.getAuthor())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_BOOK_WHERE);

			boolean bindAuthor = false;

			if (author == null) {
				query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_1);
			}
			else if (author.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_3);
			}
			else {
				bindAuthor = true;

				query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BookModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAuthor) {
					qPos.add(author);
				}

				if (!pagination) {
					list = (List<Book>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Book>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first book in the ordered set where author = &#63;.
	 *
	 * @param author the author
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	@Override
	public Book findByAuthor_First(String author,
		OrderByComparator<Book> orderByComparator) throws NoSuchBookException {
		Book book = fetchByAuthor_First(author, orderByComparator);

		if (book != null) {
			return book;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("author=");
		msg.append(author);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookException(msg.toString());
	}

	/**
	 * Returns the first book in the ordered set where author = &#63;.
	 *
	 * @param author the author
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book, or <code>null</code> if a matching book could not be found
	 */
	@Override
	public Book fetchByAuthor_First(String author,
		OrderByComparator<Book> orderByComparator) {
		List<Book> list = findByAuthor(author, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last book in the ordered set where author = &#63;.
	 *
	 * @param author the author
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	@Override
	public Book findByAuthor_Last(String author,
		OrderByComparator<Book> orderByComparator) throws NoSuchBookException {
		Book book = fetchByAuthor_Last(author, orderByComparator);

		if (book != null) {
			return book;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("author=");
		msg.append(author);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookException(msg.toString());
	}

	/**
	 * Returns the last book in the ordered set where author = &#63;.
	 *
	 * @param author the author
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book, or <code>null</code> if a matching book could not be found
	 */
	@Override
	public Book fetchByAuthor_Last(String author,
		OrderByComparator<Book> orderByComparator) {
		int count = countByAuthor(author);

		if (count == 0) {
			return null;
		}

		List<Book> list = findByAuthor(author, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Book[] findByAuthor_PrevAndNext(long bookId, String author,
		OrderByComparator<Book> orderByComparator) throws NoSuchBookException {
		Book book = findByPrimaryKey(bookId);

		Session session = null;

		try {
			session = openSession();

			Book[] array = new BookImpl[3];

			array[0] = getByAuthor_PrevAndNext(session, book, author,
					orderByComparator, true);

			array[1] = book;

			array[2] = getByAuthor_PrevAndNext(session, book, author,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Book getByAuthor_PrevAndNext(Session session, Book book,
		String author, OrderByComparator<Book> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOK_WHERE);

		boolean bindAuthor = false;

		if (author == null) {
			query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_1);
		}
		else if (author.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_3);
		}
		else {
			bindAuthor = true;

			query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(BookModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAuthor) {
			qPos.add(author);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(book);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Book> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the books where author = &#63; from the database.
	 *
	 * @param author the author
	 */
	@Override
	public void removeByAuthor(String author) {
		for (Book book : findByAuthor(author, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(book);
		}
	}

	/**
	 * Returns the number of books where author = &#63;.
	 *
	 * @param author the author
	 * @return the number of matching books
	 */
	@Override
	public int countByAuthor(String author) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AUTHOR;

		Object[] finderArgs = new Object[] { author };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOOK_WHERE);

			boolean bindAuthor = false;

			if (author == null) {
				query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_1);
			}
			else if (author.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_3);
			}
			else {
				bindAuthor = true;

				query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAuthor) {
					qPos.add(author);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_AUTHOR_AUTHOR_1 = "book.author IS NULL";
	private static final String _FINDER_COLUMN_AUTHOR_AUTHOR_2 = "book.author = ?";
	private static final String _FINDER_COLUMN_AUTHOR_AUTHOR_3 = "(book.author IS NULL OR book.author = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_QUANTITY = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByQuantity",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUANTITY =
		new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQuantity",
			new String[] { Integer.class.getName() },
			BookModelImpl.QUANTITY_COLUMN_BITMASK |
			BookModelImpl.BOOKTITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_QUANTITY = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQuantity",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the books where quantity = &#63;.
	 *
	 * @param quantity the quantity
	 * @return the matching books
	 */
	@Override
	public List<Book> findByQuantity(int quantity) {
		return findByQuantity(quantity, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Book> findByQuantity(int quantity, int start, int end) {
		return findByQuantity(quantity, start, end, null);
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
	@Override
	public List<Book> findByQuantity(int quantity, int start, int end,
		OrderByComparator<Book> orderByComparator) {
		return findByQuantity(quantity, start, end, orderByComparator, true);
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
	@Override
	public List<Book> findByQuantity(int quantity, int start, int end,
		OrderByComparator<Book> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUANTITY;
			finderArgs = new Object[] { quantity };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_QUANTITY;
			finderArgs = new Object[] { quantity, start, end, orderByComparator };
		}

		List<Book> list = null;

		if (retrieveFromCache) {
			list = (List<Book>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Book book : list) {
					if ((quantity != book.getQuantity())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_BOOK_WHERE);

			query.append(_FINDER_COLUMN_QUANTITY_QUANTITY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BookModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(quantity);

				if (!pagination) {
					list = (List<Book>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Book>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first book in the ordered set where quantity = &#63;.
	 *
	 * @param quantity the quantity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	@Override
	public Book findByQuantity_First(int quantity,
		OrderByComparator<Book> orderByComparator) throws NoSuchBookException {
		Book book = fetchByQuantity_First(quantity, orderByComparator);

		if (book != null) {
			return book;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("quantity=");
		msg.append(quantity);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookException(msg.toString());
	}

	/**
	 * Returns the first book in the ordered set where quantity = &#63;.
	 *
	 * @param quantity the quantity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book, or <code>null</code> if a matching book could not be found
	 */
	@Override
	public Book fetchByQuantity_First(int quantity,
		OrderByComparator<Book> orderByComparator) {
		List<Book> list = findByQuantity(quantity, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last book in the ordered set where quantity = &#63;.
	 *
	 * @param quantity the quantity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	@Override
	public Book findByQuantity_Last(int quantity,
		OrderByComparator<Book> orderByComparator) throws NoSuchBookException {
		Book book = fetchByQuantity_Last(quantity, orderByComparator);

		if (book != null) {
			return book;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("quantity=");
		msg.append(quantity);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookException(msg.toString());
	}

	/**
	 * Returns the last book in the ordered set where quantity = &#63;.
	 *
	 * @param quantity the quantity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book, or <code>null</code> if a matching book could not be found
	 */
	@Override
	public Book fetchByQuantity_Last(int quantity,
		OrderByComparator<Book> orderByComparator) {
		int count = countByQuantity(quantity);

		if (count == 0) {
			return null;
		}

		List<Book> list = findByQuantity(quantity, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Book[] findByQuantity_PrevAndNext(long bookId, int quantity,
		OrderByComparator<Book> orderByComparator) throws NoSuchBookException {
		Book book = findByPrimaryKey(bookId);

		Session session = null;

		try {
			session = openSession();

			Book[] array = new BookImpl[3];

			array[0] = getByQuantity_PrevAndNext(session, book, quantity,
					orderByComparator, true);

			array[1] = book;

			array[2] = getByQuantity_PrevAndNext(session, book, quantity,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Book getByQuantity_PrevAndNext(Session session, Book book,
		int quantity, OrderByComparator<Book> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOK_WHERE);

		query.append(_FINDER_COLUMN_QUANTITY_QUANTITY_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(BookModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(quantity);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(book);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Book> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the books where quantity = &#63; from the database.
	 *
	 * @param quantity the quantity
	 */
	@Override
	public void removeByQuantity(int quantity) {
		for (Book book : findByQuantity(quantity, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(book);
		}
	}

	/**
	 * Returns the number of books where quantity = &#63;.
	 *
	 * @param quantity the quantity
	 * @return the number of matching books
	 */
	@Override
	public int countByQuantity(int quantity) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_QUANTITY;

		Object[] finderArgs = new Object[] { quantity };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOOK_WHERE);

			query.append(_FINDER_COLUMN_QUANTITY_QUANTITY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(quantity);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_QUANTITY_QUANTITY_2 = "book.quantity = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BORROWED = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBorrowed",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BORROWED =
		new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBorrowed",
			new String[] { Integer.class.getName() },
			BookModelImpl.BORROWED_COLUMN_BITMASK |
			BookModelImpl.BOOKTITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BORROWED = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBorrowed",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the books where borrowed = &#63;.
	 *
	 * @param borrowed the borrowed
	 * @return the matching books
	 */
	@Override
	public List<Book> findByBorrowed(int borrowed) {
		return findByBorrowed(borrowed, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Book> findByBorrowed(int borrowed, int start, int end) {
		return findByBorrowed(borrowed, start, end, null);
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
	@Override
	public List<Book> findByBorrowed(int borrowed, int start, int end,
		OrderByComparator<Book> orderByComparator) {
		return findByBorrowed(borrowed, start, end, orderByComparator, true);
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
	@Override
	public List<Book> findByBorrowed(int borrowed, int start, int end,
		OrderByComparator<Book> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BORROWED;
			finderArgs = new Object[] { borrowed };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BORROWED;
			finderArgs = new Object[] { borrowed, start, end, orderByComparator };
		}

		List<Book> list = null;

		if (retrieveFromCache) {
			list = (List<Book>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Book book : list) {
					if ((borrowed != book.getBorrowed())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_BOOK_WHERE);

			query.append(_FINDER_COLUMN_BORROWED_BORROWED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BookModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(borrowed);

				if (!pagination) {
					list = (List<Book>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Book>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first book in the ordered set where borrowed = &#63;.
	 *
	 * @param borrowed the borrowed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	@Override
	public Book findByBorrowed_First(int borrowed,
		OrderByComparator<Book> orderByComparator) throws NoSuchBookException {
		Book book = fetchByBorrowed_First(borrowed, orderByComparator);

		if (book != null) {
			return book;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("borrowed=");
		msg.append(borrowed);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookException(msg.toString());
	}

	/**
	 * Returns the first book in the ordered set where borrowed = &#63;.
	 *
	 * @param borrowed the borrowed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book, or <code>null</code> if a matching book could not be found
	 */
	@Override
	public Book fetchByBorrowed_First(int borrowed,
		OrderByComparator<Book> orderByComparator) {
		List<Book> list = findByBorrowed(borrowed, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last book in the ordered set where borrowed = &#63;.
	 *
	 * @param borrowed the borrowed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	@Override
	public Book findByBorrowed_Last(int borrowed,
		OrderByComparator<Book> orderByComparator) throws NoSuchBookException {
		Book book = fetchByBorrowed_Last(borrowed, orderByComparator);

		if (book != null) {
			return book;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("borrowed=");
		msg.append(borrowed);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBookException(msg.toString());
	}

	/**
	 * Returns the last book in the ordered set where borrowed = &#63;.
	 *
	 * @param borrowed the borrowed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book, or <code>null</code> if a matching book could not be found
	 */
	@Override
	public Book fetchByBorrowed_Last(int borrowed,
		OrderByComparator<Book> orderByComparator) {
		int count = countByBorrowed(borrowed);

		if (count == 0) {
			return null;
		}

		List<Book> list = findByBorrowed(borrowed, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Book[] findByBorrowed_PrevAndNext(long bookId, int borrowed,
		OrderByComparator<Book> orderByComparator) throws NoSuchBookException {
		Book book = findByPrimaryKey(bookId);

		Session session = null;

		try {
			session = openSession();

			Book[] array = new BookImpl[3];

			array[0] = getByBorrowed_PrevAndNext(session, book, borrowed,
					orderByComparator, true);

			array[1] = book;

			array[2] = getByBorrowed_PrevAndNext(session, book, borrowed,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Book getByBorrowed_PrevAndNext(Session session, Book book,
		int borrowed, OrderByComparator<Book> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOK_WHERE);

		query.append(_FINDER_COLUMN_BORROWED_BORROWED_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(BookModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(borrowed);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(book);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Book> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the books where borrowed = &#63; from the database.
	 *
	 * @param borrowed the borrowed
	 */
	@Override
	public void removeByBorrowed(int borrowed) {
		for (Book book : findByBorrowed(borrowed, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(book);
		}
	}

	/**
	 * Returns the number of books where borrowed = &#63;.
	 *
	 * @param borrowed the borrowed
	 * @return the number of matching books
	 */
	@Override
	public int countByBorrowed(int borrowed) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BORROWED;

		Object[] finderArgs = new Object[] { borrowed };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOOK_WHERE);

			query.append(_FINDER_COLUMN_BORROWED_BORROWED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(borrowed);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BORROWED_BORROWED_2 = "book.borrowed = ?";

	public BookPersistenceImpl() {
		setModelClass(Book.class);
	}

	/**
	 * Caches the book in the entity cache if it is enabled.
	 *
	 * @param book the book
	 */
	@Override
	public void cacheResult(Book book) {
		entityCache.putResult(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookImpl.class, book.getPrimaryKey(), book);

		finderCache.putResult(FINDER_PATH_FETCH_BY_BOOKTITLE,
			new Object[] { book.getBookTitle() }, book);

		finderCache.putResult(FINDER_PATH_FETCH_BY_BOOKTITLEAUTHOR,
			new Object[] { book.getBookTitle(), book.getAuthor() }, book);

		book.resetOriginalValues();
	}

	/**
	 * Caches the books in the entity cache if it is enabled.
	 *
	 * @param books the books
	 */
	@Override
	public void cacheResult(List<Book> books) {
		for (Book book : books) {
			if (entityCache.getResult(BookModelImpl.ENTITY_CACHE_ENABLED,
						BookImpl.class, book.getPrimaryKey()) == null) {
				cacheResult(book);
			}
			else {
				book.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all books.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BookImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the book.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Book book) {
		entityCache.removeResult(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookImpl.class, book.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((BookModelImpl)book);
	}

	@Override
	public void clearCache(List<Book> books) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Book book : books) {
			entityCache.removeResult(BookModelImpl.ENTITY_CACHE_ENABLED,
				BookImpl.class, book.getPrimaryKey());

			clearUniqueFindersCache((BookModelImpl)book);
		}
	}

	protected void cacheUniqueFindersCache(BookModelImpl bookModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] { bookModelImpl.getBookTitle() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_BOOKTITLE, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_BOOKTITLE, args,
				bookModelImpl);

			args = new Object[] {
					bookModelImpl.getBookTitle(), bookModelImpl.getAuthor()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_BOOKTITLEAUTHOR, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_BOOKTITLEAUTHOR, args,
				bookModelImpl);
		}
		else {
			if ((bookModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_BOOKTITLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { bookModelImpl.getBookTitle() };

				finderCache.putResult(FINDER_PATH_COUNT_BY_BOOKTITLE, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_BOOKTITLE, args,
					bookModelImpl);
			}

			if ((bookModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_BOOKTITLEAUTHOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bookModelImpl.getBookTitle(), bookModelImpl.getAuthor()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_BOOKTITLEAUTHOR,
					args, Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_BOOKTITLEAUTHOR,
					args, bookModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(BookModelImpl bookModelImpl) {
		Object[] args = new Object[] { bookModelImpl.getBookTitle() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_BOOKTITLE, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_BOOKTITLE, args);

		if ((bookModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_BOOKTITLE.getColumnBitmask()) != 0) {
			args = new Object[] { bookModelImpl.getOriginalBookTitle() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_BOOKTITLE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_BOOKTITLE, args);
		}

		args = new Object[] {
				bookModelImpl.getBookTitle(), bookModelImpl.getAuthor()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_BOOKTITLEAUTHOR, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_BOOKTITLEAUTHOR, args);

		if ((bookModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_BOOKTITLEAUTHOR.getColumnBitmask()) != 0) {
			args = new Object[] {
					bookModelImpl.getOriginalBookTitle(),
					bookModelImpl.getOriginalAuthor()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_BOOKTITLEAUTHOR, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_BOOKTITLEAUTHOR, args);
		}
	}

	/**
	 * Creates a new book with the primary key. Does not add the book to the database.
	 *
	 * @param bookId the primary key for the new book
	 * @return the new book
	 */
	@Override
	public Book create(long bookId) {
		Book book = new BookImpl();

		book.setNew(true);
		book.setPrimaryKey(bookId);

		String uuid = PortalUUIDUtil.generate();

		book.setUuid(uuid);

		book.setCompanyId(companyProvider.getCompanyId());

		return book;
	}

	/**
	 * Removes the book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookId the primary key of the book
	 * @return the book that was removed
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	@Override
	public Book remove(long bookId) throws NoSuchBookException {
		return remove((Serializable)bookId);
	}

	/**
	 * Removes the book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the book
	 * @return the book that was removed
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	@Override
	public Book remove(Serializable primaryKey) throws NoSuchBookException {
		Session session = null;

		try {
			session = openSession();

			Book book = (Book)session.get(BookImpl.class, primaryKey);

			if (book == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBookException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(book);
		}
		catch (NoSuchBookException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Book removeImpl(Book book) {
		book = toUnwrappedModel(book);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(book)) {
				book = (Book)session.get(BookImpl.class, book.getPrimaryKeyObj());
			}

			if (book != null) {
				session.delete(book);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (book != null) {
			clearCache(book);
		}

		return book;
	}

	@Override
	public Book updateImpl(Book book) {
		book = toUnwrappedModel(book);

		boolean isNew = book.isNew();

		BookModelImpl bookModelImpl = (BookModelImpl)book;

		if (Validator.isNull(book.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			book.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (book.getCreateDate() == null)) {
			if (serviceContext == null) {
				book.setCreateDate(now);
			}
			else {
				book.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!bookModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				book.setModifiedDate(now);
			}
			else {
				book.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (book.isNew()) {
				session.save(book);

				book.setNew(false);
			}
			else {
				book = (Book)session.merge(book);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BookModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((bookModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { bookModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { bookModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((bookModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bookModelImpl.getOriginalUuid(),
						bookModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						bookModelImpl.getUuid(), bookModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((bookModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { bookModelImpl.getOriginalAuthor() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_AUTHOR, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHOR,
					args);

				args = new Object[] { bookModelImpl.getAuthor() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_AUTHOR, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHOR,
					args);
			}

			if ((bookModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUANTITY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { bookModelImpl.getOriginalQuantity() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_QUANTITY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUANTITY,
					args);

				args = new Object[] { bookModelImpl.getQuantity() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_QUANTITY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUANTITY,
					args);
			}

			if ((bookModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BORROWED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { bookModelImpl.getOriginalBorrowed() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BORROWED, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BORROWED,
					args);

				args = new Object[] { bookModelImpl.getBorrowed() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BORROWED, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BORROWED,
					args);
			}
		}

		entityCache.putResult(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookImpl.class, book.getPrimaryKey(), book, false);

		clearUniqueFindersCache(bookModelImpl);
		cacheUniqueFindersCache(bookModelImpl, isNew);

		book.resetOriginalValues();

		return book;
	}

	protected Book toUnwrappedModel(Book book) {
		if (book instanceof BookImpl) {
			return book;
		}

		BookImpl bookImpl = new BookImpl();

		bookImpl.setNew(book.isNew());
		bookImpl.setPrimaryKey(book.getPrimaryKey());

		bookImpl.setUuid(book.getUuid());
		bookImpl.setBookId(book.getBookId());
		bookImpl.setCompanyId(book.getCompanyId());
		bookImpl.setUserId(book.getUserId());
		bookImpl.setUserName(book.getUserName());
		bookImpl.setCreateDate(book.getCreateDate());
		bookImpl.setModifiedDate(book.getModifiedDate());
		bookImpl.setBookTitle(book.getBookTitle());
		bookImpl.setAuthor(book.getAuthor());
		bookImpl.setQuantity(book.getQuantity());
		bookImpl.setBorrowed(book.getBorrowed());

		return bookImpl;
	}

	/**
	 * Returns the book with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the book
	 * @return the book
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	@Override
	public Book findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBookException {
		Book book = fetchByPrimaryKey(primaryKey);

		if (book == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBookException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return book;
	}

	/**
	 * Returns the book with the primary key or throws a {@link NoSuchBookException} if it could not be found.
	 *
	 * @param bookId the primary key of the book
	 * @return the book
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	@Override
	public Book findByPrimaryKey(long bookId) throws NoSuchBookException {
		return findByPrimaryKey((Serializable)bookId);
	}

	/**
	 * Returns the book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the book
	 * @return the book, or <code>null</code> if a book with the primary key could not be found
	 */
	@Override
	public Book fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(BookModelImpl.ENTITY_CACHE_ENABLED,
				BookImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Book book = (Book)serializable;

		if (book == null) {
			Session session = null;

			try {
				session = openSession();

				book = (Book)session.get(BookImpl.class, primaryKey);

				if (book != null) {
					cacheResult(book);
				}
				else {
					entityCache.putResult(BookModelImpl.ENTITY_CACHE_ENABLED,
						BookImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(BookModelImpl.ENTITY_CACHE_ENABLED,
					BookImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return book;
	}

	/**
	 * Returns the book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookId the primary key of the book
	 * @return the book, or <code>null</code> if a book with the primary key could not be found
	 */
	@Override
	public Book fetchByPrimaryKey(long bookId) {
		return fetchByPrimaryKey((Serializable)bookId);
	}

	@Override
	public Map<Serializable, Book> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Book> map = new HashMap<Serializable, Book>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Book book = fetchByPrimaryKey(primaryKey);

			if (book != null) {
				map.put(primaryKey, book);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(BookModelImpl.ENTITY_CACHE_ENABLED,
					BookImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Book)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_BOOK_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Book book : (List<Book>)q.list()) {
				map.put(book.getPrimaryKeyObj(), book);

				cacheResult(book);

				uncachedPrimaryKeys.remove(book.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(BookModelImpl.ENTITY_CACHE_ENABLED,
					BookImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the books.
	 *
	 * @return the books
	 */
	@Override
	public List<Book> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Book> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Book> findAll(int start, int end,
		OrderByComparator<Book> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Book> findAll(int start, int end,
		OrderByComparator<Book> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Book> list = null;

		if (retrieveFromCache) {
			list = (List<Book>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_BOOK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BOOK;

				if (pagination) {
					sql = sql.concat(BookModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Book>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Book>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the books from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Book book : findAll()) {
			remove(book);
		}
	}

	/**
	 * Returns the number of books.
	 *
	 * @return the number of books
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BOOK);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BookModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the book persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(BookImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_BOOK = "SELECT book FROM Book book";
	private static final String _SQL_SELECT_BOOK_WHERE_PKS_IN = "SELECT book FROM Book book WHERE bookId IN (";
	private static final String _SQL_SELECT_BOOK_WHERE = "SELECT book FROM Book book WHERE ";
	private static final String _SQL_COUNT_BOOK = "SELECT COUNT(book) FROM Book book";
	private static final String _SQL_COUNT_BOOK_WHERE = "SELECT COUNT(book) FROM Book book WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "book.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Book exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Book exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(BookPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}