package org.swing2mockup.converters;

import javax.swing.JRadioButton;

import org.swing2mockup.xml.model.RadioButton;

public class RadioButtonConverter implements ComponentConverter<JRadioButton>{

	@Override
	public org.swing2mockup.xml.model.Widget convertComponent(
			org.swing2mockup.xml.model.ModelFactory factory, JRadioButton comp) {
		RadioButton rButton = factory.createRadioButton();
		rButton.setEnabled(comp.isEnabled());
		rButton.setText(comp.getText());
		rButton.setSelected(comp.isSelected());
		return rButton;		
	}

}
