package org.swing2mockup.converters;

import javax.swing.JToggleButton;

import org.swing2mockup.xml.model.Button;

public class ToggleButtonConverter implements ComponentConverter<JToggleButton>{

	@Override
	public org.swing2mockup.xml.model.Widget convertComponent(
			org.swing2mockup.xml.model.ModelFactory factory, JToggleButton comp) {
		Button button = factory.createButton();
		button.setEnabled(comp.isEnabled());
		if (comp.getIcon() != null) {
			button.setIcon(true);
		}
		button.setText(comp.getText());
		return button;
	}

}
