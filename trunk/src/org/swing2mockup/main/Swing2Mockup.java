package org.swing2mockup.main;

import java.awt.AWTEvent;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.util.Arrays;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.swing2mockup.converters.Converter;

/**
 * The main class for WireFrameSketcher Swing Spy plug-in.
 * The shortcut key to export the current window to clip board is 
 * Alt + Shift + F5. Give this class as the main class of the application and pass
 * the actual application main class and its command line parameters as, the command parameters
 * for SwingSpy class.
 */
public class Swing2Mockup {

	public static void main(String args[]) throws Exception {
		if (args.length == 0) {
			System.err
					.println("Please specify the main application class as command line parameter");
		} else {
			addKeyListener();
			Class mainClass = Class.forName(args[0]);
			Method mainMethod = mainClass.getMethod("main", args.getClass());
			Object mainArgs[] = { Arrays.copyOfRange(args, 1, args.length) };
			mainMethod.invoke(null, mainArgs);
		}
	}

	private static void addKeyListener() {
		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
			@Override
			public void eventDispatched(AWTEvent event) {
				KeyEvent keyEvent = (KeyEvent) event;
				if (keyEvent.getKeyCode() == KeyEvent.VK_F5 && 
						keyEvent.isAltDown() && keyEvent.isShiftDown() &&
						keyEvent.getID() == KeyEvent.KEY_PRESSED) {
					Window window = getSelectedWindow(Frame.getWindows());
					convertToWireframeSketcher(window);
				}				
			}

			private void convertToWireframeSketcher(Window window) {
				Converter converter = new Converter(window,new 
						org.swing2mockup.xml.modelimpl.wireframesketcher.ModelFactoryImpl());
				try
				{
				new ExportHandler(converter.getScreen());
				
				JOptionPane.showMessageDialog(window,							
						"Window '"
								+ getWindowTitle(window) 
								+ "' was exported to clipboard in WireframeSketcher XML format. \n"
								+ "Paste it directly into an existing screen or create "
								+ "a new screen and specify the initial XML.",
								"Swing2Mockup",JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.err.println("Cannot export the window :" + e.getMessage());
				}
			}					
		}, AWTEvent.KEY_EVENT_MASK);
	}
	
	private static String getWindowTitle(Window window)
	{
		String title = "<unknown>";
		if(window instanceof JFrame)
		{
			title = ((JFrame)window).getTitle();
		}
		else if(window instanceof JDialog)
		{
			title = ((JDialog)window).getTitle();
		}
		return title;
	}

	private static Window getSelectedWindow(Window[] windows) {
		Window result = null;
		for (int i = 0; i < windows.length; i++) {
			Window window = windows[i];
			if (window.isActive()) {
				result = window;
				break;
			} else {
				Window[] ownedWindows = window.getOwnedWindows();
				if (ownedWindows != null) {
					result = getSelectedWindow(ownedWindows);
				}
			}
		}
		return result;
	}
}
