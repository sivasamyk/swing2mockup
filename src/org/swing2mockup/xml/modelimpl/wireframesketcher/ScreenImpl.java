package org.swing2mockup.xml.modelimpl.wireframesketcher;

import org.swing2mockup.xml.model.Screen;
import org.swing2mockup.xml.modelimpl.DefaultXmlNode;



public class ScreenImpl extends DefaultXmlNode implements Screen{

	public ScreenImpl() {
		super(XmlConstants.SCREEN);
		addAttribute(XmlConstants.XMLNS_XSI, "http://www.w3.org/2001/XMLSchema-instance");
		addAttribute(XmlConstants.XMLNS_MODEL, "http://wireframesketcher.com/1.0/model.ecore");
	}

}
