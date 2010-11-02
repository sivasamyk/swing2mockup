package org.swing2mockup.xml.model;


public interface ModelFactory {
	Button createButton();	
	Label createLabel();	
	Window createWindow();	
	Screen createScreen();
	TextField createTextField();
	TextArea createTextArea();
	ProgressBar createProgressBar();
	RadioButton createRadioButton();
	Checkbox createCheckbox();
	TabbedPane createTabbedPane();
	Menu createMenu();
	Combobox createCombobox();
	Panel createPanel();
	Tree createTree();
	Table createTable();
	ScrollPane createScrollPane();
	Component createComponent();
	List createList();
	Slider createSlider();
	SplitPane createSplitPane();
}
