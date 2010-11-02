package org.swing2mockup.xml.modelimpl.wireframesketcher;

import org.swing2mockup.xml.model.Button;
import org.swing2mockup.xml.model.Checkbox;
import org.swing2mockup.xml.model.Combobox;
import org.swing2mockup.xml.model.Component;
import org.swing2mockup.xml.model.Label;
import org.swing2mockup.xml.model.List;
import org.swing2mockup.xml.model.Menu;
import org.swing2mockup.xml.model.ModelFactory;
import org.swing2mockup.xml.model.Panel;
import org.swing2mockup.xml.model.ProgressBar;
import org.swing2mockup.xml.model.RadioButton;
import org.swing2mockup.xml.model.Screen;
import org.swing2mockup.xml.model.ScrollPane;
import org.swing2mockup.xml.model.Slider;
import org.swing2mockup.xml.model.SplitPane;
import org.swing2mockup.xml.model.TabbedPane;
import org.swing2mockup.xml.model.Table;
import org.swing2mockup.xml.model.TextArea;
import org.swing2mockup.xml.model.TextField;
import org.swing2mockup.xml.model.Tree;
import org.swing2mockup.xml.model.Window;

public class ModelFactoryImpl implements ModelFactory {
	
	@Override
	public Button createButton() {
		return new ButtonImpl();
	}

	@Override
	public Label createLabel() {		
		return new LabelImpl();
	}

	public Window createWindow() { 
		return new WindowImpl();
	}

	@Override
	public Screen createScreen() {		
		return new ScreenImpl();
	}

	@Override
	public Checkbox createCheckbox() {		
		return new CheckboxImpl();
	}

	@Override
	public Combobox createCombobox() {		
		return new ComboboxImpl();
	}

	@Override
	public Menu createMenu() {		
		return new MenuImpl();
	}

	@Override
	public Panel createPanel() {		
		return new PanelImpl();
	}

	@Override
	public ProgressBar createProgressBar() {		
		return new ProgressBarImpl();
	}

	@Override
	public RadioButton createRadioButton() {	
		return new RadiobuttonImpl();
	}

	@Override
	public TabbedPane createTabbedPane() {		
		return new TabbedPaneImpl();
	}

	@Override
	public TextArea createTextArea() {		
		return new TextAreaImpl();
	}

	@Override
	public TextField createTextField() {		
		return new TextFieldImpl();
	}

	@Override
	public Tree createTree() {		
		return new TreeImpl();
	}

	@Override
	public Table createTable() {		
		return new TableImpl();
	}

	@Override
	public ScrollPane createScrollPane() {		
		return new ScrollPaneImpl();
	}

	@Override
	public Component createComponent() { 
		return new ComponentImpl();
	}

	@Override
	public List createList() {	
		return new ListImpl();
	}

	@Override
	public Slider createSlider() {
		return new SliderImpl();
	}

	@Override
	public SplitPane createSplitPane() {
		return new SplitPaneImpl();
	}	
}
