package org.swing2mockup.xml.modelimpl.wireframesketcher;

import org.swing2mockup.xml.model.Widget;
import org.swing2mockup.xml.modelimpl.DefaultXmlNode;

public class WidgetImpl extends DefaultXmlNode implements Widget {

	public WidgetImpl() {
		this(XmlConstants.WIDGET);
	}
	
	public WidgetImpl(String name) {
		super(name);
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setEnabled(boolean enabled) {
		// TODO Auto-generated method stub		
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
