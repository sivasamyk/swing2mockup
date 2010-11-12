package org.swing2mockup.converters;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;

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

		boolean isParentScrollPane = comp.getParent() instanceof JViewport;
		JScrollPane sp = null;
		if(isParentScrollPane)
		{
			sp = (JScrollPane)((JViewport)comp.getParent()).getParent();
			if (sp.getVerticalScrollBar().isVisible()) {
				table.setVerticalScrollBar(true);
				table.setWidth(sp.getVerticalScrollBar().getWidth());
			}
		}
		
		
		int rowCount = comp.getRowCount();
		for (int i = 0; i < rowCount; i++) {		
			if(sp != null)
			{
				if(!sp.getVisibleRect().contains(comp.getCellRect(i, 0, true)))
				{
					continue;
				}
			}
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
