package org.swing2mockup.converters;

import javax.swing.JMenuItem;

import org.swing2mockup.xml.model.Menu;

public class MenuItemConverter implements ComponentConverter<JMenuItem> {

	@Override
	public org.swing2mockup.xml.model.Widget convertComponent(
			org.swing2mockup.xml.model.ModelFactory factory, JMenuItem comp) {
		Menu menu = factory.createMenu();
		menu.setText(comp.getText());
		return menu;
	}

}
