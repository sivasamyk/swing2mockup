package org.swing2mockup.xml.modelimpl.wireframesketcher;

import org.swing2mockup.xml.model.ProgressBar;

public class ProgressBarImpl extends WidgetImpl implements ProgressBar {

	public ProgressBarImpl()
	{
		addAttribute(XmlConstants.XSI_TYPE, "model:ProgressBar");
	}
	@Override
	public void setValue(int progress) {
		addAttribute(XmlConstants.VALUE, String.valueOf(progress));		
	}

}
