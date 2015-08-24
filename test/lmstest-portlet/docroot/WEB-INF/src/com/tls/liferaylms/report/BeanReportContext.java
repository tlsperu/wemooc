package com.tls.liferaylms.report;

import com.tls.liferaylms.test.util.TestProperties;

public class BeanReportContext {

	//LoginTest
	private static boolean hasLogin		= false;
	
	//CreateUsers
	private static boolean createStudent 	= false;
	private static boolean createStudent2	= false;
	private static boolean createTeacher 	= false;
	
	//CreateTestPage
	private static boolean createTestPage	= false;
	private static String  URLtestPage		= null;
	
	//AdminCourse
	private static boolean createCourse		= false;
	private static boolean courseChecked	= false;
	private static String  URLCourse		= null;

	//CheckUsers
	private static boolean studentAsign		= false;
	private static boolean student2Asign	= false;
	private static boolean teacherAsign		= false;
	private static boolean subTeacherAsign = false;
	
	//CreateActivity - Test
	private static boolean module				= false;
	private static boolean testActivity			= false;
	private static boolean testActivitySort		= false;
	private static boolean testActivityDrag		= false;
	private static boolean testActivityFill		= false;
	private static boolean testActivityFree		= false;
	private static boolean testActivityMulti	= false;
	private static boolean testActivityOption	= false;
	
	private static boolean extResourceActivity	= false;
	private static boolean P2PActivity			= false;
	private static boolean pollActivity			= false;
	private static boolean classWorkActivity	= false;
	private static boolean developActivity		= false;
	private static boolean multimediaResource	= false;
	private static boolean evalueActivity		= false;
	private static boolean SCORMActivity		= false;
	
	//CheckActivity
	
	//CheckResults
	
	public static void getBeanContext(){
		setHasLogin		(false);
		setClassWorkActivity(false);
		setCourseChecked(false);
		setCreateCourse(false);
		setCreateStudent(false);
		setCreateStudent2(false);
		setCreateTeacher(false);
		setCreateTestPage(false);
		setDevelopActivity(false);
		setEvalueActivity(false);
		setExtResourceActivity(false);
		setHasLogin(false);
		setModule(false);
		setMultimediaResource(false);
		setP2PActivity(false);
		setPollActivity(false);
		setSCORMActivity(false);
		setStudent2Asign(false);
		setStudentAsign(false);
		setSubTeacherAsign(false);
		setTeacherAsign(false);
		setTestActivity(false);
		setTestActivityDrag(false);
		setTestActivityFill(false);
		setTestActivityFree(false);
		setTestActivityMulti(false);
		setTestActivityOption(false);
		setTestActivitySort(false);
		setURLCourse("");
		setURLtestPage("");
	}
	
