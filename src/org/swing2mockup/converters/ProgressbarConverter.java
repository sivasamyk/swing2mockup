package org.swing2mockup.converters;

import javax.swing.JProgressBar;

import org.swing2mockup.xml.model.ProgressBar;

public class ProgressbarConverter implements ComponentConverter<JProgressBar>{

	@Override
	public org.swing2mockup.xml.model.Widget convertComponent(
			org.swing2mockup.xml.model.ModelFactory factory, JProgressBar comp) {
		ProgressBar pBar = factory.createProgressBar();
		pBar.setValue(comp.getValue());
		return pBar;
	}

}
