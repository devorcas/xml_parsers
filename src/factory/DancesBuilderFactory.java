/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import builders.DancesSAXBuilder;
import builders.DancesStAXBuilder;
import builders.AbstractDancesBuilder;
import builders.DancesDomBuilder;

public class DancesBuilderFactory {

    public AbstractDancesBuilder createDancesBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new DancesDomBuilder();
            case SAX:
                return new DancesSAXBuilder();
            case STAX:
                return new DancesStAXBuilder();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }
}
