/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builders;

import generated.Dances.Dance;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


public class DancesSAXBuilder extends AbstractDancesBuilder {

    /**
     * Handler for SAX parser
     */
    private DancesHandler dancesHandler;
    /**
     * XML reader
     */
    private XMLReader reader;
    /**
     * Set of dance.java to initialize
     */
    private Set<Dance> dances;

    /**
     * constructor
     *
     * @param dances object to initialize
     */
    public DancesSAXBuilder(Set<Dance> dances) {
        this();
        this.dances = dances;
    }

    /**
     * Constructor
     */
    public DancesSAXBuilder() {
        //creation of SAX analizer
        this.dancesHandler = new DancesHandler();
        try {
            //creation object handler
            this.reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(dancesHandler);
        } catch (SAXException ex) {
            Logger.getLogger(DancesSAXBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Set<Dance> getDances() {
        return dances;
    }

    @Override
    public void buildSetDances(String fileName) {
        try {
            reader.parse(fileName);
        } catch (IOException ex) {
            Logger.getLogger(DancesSAXBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DancesSAXBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        dances = dancesHandler.getDances();
    }
}
