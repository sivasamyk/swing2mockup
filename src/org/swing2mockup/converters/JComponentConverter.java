package org.swing2mockup.converters;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JComponent;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import org.swing2mockup.xml.model.ModelFactory;
import org.swing2mockup.xml.model.Panel;
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
		//Model JComponent only when it has a border.
		JComponent jComp = (JComponent)comp;
		Border border = jComp.getBorder();
		org.swing2mockup.xml.model.Component area = null;
		if(border != null && !(border instanceof EmptyBorder))
		{
			area = factory.createComponent();			
		}
		return area;				
	}

}
