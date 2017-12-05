/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import generated.Dances;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;


public class UnMarshalWithXSD {

    public static final String UNMARSHALLER_SEXXED = "UnMarshallerSexxed";
    public static final String XML_FILENAME = "src//xml//dances.xml";
    public static final String SCHEMA_FILENAME = "src//xml//dances.xsd";
    public static final String GENERATED = "generated";

    public static void main(String[] args) {
        JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance(GENERATED);
            Unmarshaller um = jc.createUnmarshaller();
            String schemaName = SCHEMA_FILENAME;
            SchemaFactory factory
                    = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File schemaLocation = new File(schemaName);
            //schema creation and its pass to unmarshaller
            Schema schema = factory.newSchema(schemaLocation);
            um.setSchema(schema);
            Dances dances = (Dances) um.unmarshal(new File(XML_FILENAME));
            System.out.println(UNMARSHALLER_SEXXED);
        } catch (JAXBException ex) {
            Logger.getLogger(UnMarshalWithXSD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(UnMarshalWithXSD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
