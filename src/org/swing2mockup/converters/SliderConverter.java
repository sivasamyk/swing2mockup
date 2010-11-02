package org.swing2mockup.converters;

import javax.swing.JSlider;

import org.swing2mockup.xml.model.ModelFactory;
import org.swing2mockup.xml.model.Slider;
import org.swing2mockup.xml.model.Widget;

public class SliderConverter implements ComponentConverter<JSlider> {

	@Override
	public Widget convertComponent(ModelFactory factory, JSlider comp) {
		Slider slider = factory.createSlider();
		slider.setEnabled(comp.isEnabled());
		slider.setOrientation(comp.getOrientation());
		slider.setValue(comp.getValue());
		return slider;
	}

}
