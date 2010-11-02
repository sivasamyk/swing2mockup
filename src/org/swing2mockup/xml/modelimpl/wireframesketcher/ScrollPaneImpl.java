package org.swing2mockup.xml.modelimpl.wireframesketcher;

import org.swing2mockup.xml.model.ScrollPane;

public class ScrollPaneImpl extends WidgetImpl implements ScrollPane {
	
	public ScrollPaneImpl()
	{
		addAttribute(XmlConstants.XSI_TYPE, "model:Panel");
		addAttribute(XmlConstants.BORDER, "none");
	}

	@Override
	public void setHorizontalScrollBar(boolean e) {
		//No Impl
	}

	@Override
	public void setVerticalScrollBar(boolean e) {
		addAttribute("verticalScrollbar", String.valueOf(e));
	}

}
