package org.swing2mockup.xml.model;

import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public interface XmlNode {
	List<XmlNode> getChildren();
	Map<String,String> getAttributes();
	String getName();
	String getValue();
	void addAttribute(String name,String value);
	void addChild(XmlNode child);
	Node getXmlNode(Document doc);	
}
