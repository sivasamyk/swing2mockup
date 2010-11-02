package org.swing2mockup.xml.model;

public interface Widget extends XmlNode {
	int getX();
	
	void setX(int value);

	int getY();

	void setY(int value);

	int getWidth();

	void setWidth(int value);

	int getHeight();

	void setHeight(int value);
	
	void setEnabled(boolean enabled);
}
