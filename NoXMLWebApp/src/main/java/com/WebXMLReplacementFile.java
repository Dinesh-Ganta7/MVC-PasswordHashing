package com;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebXMLReplacementFile extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class[] configClassArray = { ConfigClass.class };

		return configClassArray;
	}

	@Override
	protected String[] getServletMappings() {
		String[] urlMappings = { "/star/*" };
		return urlMappings;
	}

}
