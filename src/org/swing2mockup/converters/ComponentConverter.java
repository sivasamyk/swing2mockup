package org.swing2mockup.converters;

import java.awt.Component;

import org.swing2mockup.xml.model.ModelFactory;
import org.swing2mockup.xml.model.Widget;

/**
 * Component Converter Interface
 * @param <T> - the swing component class
 */
public interface ComponentConverter<T extends Component> {
	
	/**
	 *  Find the respective WireFrameModel widget and the customize the classes 
	 *  based on the current state of the component
	 * @param factory - WireFrameSketcher Model Factory
	 * @param comp - Swing Component
	 * @return - the WireFrameSketcher model widget.
	 */
	Widget convertComponent(ModelFactory factory,T comp);	
}
