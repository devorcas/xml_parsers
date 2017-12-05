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
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class DancesDomBuilder extends AbstractDancesBuilder {

    private static final String DANCE = "dance";
    private static final String NUMBER = "number";
    private static final String TYPE = "type";
    private static final String SCENE = "scene";
    private static final String NUMBER_OF_DANCERS = "numberOfDancers";
    private static final String MUSIC = "music";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String EXPERIENCE = "experience";
    private static final String AGE = "age";
    /**
     * Set of dance.java to initialize
     */
    private Set<Dance> dances;
    private DocumentBuilder docBuilder;

    /**
     * Constructor
     *
     * @param dances object to initialize
     */
    public DancesDomBuilder(Set<Dance> dances) {
        super(dances);
        this.dances = dances;
    }

    /**
     * Constructor
     */
    public DancesDomBuilder() {
        this.dances = new HashSet<Dance>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DancesDomBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Set<Dance> getDances() {
        return dances;
    }

    @Override
    public void buildSetDances(String fileName) {
        Document doc = null;
        try {
            //parsing XML and creationg tree-look structure
            doc = (Document) docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            //getting list of child elements <dance>
            NodeList dancesList = root.getElementsByTagName(DANCE);
            for (int i = 0; i < dancesList.getLength(); i++) {
                Element danceElement = (Element) dancesList.item(i);
                Dance dance = buildDance(danceElement);
                dances.add(dance);
            }

        } catch (SAXException ex) {
            Logger.getLogger(DancesDomBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DancesDomBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Builds Dance objects
     *
     * @param danceElement
     * @return
     */
    private Dance buildDance(Element danceElement) {
        Dance dance = new Dance();
        //filling Dance object
        dance.setId(danceElement.getAttribute(ID));
        dance.setMusic(Music.fromValue(getElementTextContent(danceElement, MUSIC)));
        dance.setNumberOfDancers(NumberOfDancers.fromValue(getElementTextContent(danceElement, NUMBER_OF_DANCERS)));
        dance.setScene(Scene.fromValue(getElementTextContent(danceElement, SCENE)));
        dance.setType(Type.fromValue(getElementTextContent(danceElement, TYPE)));
        dance.setNumber(Integer.parseInt(getElementTextContent(danceElement, NUMBER)));

        dance.setDancers(buildDancers(danceElement));
        return dance;
    }

    /**
     * Builds Dancers objects
     *
     * @param danceElement
     * @return
     * @throws NumberFormatException
     */
    private Dancers buildDancers(Element danceElement) throws NumberFormatException {
        Dancers dancers = new Dancers();
        //filling Dancers object
        dancers.setAge(Integer.parseInt(getElementTextContent(danceElement, AGE)));
        dancers.setExperience(Integer.parseInt(getElementTextContent(danceElement, EXPERIENCE)));
        dancers.setName(getElementTextContent(danceElement, NAME));
        return dancers;
    }

    /**
     * Gets text content from xsd elements
     *
     * @param element
     * @param elementName
     * @return
     */
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
