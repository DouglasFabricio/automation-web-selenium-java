package com.company.validation;

import org.apache.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.ValidationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ValidationHelper {

	/**
	 * LOG
	 */
	final static Logger logger = Logger.getLogger(ValidationHelper.class);

	/**
	 * validate if object is null
	 *
	 * @param object
	 * @return
	 * @throws ValidationException
	 * @author caio.ribeiro
	 * @since 28/08/2018
	 */
	public static boolean isObjectNull(final Object object) throws ValidationException {

		if (object == null) {
			throw new ValidationException("Object is null");
		}

		return true;
	}

	public static String getPDFContent(String strURL) {
		String output = "";
		try {
			URL url = new URL(strURL);
			PDDocument document = null;

			try (BufferedInputStream file = new BufferedInputStream(url.openStream())) {
				document = PDDocument.load(file);
				output = new PDFTextStripper().getText(document);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return output;
	}

	/**
	 * Verify PDF content
	 *
	 * @param strURL url file
	 * @param text
	 * @return boolean
	 * @autor Caio Ribeiro
	 */
	public static boolean verifyPDFContent(String strURL, String text, Boolean caseInsensitive) {
		String output ="";
		boolean flag = false;
		try{
			URL url = new URL(strURL);
			BufferedInputStream file = new BufferedInputStream(url.openStream());
			PDDocument document = null;
			try {
				document = PDDocument.load(file);
				output = new PDFTextStripper().getText(document);
				System.out.println(output);
			} finally {
				if (document != null) {
					document.close();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		if(output.contains(text)){
			flag =  true;
		}
		return flag;
	}

	public static boolean verifyPDFContent(String strURL, String text) {
		return verifyPDFContent(strURL, text, false);
	}

	/**
	 * Verify XML content with tagName
	 *
	 * @param strURL
	 * @param tagName
	 * @param textValidation
	 * @return boolean
	 * @autor Weslley Oliveira
	 */
	public static boolean verifyXMLContent(String strURL, String tagName, String textValidation) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File(strURL));
			Element rootElement = document.getDocumentElement();

			if (getString(tagName, rootElement).equals(textValidation))
				return true;

		} catch (ParserConfigurationException | SAXException | IOException e) {
			logger.error(e.getMessage());
		}

		return false;
	}

	/**
	 * getString XML with TagName
	 *
	 * @param tagName
	 * @param element
	 * @return
	 * @autor Weslley Oliveira
	 */
	private static String getString(String tagName, Element element) {
		NodeList list = element.getElementsByTagName(tagName);
		if (list != null && list.getLength() > 0) {
			NodeList subList = list.item(0).getChildNodes();

			if (subList != null && subList.getLength() > 0) {
				return subList.item(0).getNodeValue();
			}
		}

		return null;
	}

}
