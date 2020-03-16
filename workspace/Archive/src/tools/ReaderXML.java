package tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import domain.Student;
import domain.Students;

public class ReaderXML {
	
	public ReaderXML() {
		
	}
	
	public Students read() {
		Students students = new Students();
		try {
			File file = new File("src\\data\\studs.xml");
			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = dFact.newDocumentBuilder();
			Document doc = build.parse(file);
			
			Node nodeStudents = doc.getFirstChild();
			
			NodeList list = nodeStudents.getChildNodes();
			
			for(int i = 0; i < list.getLength(); i++) {
				Student st = new Student();
				Node student = list.item(i);
				NamedNodeMap attr = student.getAttributes();
				Node login = attr.getNamedItem("login");
				st.setLogin(login.getTextContent());
				Node faculty = attr.getNamedItem("faculty");
				st.setFaculty(faculty.getTextContent());
				if(student.hasChildNodes()) {
					NodeList elements = student.getChildNodes();
					for(int j = 0; j < elements.getLength(); j++) {
						Node node = elements.item(j);
						if(node.getNodeName().equals("name")) {
							st.setName(node.getTextContent());
						}
						if(node.getNodeName().equals("telephone")) {
							st.setTelephone(Integer.parseInt(node.getTextContent()));
						}
						if(node.getNodeName().equals("address")) {
							NodeList address = node.getChildNodes();
							for(int z = 0; z < address.getLength(); z++) {
								Node addr = address.item(z);
								if(addr.getNodeName().equals("country")) {
									st.getAddress().setCountry(addr.getTextContent());
								}
								if(addr.getNodeName().equals("city")) {
									st.getAddress().setCity(addr.getTextContent());
								}
								if(addr.getNodeName().equals("street")) {
									st.getAddress().setStreet(addr.getTextContent());
								}
							}
						}
					}
				}
				students.add(st);
			}
		} catch (NumberFormatException e) {
			System.err.println("Ошибка преобразование String to int " + e.getMessage());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.err.println("Файл не найден");		
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return students;
	}

}
