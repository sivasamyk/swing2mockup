package org.swing2mockup.xml.modelimpl.wireframesketcher;

import org.swing2mockup.xml.model.Checkbox;

public class CheckboxImpl extends WidgetImpl implements Checkbox {

	public CheckboxImpl()
	{
		addAttribute(XmlConstants.XSI_TYPE, "model:Checkbox");
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
