package org.swing2mockup.converters;

import javax.swing.JButton;

import org.swing2mockup.xml.model.Button;
import org.swing2mockup.xml.model.ModelFactory;
import org.swing2mockup.xml.model.Widget;

public class ButtonConverter implements ComponentConverter<JButton>{

	@Override
	public Widget convertComponent(ModelFactory factory,JButton comp) {
		Button button = factory.createButton();
		button.setEnabled(comp.isEnabled());
		if (comp.getIcon() != null) {
			button.setIcon(true);
		}
		button.setText(comp.getText());
		return button;
	}

}
