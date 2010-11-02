package org.swing2mockup.xml.modelimpl.wireframesketcher;

import org.swing2mockup.xml.model.RadioButton;

public class RadiobuttonImpl extends WidgetImpl implements RadioButton {

	public RadiobuttonImpl()
	{
		addAttribute(XmlConstants.XSI_TYPE, "model:RadioButton");
	}
	@Override
	public void setSelected(boolean e) {
		addAttribute(XmlConstants.SELECTED, String.valueOf(e));					
	}

	@Override
	public void setText(String text) {
		addAttribute(XmlConstants.TEXT, text);				
	}

}
