package org.swing2mockup.xml.modelimpl.wireframesketcher;

import org.swing2mockup.xml.model.List;

public class ListImpl extends WidgetImpl implements List {

	public ListImpl()
	{
		addAttribute(XmlConstants.XSI_TYPE, "model:List");
	}
	@Override
	public void setText(String text) {
		addAttribute(XmlConstants.TEXT, text);			
	}
	@Override
	public void setSelectedItem(int row) {
		addAttribute("selection", String.valueOf(row));		
	}

}
