package org.swing2mockup.converters;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JSplitPane;

import org.swing2mockup.xml.model.ModelFactory;
import org.swing2mockup.xml.model.SplitPane;
import org.swing2mockup.xml.model.Widget;

public class SplitPaneConverter implements ContainerConverter {

	@Override
	public Component[] getChildren(Container comp) {
		JSplitPane sp = (JSplitPane)comp; 
		return new Component[]{sp.getLeftComponent(),sp.getRightComponent()};
	}

	@Override
	public Widget convertComponent(ModelFactory factory, Component comp) {
		SplitPane sp = factory.createSplitPane();
		JSplitPane pane = (JSplitPane)comp; 
		sp.setOrientation(pane.getOrientation());
		return sp;
	}

}
