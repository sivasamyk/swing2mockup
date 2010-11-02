package org.swing2mockup.converters;

import javax.swing.JList;
import javax.swing.ListModel;

import org.swing2mockup.xml.model.List;
import org.swing2mockup.xml.model.ModelFactory;
import org.swing2mockup.xml.model.Widget;


public class ListConverter implements ComponentConverter<JList> {

	@Override
	public Widget convertComponent(ModelFactory factory, JList comp) {
		List list = factory.createList();
		ListModel model = comp.getModel();
		list.setEnabled(comp.isEnabled());
		StringBuilder content = new StringBuilder();
		for (int i = 0; i < model.getSize(); i++) {
			content.append(model.getElementAt(i).toString());
			content.append('\n');
		}
		list.setText(content.toString());
		if (comp.getSelectedIndex() != -1) {
			list.setSelectedItem((comp.getSelectedIndex()));
		}
		return list;		
	}

}
