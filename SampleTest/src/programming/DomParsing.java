package programming;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class DomParsing {
	
	public static void main(String args[]){
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse("test.xml");
			
			/* NorMalized Form */
			document.getDocumentElement().normalize();
			
			/* Root Element */
			System.out.print("Root Element..> ");
			System.out.println(document.getDocumentElement().getNodeName());
			
			/* NodeList */
			NodeList nList = document.getElementsByTagName("supercars");
			for (int i = 0; i < nList.getLength(); i++){
				/* Node instance */
				Node nNode = nList.item(i);
				System.out.println("Node values are "+nNode.getNodeName());
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE){
					Element element = (Element) nNode;
					System.out.print("Company Name..> ");
					System.out.println(element.getAttribute("company"));
					
					NodeList subNList = element.getElementsByTagName("carname");
					for (int j = 0; j < subNList.getLength(); j++){
						Node subNNode = subNList.item(j);
						//System.out.println("Node Values are "+subNNode.getNodeName());
						
						if (subNNode.getNodeType() == Node.ELEMENT_NODE){
							Element subElement = (Element) subNNode;
							System.out.print("Car Name..> ");
							System.out.println(subElement.getTextContent());
							System.out.print("Car Type..> ");
							System.out.println(subElement.getAttribute("type"));
						}
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
