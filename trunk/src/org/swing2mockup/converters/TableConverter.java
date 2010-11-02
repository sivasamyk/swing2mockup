package org.swing2mockup.converters;

import javax.swing.JTable;

import org.swing2mockup.xml.model.Table;

public class TableConverter implements ComponentConverter<JTable> {

	@Override
	public org.swing2mockup.xml.model.Widget convertComponent(
			org.swing2mockup.xml.model.ModelFactory factory, JTable comp) {
		Table table = factory.createTable();
		StringBuilder content = new StringBuilder();
		int colCount = comp.getColumnCount();
		if (colCount > 0) {
			for (int i = 0; i < colCount; i++) {
				content.append(comp.getColumnName(i));
				if (i < colCount - 1)
					content.append(',');
			}
			content.append('\n');
		}

		int rowCount = comp.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				content.append(comp.getValueAt(i, j).toString());
				if (j < colCount - 1)
					content.append(',');
			}
			content.append('\n');
		}

//		table.setHorizontalLines(true);
//		table.setVerticalLines(true);
//		
		table.setText(content.toString());

		if (comp.getSelectedRow() != -1)
			table.setSelectedRow(comp.getSelectedRow()); // +1 for
		// header
		return table;
	}

}
