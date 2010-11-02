package org.swing2mockup.converters;

import javax.swing.JLabel;

import org.swing2mockup.xml.model.Label;
import org.swing2mockup.xml.model.ModelFactory;
import org.swing2mockup.xml.model.Widget;

public class LabelConverter implements ComponentConverter<JLabel> {
	@Override
	public Widget convertComponent(ModelFactory factory, JLabel comp) {
		Label label = factory.createLabel();
		if (comp.getIcon() != null) {
			label.setIcon(true);
		}
//		ComponentUtil.applyFont(label, comp);
		label.setTextAlignment(comp.getHorizontalAlignment());
		label.setText(comp.getText());
		return label;
	}
}
