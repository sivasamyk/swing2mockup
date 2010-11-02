package org.swing2mockup.converters;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JTabbedPane;

import org.swing2mockup.xml.model.TabbedPane;

public class TabPaneConverter implements ContainerConverter {

	@Override
	public Component[] getChildren(Container comp) {
		JTabbedPane tabPaneComp = (JTabbedPane)comp;
		Component selComp = tabPaneComp.getComponentAt(tabPaneComp.getSelectedIndex());
		return new Component[]{selComp};
	}

	@Override
	public org.swing2mockup.xml.model.Widget convertComponent(
			org.swing2mockup.xml.model.ModelFactory factory, Component comp) {
		TabbedPane tabPane = factory.createTabbedPane();
		JTabbedPane tabPaneComp = (JTabbedPane)comp;
		StringBuilder content = new StringBuilder();
		int tabCount = tabPaneComp.getTabCount();
		for (int i = 0; i < tabCount; i++) {
			content.append(tabPaneComp.getTitleAt(i));
			if (i < tabCount - 1)
				content.append(',');
		}
						
		tabPane.setText(content.toString());
		tabPane.setPlacement((tabPaneComp.getTabPlacement()));
		tabPane.setSelected(tabPaneComp.getSelectedIndex());
		return tabPane;
	}

}
