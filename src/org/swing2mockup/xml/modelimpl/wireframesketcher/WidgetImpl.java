package org.swing2mockup.xml.modelimpl.wireframesketcher;

import org.swing2mockup.xml.model.Widget;
import org.swing2mockup.xml.modelimpl.DefaultXmlNode;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Attributes;

public class WidgetImpl extends DefaultXmlNode implements Widget {

	public WidgetImpl() {
		this(XmlConstants.WIDGET);
	}
	
	public WidgetImpl(String name) {
		super(name);
	}

	@Override
	public int getHeight() {
		String height = getAttributes().get(XmlConstants.HEIGHT);
		return height != null ? Integer.parseInt(height) : 0;
	}

	@Override
	public int getWidth() {
		String width = getAttributes().get(XmlConstants.WIDTH);
		return width != null ? Integer.parseInt(width) : 0;
	}

	@Override
	public int getX() {
		String x = getAttributes().get(XmlConstants.X);
		return x != null ? Integer.parseInt(x) : 0;
	}

	@Override
	public int getY() {
		String y = getAttributes().get(XmlConstants.Y);
		return y != null ? Integer.parseInt(y) : 0;
	}

	@Override
	public void setEnabled(boolean enabled) {
		addAttribute(XmlConstants.STATE, enabled ? "normal" : "disabled");
	}

	@Override
	public void setHeight(int value) {
		addAttribute(XmlConstants.HEIGHT, String.valueOf(value));		
	}

	@Override
	public void setWidth(int value) {
		addAttribute(XmlConstants.WIDTH, String.valueOf(value));
	}

	@Override
	public void setX(int value) {
		addAttribute(XmlConstants.X, String.valueOf(value));
	}

	@Override
	public void setY(int value) {
		addAttribute(XmlConstants.Y, String.valueOf(value));
	}

}
