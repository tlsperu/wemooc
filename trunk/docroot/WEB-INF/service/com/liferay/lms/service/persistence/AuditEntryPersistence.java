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

package com.liferay.lms.service.persistence;

import com.liferay.lms.model.AuditEntry;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the audit entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author TLS
 * @see AuditEntryPersistenceImpl
 * @see AuditEntryUtil
 * @generated
 */
public interface AuditEntryPersistence extends BasePersistence<AuditEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AuditEntryUtil} to access the audit entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the audit entry in the entity cache if it is enabled.
	*
	* @param auditEntry the audit entry
	*/
	public void cacheResult(com.liferay.lms.model.AuditEntry auditEntry);

	/**
	* Caches the audit entries in the entity cache if it is enabled.
	*
	* @param auditEntries the audit entries
	*/
	public void cacheResult(
		java.util.List<com.liferay.lms.model.AuditEntry> auditEntries);

	/**
	* Creates a new audit entry with the primary key. Does not add the audit entry to the database.
	*
	* @param auditId the primary key for the new audit entry
	* @return the new audit entry
	*/
	public com.liferay.lms.model.AuditEntry create(long auditId);

	/**
	* Removes the audit entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param auditId the primary key of the audit entry
	* @return the audit entry that was removed
	* @throws com.liferay.lms.NoSuchAuditEntryException if a audit entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.AuditEntry remove(long auditId)
		throws com.liferay.lms.NoSuchAuditEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.lms.model.AuditEntry updateImpl(
		com.liferay.lms.model.AuditEntry auditEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the audit entry with the primary key or throws a {@link com.liferay.lms.NoSuchAuditEntryException} if it could not be found.
	*
	* @param auditId the primary key of the audit entry
	* @return the audit entry
	* @throws com.liferay.lms.NoSuchAuditEntryException if a audit entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.AuditEntry findByPrimaryKey(long auditId)
		throws com.liferay.lms.NoSuchAuditEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the audit entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param auditId the primary key of the audit entry
	* @return the audit entry, or <code>null</code> if a audit entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.model.AuditEntry fetchByPrimaryKey(long auditId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the audit entries.
	*
	* @return the audit entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.lms.model.AuditEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the audit entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of audit entries
	* @param end the upper bound of the range of audit entries (not inclusive)
	* @return the range of audit entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.lms.model.AuditEntry> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the audit entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of audit entries
	* @param end the upper bound of the range of audit entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of audit entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.lms.model.AuditEntry> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the audit entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of audit entries.
	*
	* @return the number of audit entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}