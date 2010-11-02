package org.swing2mockup.converters;

/**
 * Converts the Swing top level window to WireFrameSketcher Screen object.
 */
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;

import javax.swing.JViewport;
import javax.swing.SwingUtilities;

import org.swing2mockup.xml.model.ModelFactory;
import org.swing2mockup.xml.model.Screen;
import org.swing2mockup.xml.model.Widget;
import org.swing2mockup.xml.modelimpl.wireframesketcher.ModelFactoryImpl;

public class Converter {

	private final Window window;
	private final Screen screen;
	private Point origin = new Point(25, 25);
	private final ModelFactory factory;

	public Converter(Window window,ModelFactory factory) {
		this.window = window;
		this.factory = factory;
		this.screen = factory.createScreen();		
		convert(window);
	}

	public Screen getScreen() {
		return screen;
	}

	private void convert(Component comp) {
		
		if (comp == null || !comp.isVisible())
			return;

		Dimension size = comp.getSize();
		if (size.width == 0 || size.height == 0)
			return;

		ComponentConverter compConverter = ConverterMapper
				.getComponentConverter(comp);		
		if (compConverter != null) {
			Widget widget = compConverter.convertComponent(factory, comp);
			add(widget, comp);
			if (compConverter instanceof ContainerConverter) {
				Component children[] = ((ContainerConverter) compConverter)
						.getChildren(((Container) comp));
				if (children != null) {
					for (Component child : children) {
						convert(child);
					}
				}
			}
		}
	}

	private void add(Widget widget, int x, int y, int width, int height) {
		widget.setX(origin.x + x);
		widget.setY(origin.y + y);
		widget.setWidth(width);
		widget.setHeight(height);
		screen.addChild(widget);
	}

	private void add(Widget widget, Component comp) {
		add(widget, comp, 0, 0);
	}

	private void add(Widget widget, Component comp, int dx, int dy) {
		Rectangle bounds = comp.getBounds();
		int x = bounds.x, y = bounds.y;
		Point location = bounds.getLocation();			
		if (!(comp instanceof Window)) {
			SwingUtilities.convertPointToScreen(location, comp.getParent());
		}
		x = location.x;
		y = location.y;
		x -= window.getBounds().x;
		y -= window.getBounds().y;

		x += dx;
		y += dy;

		int width = bounds.width;
		int height = bounds.height;

		if (comp.getParent() instanceof JViewport) {
			width = comp.getParent().getWidth();
			height = comp.getParent().getHeight();
		}

		add(widget, x, y, width - dx, height - dy);
	}

	private void add(Widget widget, Container parent, Rectangle bounds, int dx,
			int dy) {
		Point location = bounds.getLocation();
		SwingUtilities.convertPointToScreen(location,parent);
		int x = location.x;
		int y = location.y;
		x -= window.getBounds().x;
		y -= window.getBounds().y;

		add(widget, x + dx, y + dy, bounds.width - dx, bounds.height - dy);
	}

}
