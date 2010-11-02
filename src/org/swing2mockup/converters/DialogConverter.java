package org.swing2mockup.converters;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JDialog;

import org.swing2mockup.xml.model.ModelFactory;
import org.swing2mockup.xml.model.Widget;
import org.swing2mockup.xml.model.Window;


public class DialogConverter implements ContainerConverter {
	@Override
	public Widget convertComponent(ModelFactory factory,Component comp) {
		Window window = factory.createWindow();		
		window.setTitle(((JDialog)comp).getTitle());
		return window;
	}

	@Override	
	public Component[] getChildren(Container comp) {		
		return ((JDialog)comp).getContentPane().getComponents();
	}
}
