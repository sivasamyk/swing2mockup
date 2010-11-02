package org.swing2mockup.xml.modelimpl.wireframesketcher;

import org.swing2mockup.xml.model.TextArea;

public class TextAreaImpl extends WidgetImpl implements TextArea {
	public TextAreaImpl()
	{
		addAttribute(XmlConstants.XSI_TYPE, "model:TextArea");
	}
	
	@Override
	public void setText(String text) {
		addAttribute(XmlConstants.TEXT, text);		
	}
}
