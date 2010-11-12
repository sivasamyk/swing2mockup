package org.swing2mockup.xml.modelimpl.wireframesketcher;

import org.swing2mockup.xml.model.Tree;

public class TreeImpl extends WidgetImpl implements Tree {

	public TreeImpl() {
		addAttribute(XmlConstants.XSI_TYPE, "model:Tree");
	}

	@Override
	public void setText(String text) {
		addAttribute(XmlConstants.TEXT, text);
	}
	

	@Override
	public void setVerticalScrollBar(boolean isVScroll) {
		addAttribute(XmlConstants.VSCROLLBAR, String.valueOf(isVScroll));	
	}

}
