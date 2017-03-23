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

package com.liferay.micro.maintainance.task.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the CandidateMaintenance service. Represents a row in the &quot;Task_CandidateMaintenance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.micro.maintainance.task.model.impl.CandidateMaintenanceModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.micro.maintainance.task.model.impl.CandidateMaintenanceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateMaintenance
 * @see com.liferay.micro.maintainance.task.model.impl.CandidateMaintenanceImpl
 * @see com.liferay.micro.maintainance.task.model.impl.CandidateMaintenanceModelImpl
 * @generated
 */
@ProviderType
public interface CandidateMaintenanceModel extends BaseModel<CandidateMaintenance> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a candidate maintenance model instance should use the {@link CandidateMaintenance} interface instead.
	 */

	/**
	 * Returns the primary key of this candidate maintenance.
	 *
	 * @return the primary key of this candidate maintenance
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this candidate maintenance.
	 *
	 * @param primaryKey the primary key of this candidate maintenance
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this candidate maintenance.
	 *
	 * @return the uuid of this candidate maintenance
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this candidate maintenance.
	 *
	 * @param uuid the uuid of this candidate maintenance
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the candidate maintenance ID of this candidate maintenance.
	 *
	 * @return the candidate maintenance ID of this candidate maintenance
	 */
	public long getCandidateMaintenanceId();

	/**
	 * Sets the candidate maintenance ID of this candidate maintenance.
	 *
	 * @param candidateMaintenanceId the candidate maintenance ID of this candidate maintenance
	 */
	public void setCandidateMaintenanceId(long candidateMaintenanceId);

	/**
	 * Returns the candidate ID of this candidate maintenance.
	 *
	 * @return the candidate ID of this candidate maintenance
	 */
	public long getCandidateId();

	/**
	 * Sets the candidate ID of this candidate maintenance.
	 *
	 * @param candidateId the candidate ID of this candidate maintenance
	 */
	public void setCandidateId(long candidateId);

	/**
	 * Returns the task ID of this candidate maintenance.
	 *
	 * @return the task ID of this candidate maintenance
	 */
	public long getTaskId();

	/**
	 * Sets the task ID of this candidate maintenance.
	 *
	 * @param taskId the task ID of this candidate maintenance
	 */
	public void setTaskId(long taskId);

	/**
	 * Returns the create date of this candidate maintenance.
	 *
	 * @return the create date of this candidate maintenance
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this candidate maintenance.
	 *
	 * @param createDate the create date of this candidate maintenance
	 */
	public void setCreateDate(Date createDate);

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
	public int compareTo(CandidateMaintenance candidateMaintenance);

	@Override
	public int hashCode();

	@Override
	public CacheModel<CandidateMaintenance> toCacheModel();

	@Override
	public CandidateMaintenance toEscapedModel();

	@Override
	public CandidateMaintenance toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}