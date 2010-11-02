package org.swing2mockup.xml.modelimpl.wireframesketcher;

import org.swing2mockup.xml.model.MenuItem;

public class MenuItemImpl extends WidgetImpl implements MenuItem {

	public MenuItemImpl()
	{
		addAttribute(XmlConstants.XSI_TYPE, "model:MenuItem");
	}
	
	@Override
	public void setText(String str) {
		addAttribute(XmlConstants.TEXT, str);				
	}

}
