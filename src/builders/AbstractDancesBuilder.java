/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builders;

import generated.Dances.Dance;
import java.util.HashSet;
import java.util.Set;


public abstract class AbstractDancesBuilder {

    /**
     * Set of dance.java to initialize
     */
    protected Set<Dance> dances;

    /**
     * Constructor
     */
    public AbstractDancesBuilder() {
        dances = new HashSet<Dance>();
    }

    /**
     * constructor
     *
     * @param dances object to initialize
     */
    public AbstractDancesBuilder(Set<Dance> dances) {
        this.dances = dances;
    }

    public Set<Dance> getDances() {
        return dances;
    }

    /**
     * Method for building set of dances
     *
     * @param fileName path to xml file
     */
    abstract public void buildSetDances(String fileName);
}
