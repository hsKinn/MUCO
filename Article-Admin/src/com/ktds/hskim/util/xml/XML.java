package com.ktds.hskim.util.xml;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XML {

	public static String getNodeString(String nodePath) {

		XPathFactory xPathFactory = XPathFactory.newInstance();
		XPath xPath = xPathFactory.newXPath();

		XPathExpression expr = null;
		try {
			expr = xPath.compile(nodePath);
		} catch (XPathExpressionException e) {
			throw new RuntimeException(e);
		}

		if (expr != null) {

			Document doc = null;
			try {

				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				InputStream is = XML.class.getClassLoader().getResource("query.xml").openStream();

				doc = builder.parse(is);
			} catch (SAXException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				throw new RuntimeException(e);
			} catch (ParserConfigurationException e) {
				throw new RuntimeException(e);
			}

			if (doc != null) {
				try {
					Object result = expr.evaluate(doc, XPathConstants.NODESET);

					NodeList nodes = (NodeList) result;
					for (int i = 0; i < nodes.getLength(); i++) {
						Node node = nodes.item(i);
						return node.getNodeValue();
					}
				} catch (XPathExpressionException e) {
					throw new RuntimeException(e);
				}
			}
		}

		return null;
	}

}
