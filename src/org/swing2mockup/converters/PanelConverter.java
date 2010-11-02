package org.swing2mockup.converters;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JComponent;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.swing2mockup.xml.model.Panel;

public class PanelConverter implements ContainerConverter {

	@Override
	public Component[] getChildren(Container comp) { 
		return comp.getComponents();
	}

	@Override
	public org.swing2mockup.xml.model.Widget convertComponent(
			org.swing2mockup.xml.model.ModelFactory factory, Component comp) {
		Panel widget = factory.createPanel();
		JComponent jComp = (JComponent)comp;
		if(jComp.getBorder() instanceof TitledBorder)
		{			
			widget.setTitle(((TitledBorder)jComp.getBorder()).getTitle());
		}
		else
		{		
			Border border = ((JComponent)comp).getBorder();
			widget.setBorder(border != null && !(border instanceof EmptyBorder));
		}
		return widget;
	}
}
