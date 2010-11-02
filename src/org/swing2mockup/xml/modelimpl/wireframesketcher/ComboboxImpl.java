package org.swing2mockup.xml.modelimpl.wireframesketcher;

import org.swing2mockup.xml.model.Combobox;

public class ComboboxImpl extends WidgetImpl implements Combobox {

	public ComboboxImpl()
	{
		addAttribute(XmlConstants.XSI_TYPE, "model:Combo");
	}
	@Override
	public void setText(String text) {
		addAttribute(XmlConstants.TEXT, text);						
	}

}
