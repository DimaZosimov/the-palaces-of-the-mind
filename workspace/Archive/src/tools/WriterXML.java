package tools;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import domain.Student;
import domain.Students;

/**
 * @version 1.0
 * @author Dima Zosimov
 *
 */

public class WriterXML {
	
	public WriterXML() {
	}

	public void write(Students students) {
		if(students == null) {
			System.out.println("Students == null");
			return;
		}
		try {
			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = dFact.newDocumentBuilder();
			Document doc = build.newDocument();
			
			Element root = doc.createElement("Students");
			doc.appendChild(root);
			
			for(Student st : students.getList()) {
				Element student = doc.createElement("student");
				root.appendChild(student);
				
				Attr login = doc.createAttribute("login");
				login.setValue(st.getLogin());
				student.setAttributeNode(login);
				
				Attr faculty = doc.createAttribute("faculty");
				faculty.setValue(st.getFaculty());
				student.setAttributeNode(faculty);
				
				Element name = doc.createElement("name");
				name.appendChild(doc.createTextNode(st.getName()));
				student.appendChild(name);
				
				Element telephone = doc.createElement("telephone");
				telephone.appendChild(doc.createTextNode(String.valueOf(st.getTelephone())));
				student.appendChild(telephone);
				
				Element address = doc.createElement("address");
				student.appendChild(address);
				
				Element country = doc.createElement("country");
				country.appendChild(doc.createTextNode(st.getAddress().getCountry()));
				address.appendChild(country);
				
				Element city = doc.createElement("city");
				city.appendChild(doc.createTextNode(st.getAddress().getCity()));
				address.appendChild(city);
				
				Element street = doc.createElement("street");
				street.appendChild(doc.createTextNode(st.getAddress().getStreet()));
				address.appendChild(street);
			}
			
			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer transformer = transFactory.newTransformer();
			
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			
			DOMSource source = new DOMSource(doc);
						
			FileWriter writer = new FileWriter("src\\data\\studs.xml");
			StreamResult result = new StreamResult(writer);
			
			transformer.transform(source, result);			
			
		} catch (TransformerException e) {
			System.err.println("Error outputting document " + e.getMessage());
		} catch (DOMException e) {
			System.err.println("Error DOMException " + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.err.println("Error " + e.getMessage());
		} catch (ParserConfigurationException e) {
			System.err.println("Error building document " + e.getMessage());
		} catch (IOException e) {
			System.err.println("I/O-error " + e.getMessage());
		} 

	}

}
