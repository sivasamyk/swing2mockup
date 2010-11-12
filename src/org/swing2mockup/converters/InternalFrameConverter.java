package org.swing2mockup.converters;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JInternalFrame;

import org.swing2mockup.xml.model.ModelFactory;
import org.swing2mockup.xml.model.Widget;
import org.swing2mockup.xml.model.Window;

public class InternalFrameConverter implements ContainerConverter {

	@Override
	public Component[] getChildren(Container comp) {
		JInternalFrame frame = ((JInternalFrame) comp);
		return new Component[] { frame.getContentPane() };
	}

	@Override
	public Widget convertComponent(ModelFactory factory, Component comp) {
		Window window = factory.createWindow();
		window.setTitle(((JInternalFrame) comp).getTitle());
		return window;
	}

}
