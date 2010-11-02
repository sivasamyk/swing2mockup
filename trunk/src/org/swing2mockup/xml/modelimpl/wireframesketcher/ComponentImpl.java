package org.swing2mockup.xml.modelimpl.wireframesketcher;

import org.swing2mockup.xml.model.Component;

public class ComponentImpl extends WidgetImpl implements Component {

	public ComponentImpl()
	{
		addAttribute(XmlConstants.XSI_TYPE, "model:Area");
	}
}
