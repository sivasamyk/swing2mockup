package org.swing2mockup.converters;

import javax.swing.JMenuBar;

import org.swing2mockup.xml.model.Menu;

public class MenuBarConverter implements ComponentConverter<JMenuBar> {

	@Override
	public org.swing2mockup.xml.model.Widget convertComponent(
			org.swing2mockup.xml.model.ModelFactory factory, JMenuBar comp) {
		Menu menu = factory.createMenu();
		StringBuilder content = new StringBuilder();
		int menuCount = comp.getMenuCount();
		for (int i = 0; i < menuCount; i++) {
			content.append(comp.getMenu(i).getText());
			if (i < menuCount - 1)
				content.append(',');
		}
		menu.setText(content.toString());
		return menu;
	}

}
