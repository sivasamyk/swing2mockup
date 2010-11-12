package org.swing2mockup.converters;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JComponent;
import javax.swing.border.Border;
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
		Panel widget = null;
		JComponent jComp = (JComponent)comp;
		Border border = jComp.getBorder();
		if (border != null && (border instanceof TitledBorder)) {
			widget = factory.createPanel();		
			widget.setTitle(((TitledBorder) jComp.getBorder()).getTitle());
//			if (jComp.getBorder() instanceof TitledBorder) {
//				widget.setTitle(((TitledBorder) jComp.getBorder()).getTitle());
//			} else {				
//				widget.setBorder(true);
//			}			
		}		
		return widget;
	}
}
