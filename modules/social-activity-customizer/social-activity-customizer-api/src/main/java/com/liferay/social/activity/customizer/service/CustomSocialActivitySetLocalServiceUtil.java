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

package com.liferay.social.activity.customizer.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for CustomSocialActivitySet. This utility wraps
 * <code>com.liferay.social.activity.customizer.service.impl.CustomSocialActivitySetLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CustomSocialActivitySetLocalService
 * @generated
 */
public class CustomSocialActivitySetLocalServiceUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.social.activity.customizer.service.impl.CustomSocialActivitySetLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the custom social activity set to the database. Also notifies the appropriate model listeners.
	 *
	 * @param customSocialActivitySet the custom social activity set
	 * @return the custom social activity set that was added
	 */
	public static
		com.liferay.social.activity.customizer.model.CustomSocialActivitySet
			addCustomSocialActivitySet(
				com.liferay.social.activity.customizer.model.
					CustomSocialActivitySet customSocialActivitySet) {

		return getService().addCustomSocialActivitySet(customSocialActivitySet);
	}

	/**
	 * Creates a new custom social activity set with the primary key. Does not add the custom social activity set to the database.
	 *
	 * @param id the primary key for the new custom social activity set
	 * @return the new custom social activity set
	 */
	public static
		com.liferay.social.activity.customizer.model.CustomSocialActivitySet
			createCustomSocialActivitySet(long id) {

		return getService().createCustomSocialActivitySet(id);
	}

	/**
	 * Deletes the custom social activity set from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customSocialActivitySet the custom social activity set
	 * @return the custom social activity set that was removed
	 */
	public static
		com.liferay.social.activity.customizer.model.CustomSocialActivitySet
			deleteCustomSocialActivitySet(
				com.liferay.social.activity.customizer.model.
					CustomSocialActivitySet customSocialActivitySet) {

		return getService().deleteCustomSocialActivitySet(
			customSocialActivitySet);
	}

	/**
	 * Deletes the custom social activity set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the custom social activity set
	 * @return the custom social activity set that was removed
	 * @throws PortalException if a custom social activity set with the primary key could not be found
	 */
	public static
		com.liferay.social.activity.customizer.model.CustomSocialActivitySet
				deleteCustomSocialActivitySet(long id)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCustomSocialActivitySet(id);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.social.activity.customizer.model.impl.CustomSocialActivitySetModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.social.activity.customizer.model.impl.CustomSocialActivitySetModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static
		com.liferay.social.activity.customizer.model.CustomSocialActivitySet
			fetchCustomSocialActivitySet(long id) {

		return getService().fetchCustomSocialActivitySet(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the custom social activity set with the primary key.
	 *
	 * @param id the primary key of the custom social activity set
	 * @return the custom social activity set
	 * @throws PortalException if a custom social activity set with the primary key could not be found
	 */
	public static
		com.liferay.social.activity.customizer.model.CustomSocialActivitySet
				getCustomSocialActivitySet(long id)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCustomSocialActivitySet(id);
	}

	/**
	 * Returns a range of all the custom social activity sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.social.activity.customizer.model.impl.CustomSocialActivitySetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom social activity sets
	 * @param end the upper bound of the range of custom social activity sets (not inclusive)
	 * @return the range of custom social activity sets
	 */
	public static java.util.List
		<com.liferay.social.activity.customizer.model.CustomSocialActivitySet>
			getCustomSocialActivitySets(int start, int end) {

		return getService().getCustomSocialActivitySets(start, end);
	}

	/**
	 * Returns the number of custom social activity sets.
	 *
	 * @return the number of custom social activity sets
	 */
	public static int getCustomSocialActivitySetsCount() {
		return getService().getCustomSocialActivitySetsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link CustomSocialActivitySetLocalServiceUtil} to access the custom social activity set local service.
	 */
	public static java.util.List
		<com.liferay.social.kernel.model.SocialActivitySet>
			getUserViewableActivitySets(
				long userId, long[] types, int start, int end) {

		return getService().getUserViewableActivitySets(
			userId, types, start, end);
	}

	public static int getUserViewableActivitySetsCount(
		long userId, long[] types) {

		return getService().getUserViewableActivitySetsCount(userId, types);
	}

	/**
	 * Updates the custom social activity set in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param customSocialActivitySet the custom social activity set
	 * @return the custom social activity set that was updated
	 */
	public static
		com.liferay.social.activity.customizer.model.CustomSocialActivitySet
			updateCustomSocialActivitySet(
				com.liferay.social.activity.customizer.model.
					CustomSocialActivitySet customSocialActivitySet) {

		return getService().updateCustomSocialActivitySet(
			customSocialActivitySet);
	}

	public static CustomSocialActivitySetLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CustomSocialActivitySetLocalService,
		 CustomSocialActivitySetLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CustomSocialActivitySetLocalService.class);

		ServiceTracker
			<CustomSocialActivitySetLocalService,
			 CustomSocialActivitySetLocalService> serviceTracker =
				new ServiceTracker
					<CustomSocialActivitySetLocalService,
					 CustomSocialActivitySetLocalService>(
						 bundle.getBundleContext(),
						 CustomSocialActivitySetLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}