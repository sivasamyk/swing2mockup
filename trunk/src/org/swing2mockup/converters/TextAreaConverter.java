package org.swing2mockup.converters;

import javax.swing.JTextArea;

import org.swing2mockup.xml.model.TextArea;

public class TextAreaConverter implements ComponentConverter<JTextArea> {
	@Override
	public org.swing2mockup.xml.model.Widget convertComponent(
			org.swing2mockup.xml.model.ModelFactory factory, JTextArea comp) {
		TextArea area = factory.createTextArea();
		area.setEnabled(comp.isEnabled());
		area.setText(comp.getText());
		return area;
	}

}
