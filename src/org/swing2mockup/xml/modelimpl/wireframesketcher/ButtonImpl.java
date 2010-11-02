package org.swing2mockup.xml.modelimpl.wireframesketcher;

import org.swing2mockup.xml.model.Button;

public class ButtonImpl extends WidgetImpl implements Button {

	public ButtonImpl()
	{
		super();
		addAttribute(XmlConstants.XSI_TYPE, "model:Button");
	}
	@Override
	public void setText(String text) {
		addAttribute(XmlConstants.TEXT, text);		
	}
	@Override
	public void setIcon(boolean isIcon) {
		addAttribute(XmlConstants.ICON, "image (small)");				
	}
}
