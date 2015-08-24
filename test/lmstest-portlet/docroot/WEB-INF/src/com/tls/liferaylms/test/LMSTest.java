package com.tls.liferaylms.test;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class LMSTest extends MVCPortlet{

	private String viewJSP = null;
	private static Log log = LogFactoryUtil.getLog(LMSTest.class);
	
	public void init() throws PortletException {	
		viewJSP = getInitParameter("view-template");
	}
	
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException{
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);	
			
		ResourceURL reportURL = renderResponse.createResourceURL();
		
    	renderRequest.setAttribute("reportURL", reportURL);
		
		include(this.viewJSP, renderRequest, renderResponse);
	}
	
	public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException,IOException{
		
		String URLFile = ParamUtil.get(request, "Report", "");

		File archivo = new File(URLFile);
		
		if(archivo != null){
			byte[] datos = new byte[4096];
		 	
			response.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=Test-Report.txt");
		 	response.setContentType("application/octet-stream");
		 	response.setCharacterEncoding("UTF-8");
			response.setContentLength((int)archivo.length());
			
			OutputStream ouputStream = response.getPortletOutputStream();
			
			DataInputStream in = new DataInputStream(new FileInputStream(archivo));
	
			// reads the file's bytes and writes them to the response stream
			int length   = 0;
			while ((in != null) && ((length = in.read(datos)) != -1)){
				ouputStream.write(datos,0,length);
			}	

			ouputStream.flush();
			ouputStream.close();
			in.close();
		}
	}
	
	protected void include(String path, RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext()
				.getRequestDispatcher(path);

		if (portletRequestDispatcher != null) {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}
}
