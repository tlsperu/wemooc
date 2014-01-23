/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.liferay.lmssa.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ActManAudit service. Represents a row in the &quot;lmssa_ActManAudit&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.lmssa.model.impl.ActManAuditModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.lmssa.model.impl.ActManAuditImpl}.
 * </p>
 *
 * @author TLS
 * @see ActManAudit
 * @see com.liferay.lmssa.model.impl.ActManAuditImpl
 * @see com.liferay.lmssa.model.impl.ActManAuditModelImpl
 * @generated
 */
public interface ActManAuditModel extends BaseModel<ActManAudit> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a act man audit model instance should use the {@link ActManAudit} interface instead.
	 */

	/**
	 * Returns the primary key of this act man audit.
	 *
	 * @return the primary key of this act man audit
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this act man audit.
	 *
	 * @param primaryKey the primary key of this act man audit
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this act man audit.
	 *
	 * @return the uuid of this act man audit
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this act man audit.
	 *
	 * @param uuid the uuid of this act man audit
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the act man audit ID of this act man audit.
	 *
	 * @return the act man audit ID of this act man audit
	 */
	public long getActManAuditId();

	/**
	 * Sets the act man audit ID of this act man audit.
	 *
	 * @param actManAuditId the act man audit ID of this act man audit
	 */
	public void setActManAuditId(long actManAuditId);

	/**
	 * Returns the company ID of this act man audit.
	 *
	 * @return the company ID of this act man audit
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this act man audit.
	 *
	 * @param companyId the company ID of this act man audit
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this act man audit.
	 *
	 * @return the group ID of this act man audit
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this act man audit.
	 *
	 * @param groupId the group ID of this act man audit
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this act man audit.
	 *
	 * @return the user ID of this act man audit
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this act man audit.
	 *
	 * @param userId the user ID of this act man audit
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this act man audit.
	 *
	 * @return the user uuid of this act man audit
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this act man audit.
	 *
	 * @param userUuid the user uuid of this act man audit
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the course ID of this act man audit.
	 *
	 * @return the course ID of this act man audit
	 */
	public long getCourseId();

	/**
	 * Sets the course ID of this act man audit.
	 *
	 * @param courseId the course ID of this act man audit
	 */
	public void setCourseId(long courseId);

	/**
	 * Returns the class name of this act man audit.
	 *
	 * @return the class name of this act man audit
	 */
	@AutoEscape
	public String getClassName();

	/**
	 * Sets the class name of this act man audit.
	 *
	 * @param className the class name of this act man audit
	 */
	public void setClassName(String className);

	/**
	 * Returns the start of this act man audit.
	 *
	 * @return the start of this act man audit
	 */
	public Date getStart();

	/**
	 * Sets the start of this act man audit.
	 *
	 * @param start the start of this act man audit
	 */
	public void setStart(Date start);

	/**
	 * Returns the end of this act man audit.
	 *
	 * @return the end of this act man audit
	 */
	public Date getEnd();

	/**
	 * Sets the end of this act man audit.
	 *
	 * @param end the end of this act man audit
	 */
	public void setEnd(Date end);

	/**
	 * Returns the state of this act man audit.
	 *
	 * @return the state of this act man audit
	 */
	@AutoEscape
	public String getState();

	/**
	 * Sets the state of this act man audit.
	 *
	 * @param state the state of this act man audit
	 */
	public void setState(String state);

	/**
	 * Returns the number of this act man audit.
	 *
	 * @return the number of this act man audit
	 */
	public int getNumber();

	/**
	 * Sets the number of this act man audit.
	 *
	 * @param number the number of this act man audit
	 */
	public void setNumber(int number);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(ActManAudit actManAudit);

	public int hashCode();

	public CacheModel<ActManAudit> toCacheModel();

	public ActManAudit toEscapedModel();

	public String toString();

	public String toXmlString();
}