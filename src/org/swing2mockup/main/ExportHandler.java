package org.swing2mockup.main;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.swing2mockup.xml.model.Screen;
import org.w3c.dom.Document;

/**
 * Export the current screen to clip board in WireframeSketcher XML Format.
 * 
 */
public class ExportHandler {

	public ExportHandler(Screen screen) throws Exception {
		copyToClipboard(convertToString(screen));
	}

	private String convertToString(Screen screen) throws Exception {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		doc.appendChild(screen.getXmlNode(doc));

		TransformerFactory transfac = TransformerFactory.newInstance();
		Transformer trans = null;
		trans = transfac.newTransformer();
		trans.setOutputProperty(OutputKeys.METHOD, "xml");
		trans.setOutputProperty(OutputKeys.VERSION, "1.0");
		trans.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		trans.setOutputProperty(OutputKeys.INDENT, "yes");

		StringWriter sw = new StringWriter();
		StreamResult result = new StreamResult(sw);
		DOMSource source = new DOMSource(doc);
		trans.transform(source, result);
		return sw.toString();
	}

	private void copyToClipboard(String str) {
		Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
		SwingSpyClipboard clipboard = new SwingSpyClipboard(str);
		c.setContents(clipboard, clipboard);
	}

	private class SwingSpyClipboard implements Transferable, ClipboardOwner {
		private String str;

		public SwingSpyClipboard(String str) {
			this.str = str;
		}

		@Override
		public Object getTransferData(DataFlavor flavor)
				throws UnsupportedFlavorException, IOException {
			if (flavor.isFlavorTextType()) {
				return str;
			} else {
				throw new UnsupportedFlavorException(flavor);
			}
		}

		@Override
		public DataFlavor[] getTransferDataFlavors() {
			return new DataFlavor[] { DataFlavor.stringFlavor };
		}

		@Override
		public boolean isDataFlavorSupported(DataFlavor flavor) {
			return flavor.isFlavorTextType();
		}

		@Override
		public void lostOwnership(Clipboard clipboard, Transferable contents) {
			str = null;
		}

	}
}
