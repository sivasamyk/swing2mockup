package org.swing2mockup.converters;

import javax.swing.JSpinner;


public class SpinnerConverter implements ComponentConverter<JSpinner>{

//	@Override
//	public Widget convertComponent(ModelFactory factory, JSpinner comp) {
//		Spinner spinner = factory.createSpinner();
//		ComponentUtil.applyState(spinner, comp);
//		spinner.setText(comp.getModel().getValue().toString());
//		return spinner;
//	}

	@Override
	public org.swing2mockup.xml.model.Widget convertComponent(
			org.swing2mockup.xml.model.ModelFactory factory, JSpinner comp) {
		// TODO Auto-generated method stub
		return null;
	}

}
