package org.swing2mockup.converters;

import javax.swing.JComboBox;

import org.swing2mockup.xml.model.Combobox;
import org.swing2mockup.xml.model.ModelFactory;
import org.swing2mockup.xml.model.Widget;

public class ComboBoxConverter implements ComponentConverter<JComboBox> 
{
	@Override
	public Widget convertComponent(ModelFactory factory, JComboBox comp)
	{
		Combobox comboBox = factory.createCombobox();
		comboBox.setEnabled(comp.isEnabled());
		comboBox.setText(comp.getSelectedItem().toString());
		return comboBox;		
	}

}
