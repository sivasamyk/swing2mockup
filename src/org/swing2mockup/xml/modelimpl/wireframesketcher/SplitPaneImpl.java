package org.swing2mockup.xml.modelimpl.wireframesketcher;

import javax.swing.JSplitPane;

import org.swing2mockup.xml.model.SplitPane;

public class SplitPaneImpl extends WidgetImpl implements SplitPane {

	@Override
	public void setOrientation(int val) {
		String type = val == JSplitPane.VERTICAL_SPLIT ? "model:HSplitter"
				: "model:VSplitter";
		addAttribute(XmlConstants.XSI_TYPE, type);
	}
}
