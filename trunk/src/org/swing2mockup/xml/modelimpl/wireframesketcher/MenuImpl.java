package org.swing2mockup.xml.modelimpl.wireframesketcher;

import org.swing2mockup.xml.model.Menu;

public class MenuImpl extends MenuItemImpl implements Menu {

	public MenuImpl()
	{
		addAttribute(XmlConstants.XSI_TYPE, "model:Menu");
	}
	
	public void setHeight(int h)
	{
		
	}
}
