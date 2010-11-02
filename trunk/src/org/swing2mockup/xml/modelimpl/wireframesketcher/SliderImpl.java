package org.swing2mockup.xml.modelimpl.wireframesketcher;

import javax.swing.JSlider;

import org.swing2mockup.xml.model.Slider;

public class SliderImpl extends WidgetImpl implements Slider {

	@Override
	public void setOrientation(int orientation) {
		String sliderType = JSlider.VERTICAL == orientation ?
				"model:VSlider" : "model:HSlider";
		addAttribute(XmlConstants.XSI_TYPE, sliderType);
	}

	@Override
	public void setValue(int val) {
		addAttribute(XmlConstants.VALUE, String.valueOf(val));
	}

}
