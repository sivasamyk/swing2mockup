package org.swing2mockup.converters;

import java.awt.Component;
import java.awt.Container;

import org.swing2mockup.xml.model.ModelFactory;
import org.swing2mockup.xml.model.Widget;
/**
 * This handles the classes that directly extends JComponent, but not for normal 
 * components like JTextField etc..
 *
 */
public class JComponentConverter implements ContainerConverter {

	@Override
	public Component[] getChildren(Container comp) {		
		return comp.getComponents();
	}

	@Override
	public Widget convertComponent(ModelFactory factory, Component comp) {
		org.swing2mockup.xml.model.Component area = factory.createComponent();
		return area;				
	}

}
