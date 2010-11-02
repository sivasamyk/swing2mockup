package org.swing2mockup.xml.modelimpl.wireframesketcher;

import org.swing2mockup.xml.model.Window;

public class WindowImpl extends WidgetImpl implements Window {
	public WindowImpl() {
		super();
		addAttribute(XmlConstants.XSI_TYPE, "model:Window");
	}

	@Override
	public void setTitle(String title) {
		if (title != null) {
			addAttribute(XmlConstants.TEXT, title);
		}
	}
}
