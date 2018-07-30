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

package com.liferay.recommend.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.liferay.recommend.model.RecommendEntity;
import com.liferay.recommend.model.RecommendEntityModel;
import com.liferay.recommend.model.RecommendEntitySoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the RecommendEntity service. Represents a row in the &quot;rec_RecommendEntity&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link RecommendEntityModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RecommendEntityImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RecommendEntityImpl
 * @see RecommendEntity
 * @see RecommendEntityModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class RecommendEntityModelImpl extends BaseModelImpl<RecommendEntity>
	implements RecommendEntityModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a recommend entity model instance should use the {@link RecommendEntity} interface instead.
	 */
	public static final String TABLE_NAME = "rec_RecommendEntity";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table rec_RecommendEntity (id_ LONG not null primary key)";
	public static final String TABLE_SQL_DROP = "drop table rec_RecommendEntity";
	public static final String ORDER_BY_JPQL = " ORDER BY recommendEntity.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY rec_RecommendEntity.id_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.recommend.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.recommend.model.RecommendEntity"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.recommend.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.recommend.model.RecommendEntity"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static RecommendEntity toModel(RecommendEntitySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		RecommendEntity model = new RecommendEntityImpl();

		model.setId(soapModel.getId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<RecommendEntity> toModels(
		RecommendEntitySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<RecommendEntity> models = new ArrayList<RecommendEntity>(soapModels.length);

		for (RecommendEntitySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.recommend.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.recommend.model.RecommendEntity"));

	public RecommendEntityModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return RecommendEntity.class;
	}

	@Override
	public String getModelClassName() {
		return RecommendEntity.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}
	}

	@JSON
	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			RecommendEntity.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public RecommendEntity toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (RecommendEntity)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RecommendEntityImpl recommendEntityImpl = new RecommendEntityImpl();

		recommendEntityImpl.setId(getId());

		recommendEntityImpl.resetOriginalValues();

		return recommendEntityImpl;
	}

	@Override
	public int compareTo(RecommendEntity recommendEntity) {
		long primaryKey = recommendEntity.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RecommendEntity)) {
			return false;
		}

		RecommendEntity recommendEntity = (RecommendEntity)obj;

		long primaryKey = recommendEntity.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<RecommendEntity> toCacheModel() {
		RecommendEntityCacheModel recommendEntityCacheModel = new RecommendEntityCacheModel();

		recommendEntityCacheModel.id = getId();

		return recommendEntityCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{id=");
		sb.append(getId());

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(7);

		sb.append("<model><model-name>");
		sb.append("com.liferay.recommend.model.RecommendEntity");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = RecommendEntity.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			RecommendEntity.class
		};
	private long _id;
	private RecommendEntity _escapedModel;
}