/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;


public class ValidatorSAXXSD {

    private String LANGUAGE = XMLConstants.W3C_XML_SCHEMA_NS_URI;
    private String fileName;// = "src//xml//dances.xml";
    private String schemaName;// = "src//xml//dances.xsd";
    private SchemaFactory factory;// = SchemaFactory.newInstance(language);
    private File schemaLocation;// = new File(schemaName);
    private Schema schema;

    public ValidatorSAXXSD() {
        factory = SchemaFactory.newInstance(LANGUAGE);
    }

    public ValidatorSAXXSD(String fileName, String schemaName) {
        this();
        this.fileName = fileName;
        this.schemaName = schemaName;
        //schema cration
        schemaLocation = new File(schemaName);
        try {
            schema = factory.newSchema(schemaLocation);
        } catch (SAXException ex) {
            Logger.getLogger(ValidatorSAXXSD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void validate() {
        try {
            //validator creation on the schema base
            Validator validator = schema.newValidator();

            //doc check
            Source source = new StreamSource(fileName);
            validator.validate(source);
            System.out.println(fileName + " is valid");
        } catch (SAXException ex) {
            System.out.println("validation " + fileName + " is not valid because "
                    + ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(ValidatorSAXXSD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
