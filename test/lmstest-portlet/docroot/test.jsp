<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.tls.liferaylms.report.GenerateReport"%>
<%@page import="java.io.File"%>
<%@page import="com.tls.liferaylms.report.BeanReportContext"%>
<%@page import="com.tls.liferaylms.test.util.Context"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page buffer="200000kb" autoFlush="false" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<%@page import="com.tls.liferaylms.test.SeleniumDriverUtil"%>
<%@page import="org.junit.runner.notification.Failure"%>
<%@page import="org.junit.runner.Result"%>
<%@page import="java.util.List"%>
<%@page import="com.tls.liferaylms.test.ClassFinder"%>
<%@page import="java.util.Enumeration"%>
<%@page import="junit.framework.TestFailure"%>
<%@page import="junit.framework.TestResult"%>
<%@page import="com.tls.liferaylms.test.unit.Aa_LoginTest"%>
<%@page import="junit.framework.JUnit4TestAdapter"%>
<%@page import="org.junit.runner.JUnitCore"%>
<%@page import="org.testng.junit.JUnit4TestRunner"%>

<table>
<%
Log 	log 	= LogFactoryUtil.getLog	("com.tls.liferaylms.test.jsp");
Class[] classes = ClassFinder.getClasses("com.tls.liferaylms.test.unit");

Context.getTestContext();
BeanReportContext.getBeanContext();

boolean salir= false;
for(Class clase:classes)
	{
    	if (salir) break;
// 		if (clase.getName().equalsIgnoreCase( "com.tls.liferaylms.test.unit.Aa_LoginTest")) salir = true;
	 	if (clase.getName().equalsIgnoreCase( "com.tls.liferaylms.test.unit.Ab_CreateUsers")) continue;
	 	if (clase.getName().equalsIgnoreCase("com.tls.liferaylms.test.unit.Ac_CreateTestPage")) continue;
// 	  	if (clase.getName().equalsIgnoreCase("com.tls.liferaylms.test.unit.Ba_AdminCourse")) salir=true;
//     	if (clase.getName().equalsIgnoreCase("com.tls.liferaylms.test.unit.Bb_CheckUsers")) continue;
// 	  	if (clase.getName().equalsIgnoreCase("com.tls.liferaylms.test.unit.Bc_CreateActivity")) continue;
// 	    if (clase.getName().equalsIgnoreCase("com.tls.liferaylms.test.unit.Bd_CheckActivity")) continue;
// 	    if (clase.getName().equalsIgnoreCase("com.tls.liferaylms.test.unit.Be_CheckResults")) continue;//salir = true;
// 	    if (clase.getName().equalsIgnoreCase("com.tls.liferaylms.test.unit.Bf_CheckActivityRestrictions")) continue;
	    if (clase.getName().equalsIgnoreCase("com.tls.liferaylms.test.unit.Z_DeleteTestPage")) continue;

	if(log.isInfoEnabled()) log.info("Exec::"+clase.getName());
	%>
	<tr><td><%=clase.getName() %></td>
	<%

try{
	
	Result result = JUnitCore.runClasses(clase);

	if(result.getFailureCount()>0){
	%>
	<td style="background-color:red; width: 5%;"><%=result.getFailureCount() %></td>
	<%
	}else{
	%>
	<td style="background-color:green; width: 5%;"><%=result.getFailureCount() %></td>
	<%
	}
%>
<td>
<%
	List<Failure> fallos=result.getFailures();
	for(Failure fallo:fallos)
	{
		%>
		<br />
		<%=fallo.toString() %>:	
		<%
	}
%>
</td></tr>
<%
	}
catch(Throwable e){
	e.printStackTrace();
}
}
	GenerateReport gr = new GenerateReport();
	File archivo = gr.generateFile();

	Context.removeContext();
  	SeleniumDriverUtil.closeDriver();
%>
</table>

<portlet:resourceURL var="reportURL" id="reportURL"/>

<a href="<%=reportURL%>&Report=<%=archivo%>">Informe</a>






