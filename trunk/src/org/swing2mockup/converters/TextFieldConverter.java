package org.swing2mockup.converters;

import javax.swing.JTextField;

import org.swing2mockup.xml.model.TextField;

public class TextFieldConverter implements ComponentConverter<JTextField> {

	@Override
	public org.swing2mockup.xml.model.Widget convertComponent(
			org.swing2mockup.xml.model.ModelFactory factory, JTextField comp) {
		TextField tf = factory.createTextField();
		tf.setEnabled(comp.isEnabled());
		//ComponentUtil.applyFont(tf, comp);
		tf.setText(comp.getText());
		return tf;
	}

}
