package com.seeburger.run;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List; 

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.seeburger.algorithms.graphs.Town;

public class RunXmlGraph {
	public static void main(String[] args) {
        String filePath = "C:\\Users\\r.simeonova\\Desktop\\bgmap.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("Town");
            //now XML is loaded as Document in memory, lets convert it to Object List
            List<Town> townList = new ArrayList<Town>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                townList.add(getTown(nodeList.item(i)));
            }
            //lets print Town list information
            for (Town town : townList) {
                System.out.println(town.toString());
            }
        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }

    }


    private static Town getTown(Node node) {
        //XMLReaderDOM domReader = new XMLReaderDOM();
        Town town = new Town();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            town.setName(getTagValue("name", element)); 	
        }

        return town;
    }


    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}
