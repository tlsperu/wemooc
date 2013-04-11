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

package com.liferay.lms.service.base;

import com.liferay.lms.service.LearningActivityLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class LearningActivityLocalServiceClpInvoker {
	public LearningActivityLocalServiceClpInvoker() {
		_methodName0 = "addLearningActivity";

		_methodParameterTypes0 = new String[] {
				"com.liferay.lms.model.LearningActivity"
			};

		_methodName1 = "createLearningActivity";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteLearningActivity";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteLearningActivity";

		_methodParameterTypes3 = new String[] {
				"com.liferay.lms.model.LearningActivity"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "fetchLearningActivity";

		_methodParameterTypes9 = new String[] { "long" };

		_methodName10 = "getLearningActivity";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getPersistedModel";

		_methodParameterTypes11 = new String[] { "java.io.Serializable" };

		_methodName12 = "getLearningActivityByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getLearningActivities";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getLearningActivitiesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateLearningActivity";

		_methodParameterTypes15 = new String[] {
				"com.liferay.lms.model.LearningActivity"
			};

		_methodName16 = "updateLearningActivity";

		_methodParameterTypes16 = new String[] {
				"com.liferay.lms.model.LearningActivity", "boolean"
			};

		_methodName131 = "getBeanIdentifier";

		_methodParameterTypes131 = new String[] {  };

		_methodName132 = "setBeanIdentifier";

		_methodParameterTypes132 = new String[] { "java.lang.String" };

		_methodName137 = "islocked";

		_methodParameterTypes137 = new String[] { "long", "long" };

		_methodName138 = "addLearningActivity";

		_methodParameterTypes138 = new String[] {
				"com.liferay.lms.model.LearningActivity",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName139 = "addLearningActivity";

		_methodParameterTypes139 = new String[] {
				"java.lang.String", "java.lang.String", "java.util.Date",
				"java.util.Date", "java.util.Date", "int", "long", "int", "long",
				"java.lang.String", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName140 = "modLearningActivity";

		_methodParameterTypes140 = new String[] {
				"long", "java.lang.String", "java.lang.String", "java.util.Date",
				"java.util.Date", "java.util.Date", "int", "long", "int", "long",
				"java.lang.String", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName141 = "modLearningActivity";

		_methodParameterTypes141 = new String[] {
				"com.liferay.lms.model.LearningActivity",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName142 = "modLearningActivity";

		_methodParameterTypes142 = new String[] {
				"com.liferay.lms.model.LearningActivity"
			};

		_methodName143 = "getLearningActivitiesOfGroup";

		_methodParameterTypes143 = new String[] { "long" };

		_methodName144 = "getLearningActivitiesOfGroupAndType";

		_methodParameterTypes144 = new String[] { "long", "int" };

		_methodName145 = "getLearningActivitiesOfModule";

		_methodParameterTypes145 = new String[] { "long" };

		_methodName146 = "getLearningActivityIdsOfModule";

		_methodParameterTypes146 = new String[] { "long" };

		_methodName147 = "deleteLearningactivity";

		_methodParameterTypes147 = new String[] {
				"com.liferay.lms.model.LearningActivity"
			};

		_methodName148 = "getPreviusLearningActivity";

		_methodParameterTypes148 = new String[] { "long" };

		_methodName149 = "getPreviusLearningActivity";

		_methodParameterTypes149 = new String[] {
				"com.liferay.lms.model.LearningActivity"
			};

		_methodName150 = "goUpLearningActivity";

		_methodParameterTypes150 = new String[] { "long" };

		_methodName151 = "goDownLearningActivity";

		_methodParameterTypes151 = new String[] { "long" };

		_methodName152 = "getNextLearningActivity";

		_methodParameterTypes152 = new String[] { "long" };

		_methodName153 = "getNextLearningActivity";

		_methodParameterTypes153 = new String[] {
				"com.liferay.lms.model.LearningActivity"
			};

		_methodName154 = "deleteLearningactivity";

		_methodParameterTypes154 = new String[] { "long" };

		_methodName155 = "getExtraContentValue";

		_methodParameterTypes155 = new String[] { "long", "java.lang.String" };

		_methodName156 = "setExtraContentValue";

		_methodParameterTypes156 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return LearningActivityLocalServiceUtil.addLearningActivity((com.liferay.lms.model.LearningActivity)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return LearningActivityLocalServiceUtil.createLearningActivity(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return LearningActivityLocalServiceUtil.deleteLearningActivity(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return LearningActivityLocalServiceUtil.deleteLearningActivity((com.liferay.lms.model.LearningActivity)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return LearningActivityLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return LearningActivityLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return LearningActivityLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return LearningActivityLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return LearningActivityLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return LearningActivityLocalServiceUtil.fetchLearningActivity(((Long)arguments[0]).longValue());
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return LearningActivityLocalServiceUtil.getLearningActivity(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return LearningActivityLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return LearningActivityLocalServiceUtil.getLearningActivityByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return LearningActivityLocalServiceUtil.getLearningActivities(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return LearningActivityLocalServiceUtil.getLearningActivitiesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return LearningActivityLocalServiceUtil.updateLearningActivity((com.liferay.lms.model.LearningActivity)arguments[0]);
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return LearningActivityLocalServiceUtil.updateLearningActivity((com.liferay.lms.model.LearningActivity)arguments[0],
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName131.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes131, parameterTypes)) {
			return LearningActivityLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName132.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes132, parameterTypes)) {
			LearningActivityLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName137.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes137, parameterTypes)) {
			return LearningActivityLocalServiceUtil.islocked(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName138.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes138, parameterTypes)) {
			return LearningActivityLocalServiceUtil.addLearningActivity((com.liferay.lms.model.LearningActivity)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName139.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes139, parameterTypes)) {
			return LearningActivityLocalServiceUtil.addLearningActivity((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.util.Date)arguments[2],
				(java.util.Date)arguments[3], (java.util.Date)arguments[4],
				((Integer)arguments[5]).intValue(),
				((Long)arguments[6]).longValue(),
				((Integer)arguments[7]).intValue(),
				((Long)arguments[8]).longValue(),
				(java.lang.String)arguments[9],
				(java.lang.String)arguments[10],
				(com.liferay.portal.service.ServiceContext)arguments[11]);
		}

		if (_methodName140.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes140, parameterTypes)) {
			return LearningActivityLocalServiceUtil.modLearningActivity(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.util.Date)arguments[3], (java.util.Date)arguments[4],
				(java.util.Date)arguments[5],
				((Integer)arguments[6]).intValue(),
				((Long)arguments[7]).longValue(),
				((Integer)arguments[8]).intValue(),
				((Long)arguments[9]).longValue(),
				(java.lang.String)arguments[10],
				(java.lang.String)arguments[11],
				(com.liferay.portal.service.ServiceContext)arguments[12]);
		}

		if (_methodName141.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes141, parameterTypes)) {
			return LearningActivityLocalServiceUtil.modLearningActivity((com.liferay.lms.model.LearningActivity)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName142.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes142, parameterTypes)) {
			return LearningActivityLocalServiceUtil.modLearningActivity((com.liferay.lms.model.LearningActivity)arguments[0]);
		}

		if (_methodName143.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes143, parameterTypes)) {
			return LearningActivityLocalServiceUtil.getLearningActivitiesOfGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName144.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
			return LearningActivityLocalServiceUtil.getLearningActivitiesOfGroupAndType(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName145.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes145, parameterTypes)) {
			return LearningActivityLocalServiceUtil.getLearningActivitiesOfModule(((Long)arguments[0]).longValue());
		}

		if (_methodName146.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes146, parameterTypes)) {
			return LearningActivityLocalServiceUtil.getLearningActivityIdsOfModule(((Long)arguments[0]).longValue());
		}

		if (_methodName147.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes147, parameterTypes)) {
			LearningActivityLocalServiceUtil.deleteLearningactivity((com.liferay.lms.model.LearningActivity)arguments[0]);

			return null;
		}

		if (_methodName148.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes148, parameterTypes)) {
			return LearningActivityLocalServiceUtil.getPreviusLearningActivity(((Long)arguments[0]).longValue());
		}

		if (_methodName149.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes149, parameterTypes)) {
			return LearningActivityLocalServiceUtil.getPreviusLearningActivity((com.liferay.lms.model.LearningActivity)arguments[0]);
		}

		if (_methodName150.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes150, parameterTypes)) {
			LearningActivityLocalServiceUtil.goUpLearningActivity(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName151.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes151, parameterTypes)) {
			LearningActivityLocalServiceUtil.goDownLearningActivity(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName152.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes152, parameterTypes)) {
			return LearningActivityLocalServiceUtil.getNextLearningActivity(((Long)arguments[0]).longValue());
		}

		if (_methodName153.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes153, parameterTypes)) {
			return LearningActivityLocalServiceUtil.getNextLearningActivity((com.liferay.lms.model.LearningActivity)arguments[0]);
		}

		if (_methodName154.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes154, parameterTypes)) {
			LearningActivityLocalServiceUtil.deleteLearningactivity(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName155.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes155, parameterTypes)) {
			return LearningActivityLocalServiceUtil.getExtraContentValue(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName156.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes156, parameterTypes)) {
			LearningActivityLocalServiceUtil.setExtraContentValue(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName131;
	private String[] _methodParameterTypes131;
	private String _methodName132;
	private String[] _methodParameterTypes132;
	private String _methodName137;
	private String[] _methodParameterTypes137;
	private String _methodName138;
	private String[] _methodParameterTypes138;
	private String _methodName139;
	private String[] _methodParameterTypes139;
	private String _methodName140;
	private String[] _methodParameterTypes140;
	private String _methodName141;
	private String[] _methodParameterTypes141;
	private String _methodName142;
	private String[] _methodParameterTypes142;
	private String _methodName143;
	private String[] _methodParameterTypes143;
	private String _methodName144;
	private String[] _methodParameterTypes144;
	private String _methodName145;
	private String[] _methodParameterTypes145;
	private String _methodName146;
	private String[] _methodParameterTypes146;
	private String _methodName147;
	private String[] _methodParameterTypes147;
	private String _methodName148;
	private String[] _methodParameterTypes148;
	private String _methodName149;
	private String[] _methodParameterTypes149;
	private String _methodName150;
	private String[] _methodParameterTypes150;
	private String _methodName151;
	private String[] _methodParameterTypes151;
	private String _methodName152;
	private String[] _methodParameterTypes152;
	private String _methodName153;
	private String[] _methodParameterTypes153;
	private String _methodName154;
	private String[] _methodParameterTypes154;
	private String _methodName155;
	private String[] _methodParameterTypes155;
	private String _methodName156;
	private String[] _methodParameterTypes156;
}