	/**
	 * @return the hasLogin
	 */
	public static boolean isHasLogin() {
		return hasLogin;
	}
	/**
	 * @param hasLogin the hasLogin to set
	 */
	public static void setHasLogin(boolean hasLogin) {
		BeanReportContext.hasLogin = hasLogin;
	}
	/**
	 * @return the createStudent
	 */
	public static boolean isCreateStudent() {
		return createStudent;
	}
	/**
	 * @param createStudent the createStudent to set
	 */
	public static void setCreateStudent(boolean createStudent) {
		BeanReportContext.createStudent = createStudent;
	}
	/**
	 * @return the createStudent2
	 */
	public static boolean isCreateStudent2() {
		return createStudent2;
	}
	/**
	 * @param createStudent2 the createStudent2 to set
	 */
	public static void setCreateStudent2(boolean createStudent2) {
		BeanReportContext.createStudent2 = createStudent2;
	}
	/**
	 * @return the createTeacher
	 */
	public static boolean isCreateTeacher() {
		return createTeacher;
	}
	/**
	 * @param createTeacher the createTeacher to set
	 */
	public static void setCreateTeacher(boolean createTeacher) {
		BeanReportContext.createTeacher = createTeacher;
	}
	/**
	 * @return the createTestPage
	 */
	public static boolean isCreateTestPage() {
		return createTestPage;
	}
	/**
	 * @param createTestPage the createTestPage to set
	 */
	public static void setCreateTestPage(boolean createTestPage) {
		BeanReportContext.createTestPage = createTestPage;
	}
	/**
	 * @return the uRLtestPage
	 */
	public static String getURLtestPage() {
		return URLtestPage;
	}
	/**
	 * @param uRLtestPage the uRLtestPage to set
	 */
	public static void setURLtestPage(String uRLtestPage) {
		URLtestPage = uRLtestPage;
	}
	/**
	 * @return the createCourse
	 */
	public static boolean isCreateCourse() {
		return createCourse;
	}
	/**
	 * @param createCourse the createCourse to set
	 */
	public static void setCreateCourse(boolean createCourse) {
		BeanReportContext.createCourse = createCourse;
	}
	/**
	 * @return the courseChecked
	 */
	public static boolean isCourseChecked() {
		return courseChecked;
	}
	/**
	 * @param courseChecked the courseChecked to set
	 */
	public static void setCourseChecked(boolean courseChecked) {
		BeanReportContext.courseChecked = courseChecked;
	}
	/**
	 * @return the uRLCourse
	 */
	public static String getURLCourse() {
		return URLCourse;
	}
	/**
	 * @param uRLCourse the uRLCourse to set
	 */
	public static void setURLCourse(String uRLCourse) {
		URLCourse = uRLCourse;
	}
	/**
	 * @return the studentAsign
	 */
	public static boolean isStudentAsign() {
		return studentAsign;
	}
	/**
	 * @param studentAsign the studentAsign to set
	 */
	public static void setStudentAsign(boolean studentAsign) {
		BeanReportContext.studentAsign = studentAsign;
	}
	/**
	 * @return the student2Asign
	 */
	public static boolean isStudent2Asign() {
		return student2Asign;
	}
	/**
	 * @param student2Asign the student2Asign to set
	 */
	public static void setStudent2Asign(boolean student2Asign) {
		BeanReportContext.student2Asign = student2Asign;
	}
	/**
	 * @return the teacherAsign
	 */
	public static boolean isTeacherAsign() {
		return teacherAsign;
	}
	/**
	 * @param teacherAsign the teacherAsign to set
	 */
	public static void setTeacherAsign(boolean teacherAsign) {
		BeanReportContext.teacherAsign = teacherAsign;
	}
	/**
	 * @return the subTeacherAsign
	 */
	public static boolean isSubTeacherAsign() {
		return subTeacherAsign;
	}
	/**
	 * @param subTeacherAsign the subTeacherAsign to set
	 */
	public static void setSubTeacherAsign(boolean subTeacherAsign) {
		BeanReportContext.subTeacherAsign = subTeacherAsign;
	}
	/**
	 * @return the module
	 */
	public static boolean isModule() {
		return module;
	}
	/**
	 * @param module the module to set
	 */
	public static void setModule(boolean module) {
		BeanReportContext.module = module;
	}
	/**
	 * @return the testActivity
	 */
	public static boolean isTestActivity() {
		return testActivity;
	}
	/**
	 * @param testActivity the testActivity to set
	 */
	public static void setTestActivity(boolean testActivity) {
		BeanReportContext.testActivity = testActivity;
	}
	/**
	 * @return the testActivitySort
	 */
	public static boolean isTestActivitySort() {
		return testActivitySort;
	}
	/**
	 * @param testActivitySort the testActivitySort to set
	 */
	public static void setTestActivitySort(boolean testActivitySort) {
		BeanReportContext.testActivitySort = testActivitySort;
	}
	/**
	 * @return the testActivityDrag
	 */
	public static boolean isTestActivityDrag() {
		return testActivityDrag;
	}
	/**
	 * @param testActivityDrag the testActivityDrag to set
	 */
	public static void setTestActivityDrag(boolean testActivityDrag) {
		BeanReportContext.testActivityDrag = testActivityDrag;
	}
	/**
	 * @return the testActivityFill
	 */
	public static boolean isTestActivityFill() {
		return testActivityFill;
	}
	/**
	 * @param testActivityFill the testActivityFill to set
	 */
	public static void setTestActivityFill(boolean testActivityFill) {
		BeanReportContext.testActivityFill = testActivityFill;
	}
	/**
	 * @return the testActivityFree
	 */
	public static boolean isTestActivityFree() {
		return testActivityFree;
	}
	/**
	 * @param testActivityFree the testActivityFree to set
	 */
	public static void setTestActivityFree(boolean testActivityFree) {
		BeanReportContext.testActivityFree = testActivityFree;
	}
	/**
	 * @return the testActivityMulti
	 */
	public static boolean isTestActivityMulti() {
		return testActivityMulti;
	}
	/**
	 * @param testActivityMulti the testActivityMulti to set
	 */
	public static void setTestActivityMulti(boolean testActivityMulti) {
		BeanReportContext.testActivityMulti = testActivityMulti;
	}
	/**
	 * @return the testActivityOption
	 */
	public static boolean isTestActivityOption() {
		return testActivityOption;
	}
	/**
	 * @param testActivityOption the testActivityOption to set
	 */
	public static void setTestActivityOption(boolean testActivityOption) {
		BeanReportContext.testActivityOption = testActivityOption;
	}
	/**
	 * @return the extResourceActivity
	 */
	public static boolean isExtResourceActivity() {
		return extResourceActivity;
	}
	/**
	 * @param extResourceActivity the extResourceActivity to set
	 */
	public static void setExtResourceActivity(boolean extResourceActivity) {
		BeanReportContext.extResourceActivity = extResourceActivity;
	}
	/**
	 * @return the p2PActivity
	 */
	public static boolean isP2PActivity() {
		return P2PActivity;
	}
	/**
	 * @param p2pActivity the p2PActivity to set
	 */
	public static void setP2PActivity(boolean p2pActivity) {
		P2PActivity = p2pActivity;
	}
	/**
	 * @return the pollActivity
	 */
	public static boolean isPollActivity() {
		return pollActivity;
	}
	/**
	 * @param pollActivity the pollActivity to set
	 */
	public static void setPollActivity(boolean pollActivity) {
		BeanReportContext.pollActivity = pollActivity;
	}
	/**
	 * @return the classWorkActivity
	 */
	public static boolean isClassWorkActivity() {
		return classWorkActivity;
	}
	/**
	 * @param classWorkActivity the classWorkActivity to set
	 */
	public static void setClassWorkActivity(boolean classWorkActivity) {
		BeanReportContext.classWorkActivity = classWorkActivity;
	}
	/**
	 * @return the developActivity
	 */
	public static boolean isDevelopActivity() {
		return developActivity;
	}
	/**
	 * @param developActivity the developActivity to set
	 */
	public static void setDevelopActivity(boolean developActivity) {
		BeanReportContext.developActivity = developActivity;
	}
	/**
	 * @return the multimediaResource
	 */
	public static boolean isMultimediaResource() {
		return multimediaResource;
	}
	/**
	 * @param multimediaResource the multimediaResource to set
	 */
	public static void setMultimediaResource(boolean multimediaResource) {
		BeanReportContext.multimediaResource = multimediaResource;
	}
	/**
	 * @return the evalueActivity
	 */
	public static boolean isEvalueActivity() {
		return evalueActivity;
	}
	/**
	 * @param evalueActivity the evalueActivity to set
	 */
	public static void setEvalueActivity(boolean evalueActivity) {
		BeanReportContext.evalueActivity = evalueActivity;
	}
	/**
	 * @return the sCORMActivity
	 */
	public static boolean isSCORMActivity() {
		return SCORMActivity;
	}
	/**
	 * @param sCORMActivity the sCORMActivity to set
	 */
	public static void setSCORMActivity(boolean sCORMActivity) {
		SCORMActivity = sCORMActivity;
	}

}
