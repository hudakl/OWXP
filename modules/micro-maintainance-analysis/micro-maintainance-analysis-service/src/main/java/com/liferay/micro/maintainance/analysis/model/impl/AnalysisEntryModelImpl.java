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

package com.liferay.micro.maintainance.analysis.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;
import com.liferay.micro.maintainance.analysis.model.AnalysisEntryModel;
import com.liferay.micro.maintainance.analysis.model.AnalysisEntrySoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the AnalysisEntry service. Represents a row in the &quot;Analysis_AnalysisEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link AnalysisEntryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AnalysisEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnalysisEntryImpl
 * @see AnalysisEntry
 * @see AnalysisEntryModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class AnalysisEntryModelImpl extends BaseModelImpl<AnalysisEntry>
	implements AnalysisEntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a analysis entry model instance should use the {@link AnalysisEntry} interface instead.
	 */
	public static final String TABLE_NAME = "Analysis_AnalysisEntry";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "analysisId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "canMainId", Types.BIGINT },
			{ "analysisData", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("analysisId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("canMainId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("analysisData", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table Analysis_AnalysisEntry (uuid_ VARCHAR(75) null,analysisId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,canMainId LONG,analysisData VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table Analysis_AnalysisEntry";
	public static final String ORDER_BY_JPQL = " ORDER BY analysisEntry.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Analysis_AnalysisEntry.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.micro.maintainance.analysis.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.micro.maintainance.analysis.model.AnalysisEntry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.micro.maintainance.analysis.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.micro.maintainance.analysis.model.AnalysisEntry"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.micro.maintainance.analysis.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.micro.maintainance.analysis.model.AnalysisEntry"),
			true);
	public static final long ANALYSISID_COLUMN_BITMASK = 1L;
	public static final long CANMAINID_COLUMN_BITMASK = 2L;
	public static final long COMPANYID_COLUMN_BITMASK = 4L;
	public static final long CREATEDATE_COLUMN_BITMASK = 8L;
	public static final long USERID_COLUMN_BITMASK = 16L;
	public static final long UUID_COLUMN_BITMASK = 32L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static AnalysisEntry toModel(AnalysisEntrySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		AnalysisEntry model = new AnalysisEntryImpl();

		model.setUuid(soapModel.getUuid());
		model.setAnalysisId(soapModel.getAnalysisId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCanMainId(soapModel.getCanMainId());
		model.setAnalysisData(soapModel.getAnalysisData());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<AnalysisEntry> toModels(AnalysisEntrySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<AnalysisEntry> models = new ArrayList<AnalysisEntry>(soapModels.length);

		for (AnalysisEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.micro.maintainance.analysis.service.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.micro.maintainance.analysis.model.AnalysisEntry"));

	public AnalysisEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _analysisId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAnalysisId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _analysisId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AnalysisEntry.class;
	}

	@Override
	public String getModelClassName() {
		return AnalysisEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("analysisId", getAnalysisId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("canMainId", getCanMainId());
		attributes.put("analysisData", getAnalysisData());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long analysisId = (Long)attributes.get("analysisId");

		if (analysisId != null) {
			setAnalysisId(analysisId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long canMainId = (Long)attributes.get("canMainId");

		if (canMainId != null) {
			setCanMainId(canMainId);
		}

		String analysisData = (String)attributes.get("analysisData");

		if (analysisData != null) {
			setAnalysisData(analysisData);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getAnalysisId() {
		return _analysisId;
	}

	@Override
	public void setAnalysisId(long analysisId) {
		_columnBitmask |= ANALYSISID_COLUMN_BITMASK;

		if (!_setOriginalAnalysisId) {
			_setOriginalAnalysisId = true;

			_originalAnalysisId = _analysisId;
		}

		_analysisId = analysisId;
	}

	public long getOriginalAnalysisId() {
		return _originalAnalysisId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		if (_originalCreateDate == null) {
			_originalCreateDate = _createDate;
		}

		_createDate = createDate;
	}

	public Date getOriginalCreateDate() {
		return _originalCreateDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getCanMainId() {
		return _canMainId;
	}

	@Override
	public void setCanMainId(long canMainId) {
		_columnBitmask |= CANMAINID_COLUMN_BITMASK;

		if (!_setOriginalCanMainId) {
			_setOriginalCanMainId = true;

			_originalCanMainId = _canMainId;
		}

		_canMainId = canMainId;
	}

	public long getOriginalCanMainId() {
		return _originalCanMainId;
	}

	@JSON
	@Override
	public String getAnalysisData() {
		if (_analysisData == null) {
			return StringPool.BLANK;
		}
		else {
			return _analysisData;
		}
	}

	@Override
	public void setAnalysisData(String analysisData) {
		_analysisData = analysisData;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				AnalysisEntry.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			AnalysisEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AnalysisEntry toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (AnalysisEntry)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AnalysisEntryImpl analysisEntryImpl = new AnalysisEntryImpl();

		analysisEntryImpl.setUuid(getUuid());
		analysisEntryImpl.setAnalysisId(getAnalysisId());
		analysisEntryImpl.setCompanyId(getCompanyId());
		analysisEntryImpl.setUserId(getUserId());
		analysisEntryImpl.setUserName(getUserName());
		analysisEntryImpl.setCreateDate(getCreateDate());
		analysisEntryImpl.setModifiedDate(getModifiedDate());
		analysisEntryImpl.setCanMainId(getCanMainId());
		analysisEntryImpl.setAnalysisData(getAnalysisData());

		analysisEntryImpl.resetOriginalValues();

		return analysisEntryImpl;
	}

	@Override
	public int compareTo(AnalysisEntry analysisEntry) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				analysisEntry.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnalysisEntry)) {
			return false;
		}

		AnalysisEntry analysisEntry = (AnalysisEntry)obj;

		long primaryKey = analysisEntry.getPrimaryKey();

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
		AnalysisEntryModelImpl analysisEntryModelImpl = this;

		analysisEntryModelImpl._originalUuid = analysisEntryModelImpl._uuid;

		analysisEntryModelImpl._originalAnalysisId = analysisEntryModelImpl._analysisId;

		analysisEntryModelImpl._setOriginalAnalysisId = false;

		analysisEntryModelImpl._originalCompanyId = analysisEntryModelImpl._companyId;

		analysisEntryModelImpl._setOriginalCompanyId = false;

		analysisEntryModelImpl._originalUserId = analysisEntryModelImpl._userId;

		analysisEntryModelImpl._setOriginalUserId = false;

		analysisEntryModelImpl._originalCreateDate = analysisEntryModelImpl._createDate;

		analysisEntryModelImpl._setModifiedDate = false;

		analysisEntryModelImpl._originalCanMainId = analysisEntryModelImpl._canMainId;

		analysisEntryModelImpl._setOriginalCanMainId = false;

		analysisEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AnalysisEntry> toCacheModel() {
		AnalysisEntryCacheModel analysisEntryCacheModel = new AnalysisEntryCacheModel();

		analysisEntryCacheModel.uuid = getUuid();

		String uuid = analysisEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			analysisEntryCacheModel.uuid = null;
		}

		analysisEntryCacheModel.analysisId = getAnalysisId();

		analysisEntryCacheModel.companyId = getCompanyId();

		analysisEntryCacheModel.userId = getUserId();

		analysisEntryCacheModel.userName = getUserName();

		String userName = analysisEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			analysisEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			analysisEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			analysisEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			analysisEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			analysisEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		analysisEntryCacheModel.canMainId = getCanMainId();

		analysisEntryCacheModel.analysisData = getAnalysisData();

		String analysisData = analysisEntryCacheModel.analysisData;

		if ((analysisData != null) && (analysisData.length() == 0)) {
			analysisEntryCacheModel.analysisData = null;
		}

		return analysisEntryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", analysisId=");
		sb.append(getAnalysisId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", canMainId=");
		sb.append(getCanMainId());
		sb.append(", analysisData=");
		sb.append(getAnalysisData());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.liferay.micro.maintainance.analysis.model.AnalysisEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>analysisId</column-name><column-value><![CDATA[");
		sb.append(getAnalysisId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>canMainId</column-name><column-value><![CDATA[");
		sb.append(getCanMainId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>analysisData</column-name><column-value><![CDATA[");
		sb.append(getAnalysisData());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = AnalysisEntry.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			AnalysisEntry.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _analysisId;
	private long _originalAnalysisId;
	private boolean _setOriginalAnalysisId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _originalCreateDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _canMainId;
	private long _originalCanMainId;
	private boolean _setOriginalCanMainId;
	private String _analysisData;
	private long _columnBitmask;
	private AnalysisEntry _escapedModel;
}