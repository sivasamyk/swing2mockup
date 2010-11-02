package org.swing2mockup.xml.modelimpl.wireframesketcher;

import org.swing2mockup.xml.model.TextField;

public class TextFieldImpl extends WidgetImpl implements TextField {
	public TextFieldImpl()
	{
		addAttribute(XmlConstants.XSI_TYPE, "model:TextField");
	}
	
	@Override
	public void setText(String text) {
		addAttribute(XmlConstants.TEXT, text);		
	}
}
