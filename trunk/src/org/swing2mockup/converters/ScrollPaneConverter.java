package org.swing2mockup.converters;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JScrollPane;

public class ScrollPaneConverter implements ContainerConverter {

	@Override
	public Component[] getChildren(Container comp) {		
		return new Component[]{((JScrollPane)comp).getViewport().getView()};
	}

	@Override
	public org.swing2mockup.xml.model.Widget convertComponent(
			org.swing2mockup.xml.model.ModelFactory factory, Component comp) {
//		ScrollPane panel = factory.createScrollPane();
//		panel.setVerticalScrollBar(((JScrollPane)comp).getVerticalScrollBar().isVisible());		
//		return panel;
		//Do not need a seperate component for ScrollPane
		return null;
	}

}
