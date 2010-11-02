package org.swing2mockup.converters;

import java.awt.Component;
import java.awt.Container;


/**
 * The converter for all the JContainer classes. 
 *
 */
public interface ContainerConverter extends ComponentConverter {
	
	/**
	 * Children components for the given container
	 * @param comp - container
	 * @return - the children component array.
	 */
	Component[] getChildren(Container comp);
}
