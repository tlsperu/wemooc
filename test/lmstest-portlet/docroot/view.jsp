<%
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
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<%
	try{
%>
<portlet:defineObjects />

<portlet:renderURL var="newactivityURL">
	<portlet:param name="jspPage" value="/test.jsp"></portlet:param>
</portlet:renderURL>

<a href="<%=newactivityURL%>">Testear</a>
<!-- <a  href="javascript:testear();">Testear</a> -->

<script>
function testear(){
	
	// sets timeout to 60 seconds
	var aMinute = 60000;
	
	$.ajax({
		url: '<%=newactivityURL%>',
		//timeout: aMinute * 30,					//30 minutes
		success: function(data) {
			alert("succes!!");
			$(window.document.body).html(data);
		},
		error: function(req, textStatus, errorThrown) {
	        //this is going to happen when you send something different from a 200 OK HTTP
	        alert('Ooops, something happened: ' + textStatus + ' ' +errorThrown + '-->' + req);
	        //testear();
	    }
	});
	
}
</script>
	<% }catch(Exception e){
			e.printStackTrace();
	}%>
	