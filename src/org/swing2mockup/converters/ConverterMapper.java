package org.swing2mockup.converters;

import java.awt.Component;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JTree;


/**
 * Maintains a map of Swing Component Class and the respective converter.
 * The order of the registration in the CONVERTER_MAP, will decide which 
 * converter will be invoked for a given component.
 *
 */
public class ConverterMapper {

	private static final Map<Class,ComponentConverter> CONVERTER_MAP =
		new LinkedHashMap<Class,ComponentConverter>();
	
	static
	{
		CONVERTER_MAP.put(JDialog.class, new DialogConverter());
		CONVERTER_MAP.put(JFrame.class, new FrameConverter());
		CONVERTER_MAP.put(JTextField.class, new TextFieldConverter());
		CONVERTER_MAP.put(JTextArea.class, new TextAreaConverter());
		CONVERTER_MAP.put(JLabel.class, new LabelConverter());
		CONVERTER_MAP.put(JButton.class, new ButtonConverter());
		CONVERTER_MAP.put(JToggleButton.class, new ToggleButtonConverter());
		CONVERTER_MAP.put(JMenuBar.class, new MenuBarConverter());
		CONVERTER_MAP.put(JMenu.class, new MenuConverter());
		CONVERTER_MAP.put(JMenuItem.class, new MenuItemConverter());
		CONVERTER_MAP.put(JComboBox.class, new ComboBoxConverter());
		CONVERTER_MAP.put(JCheckBox.class, new CheckboxConverter());
		CONVERTER_MAP.put(JRadioButton.class, new RadioButtonConverter());
		CONVERTER_MAP.put(JSpinner.class, new SpinnerConverter());
		CONVERTER_MAP.put(JSlider.class, new SliderConverter());
		CONVERTER_MAP.put(JProgressBar.class, new ProgressbarConverter());
		CONVERTER_MAP.put(JList.class, new ListConverter());		
		CONVERTER_MAP.put(JTree.class, new TreeConverter());
		CONVERTER_MAP.put(JTable.class, new TableConverter());
		CONVERTER_MAP.put(JTabbedPane.class, new TabPaneConverter());
		CONVERTER_MAP.put(JSplitPane.class, new SplitPaneConverter());
		CONVERTER_MAP.put(JScrollPane.class, new ScrollPaneConverter());
		CONVERTER_MAP.put(JPanel.class, new PanelConverter());		
		CONVERTER_MAP.put(JComponent.class, new JComponentConverter());		
	}
	
	/**
	 * Loops through component's inheritance hierarchy and returns the converter that 
	 * has the first match in the CONVERTER_MAP
	 * @param comp - the swing component whose converter has to be found
	 * @return - the respective converter for the given component.
	 * For all swing components, the JComponent converter will be returned. 
	 * null if there is no match.
	 */
	public static ComponentConverter getComponentConverter(Component comp)
	{		
		return getComponentConverter(comp.getClass());
	}
	
	private static ComponentConverter getComponentConverter(Class compClass)
	{		
		if(Object.class.getSimpleName().equals(compClass.getSimpleName()))
		{
			return null;
		}
		ComponentConverter converter = CONVERTER_MAP.get(compClass);
		if(converter == null)
		{
			converter = getComponentConverter(compClass.getSuperclass());
		}
		return converter;
	}
}
