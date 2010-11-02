package org.swing2mockup.xml.modelimpl.wireframesketcher;

import javax.swing.JLabel;

import org.swing2mockup.xml.model.Label;

public class LabelImpl extends WidgetImpl implements Label {

	public LabelImpl() {
		super();
		addAttribute(XmlConstants.XSI_TYPE, "model:Label");
	}

	@Override
	public void setText(String text) {
		addAttribute(XmlConstants.TEXT, text);
	}

	@Override
	public void setIcon(boolean isIcon) {
		addAttribute(XmlConstants.ICON, "image (small)");
	}

	public void setWidth(int val) {

	}

	public void setHeight(int val) {

	}

	@Override
	public void setTextAlignment(int align) {
		addAttribute(XmlConstants.ALIGNMENT, getTextAlignment(align));
	}

	private String getTextAlignment(int intVal) {
		String align = "Left";
		switch (intVal) {
		case JLabel.CENTER:
			align = "Center";
			break;
		case JLabel.RIGHT:
			align = "Right";
			break;
		}
		return align;
	}
}
