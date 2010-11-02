package org.swing2mockup.xml.modelimpl.wireframesketcher;

import org.swing2mockup.xml.model.Table;

public class TableImpl extends WidgetImpl implements Table {

	public TableImpl() {
		addAttribute(XmlConstants.XSI_TYPE, "model:Table");
	}

	@Override
	public void setText(String text) {
		addAttribute(XmlConstants.TEXT, text);
	}

	@Override
	public void setSelectedRow(int row) {
		addAttribute(XmlConstants.SELECTED, String.valueOf(row + 1));		
	}

}
