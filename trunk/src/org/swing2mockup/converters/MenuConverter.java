package org.swing2mockup.converters;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JMenu;

import org.swing2mockup.xml.model.Menu;

public class MenuConverter implements ContainerConverter {

	@Override
	public Component[] getChildren(Container comp) {
		JMenu menu = (JMenu)comp;		
		Component comps[] = null;
//		if(menu.isSelected())
//		{
//			int menuCount = menu.getItemCount();
//			java.util.List<Component> compList = new ArrayList<Component>();			
//			for(int i=0;i<menuCount;i++)
//			{
//				compList.add(menu.getItem(i));
//			}
//			comps =  compList.toArray(new Component[10]);
//		}
		return comps;
	}

	@Override
	public org.swing2mockup.xml.model.Widget convertComponent(
			org.swing2mockup.xml.model.ModelFactory factory, Component comp) {
		Menu menu = factory.createMenu();		
		menu.setText(((JMenu)comp).getText());
		return menu;
	}

}
