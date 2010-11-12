package org.swing2mockup.xml.model;

public interface Table extends Widget {
	void setText(String text);
	void setSelectedRow(int row);
	void setVerticalScrollBar(boolean isVScroll);
}
