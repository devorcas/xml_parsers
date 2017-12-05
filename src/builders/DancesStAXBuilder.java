/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builders;

import generated.Dancers;
import generated.Dances.Dance;
import generated.Music;
import generated.NumberOfDancers;
import generated.Scene;
import generated.Type;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;


public class DancesStAXBuilder extends AbstractDancesBuilder {

    /**
     * unique set of dances
     */
    private final Set<Dance> dances;
    /**
     * XMLFactory
     */
    private XMLInputFactory inputFactory;

    /**
     * constructor
     */
    public DancesStAXBuilder() {
        this.inputFactory = XMLInputFactory.newInstance();
        this.dances = new HashSet<Dance>();
    }

    /**
     * constructor
     *
     * @param dances set of dance objects
     */
    public DancesStAXBuilder(Set<Dance> dances) {
        super(dances);
        this.dances = dances;
    }

    public Set<Dance> getDances() {
        return dances;
    }

    /**
     * Builds set of parsed objects
     *
     * @param fileName path to xml file
     */
    public void buildSetDances(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            //StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (DanceEnum.DANCE == DanceEnum.valueOf(name.toUpperCase())) {
                        Dance dance = buildDance(reader);
                        dances.add(dance);
                    } else {
                    }
                }
            }
        } catch (XMLStreamException ex) {
            Logger.getLogger(DancesStAXBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DancesStAXBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(DancesStAXBuilder.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * Builds dance object
     *
     * @param reader XML reader
     * @return Dance - initialized object
     * @throws XMLStreamException
     */
    private Dance buildDance(XMLStreamReader reader) throws XMLStreamException {
        Dance dance = new Dance();
        dance.setId(reader.getAttributeValue(null, DanceEnum.ID.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (DanceEnum.valueOf(name.toUpperCase())) {
                        case TYPE:
                            dance.setType(Type.fromValue(reader.getElementText()));
                            break;
                        case SCENE:
                            dance.setScene(Scene.fromValue(reader.getElementText()));
                            break;
                        case NUMBEROFDANCERS:
                            dance.setNumberOfDancers(NumberOfDancers.fromValue(reader.getElementText()));
                            break;
                        case MUSIC:
                            dance.setMusic(Music.fromValue(reader.getElementText()));
                            break;
                        case NUMBER:
                            dance.setNumber(Integer.parseInt(reader.getElementText()));
                            break;
                        case DANCERS:
                            dance.setDancers(getXMLDancers(reader));
                            break;
                    }
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (DanceEnum.valueOf(name.toUpperCase()) == DanceEnum.DANCE) {
                        return dance;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Dance");
    }

    /**
     * Builds dancers object
     *
     * @param reader XML reader
     * @return Dancers - initialized object
     * @throws XMLStreamException
     */
    private Dancers getXMLDancers(XMLStreamReader reader) throws XMLStreamException {
        Dancers dancers = new Dancers();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (DanceEnum.valueOf(name.toUpperCase())) {
                        case NAME:
                            dancers.setName(reader.getElementText());
                            break;
                        case AGE:
                            dancers.setAge(Integer.parseInt(reader.getElementText()));
                            break;
                        case EXPERIENCE:
                            dancers.setExperience(Integer.parseInt(reader.getElementText()));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (DanceEnum.valueOf(name.toUpperCase()) == DanceEnum.DANCERS) {
                        return dancers;
                    }
            }

        }
        throw new XMLStreamException("Unknown element in tag Dance");
    }

    /**
     * Getter for text from xml element values
     *
     * @param reader XML reader
     * @return Dancers - initialized object
     * @throws XMLStreamException
     */
    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
