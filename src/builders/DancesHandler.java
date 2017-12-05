/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builders;

import generated.Dances.Dance;
import generated.Dancers;
import generated.Music;
import generated.NumberOfDancers;
import generated.Scene;
import generated.Type;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class DancesHandler extends DefaultHandler {

    public static final String ID = "id";
    public static final String DANCERS = "dancers";
    public static final String DANCE = "dance";
    /**
     * Object to initialize
     */
    private Dance currentDance;
    /**
     * Object to initialize
     */
    private Dancers currentDancers;

    private DanceEnum currentEnum;
    private Set<Dance> dances;

    /**
     * Enums that points xsd elements with text
     */
    private EnumSet<DanceEnum> withText;

    /**
     * constructor
     */
    public DancesHandler() {
        this.dances = new HashSet<Dance>();
        this.withText = EnumSet.range(DanceEnum.ID, DanceEnum.NUMBER);
    }

    public Set<Dance> getDances() {
        return dances;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (DANCE.equals(localName)) {
            currentDance = new Dance();
            currentDance.setId(attributes.getValue(ID));
        } else if (DANCERS.equals(localName)) {
            currentDancers = new Dancers();
        } else {
            DanceEnum temp = DanceEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contentHolder = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case DANCE:
                    dances.add(currentDance);
                    break;
                case TYPE:
                    currentDance.setType(Type.fromValue(contentHolder));
                    break;
                case SCENE:
                    currentDance.setScene(Scene.fromValue(contentHolder));
                    break;
                case NUMBEROFDANCERS:
                    currentDance.setNumberOfDancers(NumberOfDancers.fromValue(contentHolder));
                    break;
                case MUSIC:
                    currentDance.setMusic(Music.fromValue(contentHolder));
                    break;
                case NAME:
                    currentDancers.setName(contentHolder);
                    break;
                case AGE:
                    currentDancers.setAge(Integer.valueOf(contentHolder));
                    break;
                case EXPERIENCE:
                    currentDancers.setExperience(Integer.valueOf(contentHolder));
                    break;
                case NUMBER:
                    currentDance.setNumber(Integer.valueOf(contentHolder));
                    break;
                default:
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (DANCE.equals(localName)) {
            dances.add(currentDance);
        } else if (DANCERS.equals(localName)) {
            currentDance.setDancers(currentDancers);
        }
    }

}
