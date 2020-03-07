package com.mec.util;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public abstract class XMLParse {
	private static DocumentBuilderFactory dbf;
	private static DocumentBuilder db;
	
	static {
		try {
			dbf = DocumentBuilderFactory.newInstance();
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	public XMLParse() {
		
	}
	
	public static Document getDocument(String XMLPath) {
		InputStream is = XMLParse.class.getResourceAsStream(XMLPath);
		if (is == null) {
			System.out.println("文件路径["+ XMLPath + "]不存在");
			return null;
		}
		return getDocument(is);
	}
	
	private static Document getDocument(InputStream is) {
		Document document = null;
		try {
			document = db.parse(is);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return document;
	}
	
	public void parseTagByDocument(Document document, String tagName) {
		NodeList elements = document.getElementsByTagName(tagName);
		for (int index = 0; index < elements.getLength(); ++index) {
			Element element = (Element) elements.item(index);
			dealElement(element, index);
		}
	}
	
	public void parseTagByElement(Element element, String tagName) {
		NodeList elements = element.getElementsByTagName(tagName);
		for (int index = 0; index < elements.getLength(); ++index) {
			Element ele = (Element) elements.item(index);
			dealElement(ele, index);
		}
	}

	public void parseRoot(Document document) {
		Element element = (Element) document.getChildNodes().item(0);
		dealElement(element, 0);
	}

	public void parseElement(Element element) {
		NodeList elements = element.getChildNodes();
		for (int index =0; index < elements.getLength(); ++index) {
			Node node = elements.item(index);
			if (node instanceof Element) {
				dealElement((Element)node, index);
			}
		}
	}
	
	public abstract void dealElement(Element element, int index);
	
}
