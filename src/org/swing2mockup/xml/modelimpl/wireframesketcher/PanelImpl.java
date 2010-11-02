package org.swing2mockup.xml.modelimpl.wireframesketcher;

import org.swing2mockup.xml.model.Panel;

public class PanelImpl extends WidgetImpl implements Panel {

	public PanelImpl()
	{
		addAttribute(XmlConstants.XSI_TYPE, "model:Panel");
	}
	
	@Override
	public void setTitle(String title) {
		addAttribute(XmlConstants.XSI_TYPE, "model:Group");
		addAttribute(XmlConstants.TEXT, title);
	}

	@Override
	public void setBorder(boolean b) {
		String borderVal = b ? "solid" : "none";
		addAttribute(XmlConstants.BORDER, borderVal);		
	}

}
