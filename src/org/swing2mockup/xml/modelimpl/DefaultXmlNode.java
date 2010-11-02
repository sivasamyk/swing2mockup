package org.swing2mockup.xml.modelimpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.swing2mockup.xml.model.XmlNode;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class DefaultXmlNode implements XmlNode {

	private String name;
	private List<XmlNode> children;
	private Map<String, String> attributes;

	public DefaultXmlNode(String name) {
		this.name = name;
		this.attributes = new LinkedHashMap<String, String>();
		this.children = new ArrayList<XmlNode>();
	}

	public void addAttribute(String name, String value) {
		attributes.put(name, value);
	}

	public void addChild(XmlNode child) {
		children.add(child);
	}

	@Override
	public Map<String, String> getAttributes() {
		return attributes;
	}

	@Override
	public List<XmlNode> getChildren() {
		return children;
	}

	@Override
	public String getName() {
		return name;
	}

	
	public Node getXmlNode(Document doc)
	{
		Element node = doc.createElement(name);
		for (String key : attributes.keySet()) {
			String value = attributes.get(key);
			if (value != null) {
				Attr attr = doc.createAttribute(key);	
				attr.setValue(value);
				node.setAttributeNode(attr);
			}
		}
		
		for (XmlNode child : children) {
			node.appendChild(child.getXmlNode(doc));
		}		
		return node;
	}

}
