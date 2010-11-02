package org.swing2mockup.converters;

import javax.swing.JCheckBox;

import org.swing2mockup.xml.model.Checkbox;
import org.swing2mockup.xml.model.ModelFactory;
import org.swing2mockup.xml.model.Widget;

public class CheckboxConverter implements ComponentConverter<JCheckBox>{

	@Override
	public Widget convertComponent(ModelFactory factory, JCheckBox comp) {
		Checkbox checkBox = factory.createCheckbox();
		checkBox.setEnabled(comp.isEnabled());
		checkBox.setText(comp.getText());
		checkBox.setSelected(comp.isSelected());
		return checkBox;	
	}

}
