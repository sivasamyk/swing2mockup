package org.swing2mockup.converters;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;

import org.swing2mockup.xml.model.ModelFactory;
import org.swing2mockup.xml.model.Widget;
import org.swing2mockup.xml.model.Window;

public class FrameConverter implements ContainerConverter
{

	@Override
	public Component[] getChildren(Container comp) {
		JFrame frame = ((JFrame)comp);
		if(frame.getJMenuBar() != null)
		{
//			JMenuBar menuBar = frame.getJMenuBar();
//			int menuCount = menuBar.getMenuCount();
//			java.util.List<Component> compList = new ArrayList<Component>();			
//			for(int i=0;i<menuCount;i++)
//			{
//				compList.add(menuBar.getMenu(i));
//			}
//			compList.add(frame.getContentPane());			
			return new Component[]{frame.getJMenuBar(),frame.getContentPane()};
		}
		else
		{			
			return new Component[]{frame.getContentPane()};
		}
	}

	@Override
	public Widget convertComponent(ModelFactory factory, Component comp) {
		Window window = factory.createWindow();
		window.setTitle(((JFrame)comp).getTitle());
		return window;		
	}

}
