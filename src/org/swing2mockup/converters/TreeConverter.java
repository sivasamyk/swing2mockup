package org.swing2mockup.converters;

import javax.swing.JTree;

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
		Tree tree = factory.createTree();
		Object root = comp.getModel().getRoot();
		StringBuilder content = new StringBuilder();
		convertTreeItem(root, content, 0, comp);
		tree.setText(content.toString());
		return tree;
	}

}
