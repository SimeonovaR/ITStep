package com.seeburger.run;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.seeburger.algorithms.graphs.Graph;
import com.seeburger.algorithms.graphs.Road;
import com.seeburger.algorithms.graphs.Town;
import com.seeburger.exceptions.DestinationReachedException;

public class RunXmlGraph {
	public static void main(String[] args) {
        File xmlFile = new File("bgmap.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("Road");
            //now XML is loaded as Document in memory, lets convert it to Object List
            List<Road> roadList = new ArrayList<Road>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                roadList.add(getRoad(nodeList.item(i)));
            }
            //lets print Road list information
            for (Road road : roadList) {
                System.out.println(road.toString());
            }

            Town startTown = roadList.get(0).getTown1();
            for (Road road : startTown.getConnections()) {
                System.out.println(road.toString());
            }
            /*Town destTown = townList.get(6);
            Graph graph = new Graph(startTown, destTown, townList);
            graph.breadthFirstSearch();
            System.out.println();
            startTown = townList.get(1);
            destTown = townList.get(5);
            Graph graph1 = new Graph(startTown, destTown, townList);
            try {
				graph1.depthFirstSearch();
			} catch (DestinationReachedException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} */
          
        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }
        
    }

    private static Road getRoad(Node node) {
        Town town1 = new Town();
        Town town2 = new Town();
        Double distance = 0.0;
     
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            town1.setName(getTagValue("start", element));
            town2.setName(getTagValue("destination", element));
            distance = Double.parseDouble(getAttrValue("distance", element)); 
        }	

        return new Road(town1, town2, distance);
    }

    private static String getAttrValue(String attr, Element element) {
    	String distance = element.getAttribute("distance");
        return distance;
    }
    
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}