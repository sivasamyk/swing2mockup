package org.swing2mockup.converters;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JViewport;

import org.swing2mockup.xml.model.Tree;

public class TreeConverter implements ComponentConverter<JTree> {

	private void convertTreeItem(Object item, StringBuilder content,
			int indent, JTree tree) {
		String text = item.toString();
		if (text != null && text.length() > 0) {
			for (int i = 0; i < indent; i++)
				content.append('-');
			content.append(text);
			content.append('\n');
			if (tree.isExpanded(indent)) {
				int count = tree.getModel().getChildCount(item);
				for (int i = 0; i < count; i++)
					convertTreeItem(tree.getModel().getChild(item, i), content,
							indent + 1, tree);
			}
		}
	}

	@Override
	public org.swing2mockup.xml.model.Widget convertComponent(
			org.swing2mockup.xml.model.ModelFactory factory, JTree comp) {
		
		boolean isParentScrollPane = comp.getParent() instanceof JViewport;
		JScrollPane sp = null;
		if(isParentScrollPane)
		{
			sp = (JScrollPane)((JViewport)comp.getParent()).getParent();
		}
		Tree tree = factory.createTree();	
		if (sp.getVerticalScrollBar().isVisible()) {
			tree.setVerticalScrollBar(true);
			//tree.setWidth(sp.getVerticalScrollBar().getWidth());
		}
		Object root = comp.getModel().getRoot();
		StringBuilder content = new StringBuilder();
		convertTreeItem(root, content, 0, comp);
		tree.setText(content.toString());
		return tree;
	}

}
