package org.swing2mockup.xml.modelimpl.wireframesketcher;

import javax.swing.JTabbedPane;

import org.swing2mockup.xml.model.TabbedPane;

public class TabbedPaneImpl extends WidgetImpl implements TabbedPane{

	public TabbedPaneImpl()
	{
		addAttribute(XmlConstants.XSI_TYPE, "model:TabbedPane");
	}
		
	@Override
	public void setSelected(int  sel) {
		addAttribute(XmlConstants.SELECTED, String.valueOf(sel));		
	}

	@Override
	public void setText(String tabs) {
		addAttribute(XmlConstants.TEXT, tabs);				
	}

	@Override
	public void setPlacement(int p) {
		addAttribute(XmlConstants.POSITION, getPosition(p));
	}
	
	private String getPosition(int placement)
	{
		String pos = "top";
		switch (placement) {
		case JTabbedPane.LEFT:
			pos = "left";
			break;
		case JTabbedPane.BOTTOM:
			pos = "bottom";
			break;
		case JTabbedPane.RIGHT:
			pos = "right";
			break;		
		}
		return pos;
	}

}
