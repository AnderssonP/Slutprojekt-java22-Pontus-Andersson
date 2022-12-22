package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class GetTheWeather {

	public static void getWeather(weatherBean wBean) throws IOException {
		String API_KEY = "8911f83940520278d4cfa9ef72fc4b38";
		String URLtoSend = "http://api.openweathermap.org/data/2.5/weather?q=" + wBean.getCityStr() + ","
				+ wBean.getCountryStr() + "&APPID=" + API_KEY + "&mode=xml&units=metric";

		System.out.println(URLtoSend);

		URL line_api_url = new URL(URLtoSend);

		HttpURLConnection linec = (HttpURLConnection) line_api_url.openConnection();
		linec.setDoInput(true);
		linec.setDoOutput(true);
		linec.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(linec.getInputStream()));

		String inputLine;

		String ApiResponse = "";

		while ((inputLine = in.readLine()) != null) {

			ApiResponse += inputLine;
		}
		in.close();

		System.out.println(ApiResponse);

		Document doc = convertStringToXMLDocument(ApiResponse);

		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

		NodeList nList = doc.getElementsByTagName("clouds");
		NodeList nListTemp = doc.getElementsByTagName("temperature");
		NodeList nListDate = doc.getElementsByTagName("lastupdate");


		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node node = nList.item(temp);
			if (node.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) node;
				String XMLclouds = eElement.getAttribute("name");
				System.out.println(wBean.getCityStr() + " is now a " + XMLclouds);
				wBean.setCloudsStr(XMLclouds);

			}
		}
		for (int temp = 0; temp < nListTemp.getLength(); temp++) {
			Node node = nListTemp.item(temp);
			if (node.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) node;
				String XMLtemp = eElement.getAttribute("value");
				System.out.println(wBean.getCityStr() + " is now a " + XMLtemp);
				wBean.setTempStr(XMLtemp);

			}
		}
		for (int temp = 0; temp < nListTemp.getLength(); temp++) {
			Node node = nListDate.item(temp);
			if (node.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) node;
				String XMLdate = eElement.getAttribute("value");
				System.out.println(wBean.getCityStr() + " is now a " + XMLdate);
				wBean.setDateStr(XMLdate);

			}
		}
	}

	private static Document convertStringToXMLDocument(String xmlString) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
