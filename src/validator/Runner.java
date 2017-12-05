
package validator;

import factory.DancesBuilderFactory;
import builders.AbstractDancesBuilder;
import generated.Dances;
import generated.Dances.Dance;
import java.util.Collection;


public class Runner {

    private static final String FILE_NAME = "src//xml//dances.xml";
    private static final String SCHEMA_NAME = "src//xml//dances.xsd";
    public static final String INITIALIZATION_COMPLETED = "Initialization completed";
    public static final String STAX = "stax";
    public static final String DOM = "dom";
    public static final String SAX = "sax";

    public static void main(String[] args) {
        ValidatorSAXXSD validator = new ValidatorSAXXSD(FILE_NAME, SCHEMA_NAME);
        validator.validate();
        build();
    }

    private static void build() {
        DancesBuilderFactory dFactory = new DancesBuilderFactory();

        AbstractDancesBuilder saxBuilder = dFactory.createDancesBuilder(SAX);
        AbstractDancesBuilder domBuilder = dFactory.createDancesBuilder(DOM);
        AbstractDancesBuilder staxBuilder = dFactory.createDancesBuilder(STAX);

        Dances saxDances = new Dances();
        Dances domDances = new Dances();
        Dances staxDances = new Dances();

        Collection<Dance> saxCol = saxDances.getDance();
        Collection<Dance> domCol = domDances.getDance();
        Collection<Dance> staxCol = staxDances.getDance();

        saxBuilder.buildSetDances(FILE_NAME);
        domBuilder.buildSetDances(FILE_NAME);
        staxBuilder.buildSetDances(FILE_NAME);

        saxCol = saxBuilder.getDances();
        domCol = domBuilder.getDances();
        staxCol = staxBuilder.getDances();
        System.out.println(INITIALIZATION_COMPLETED);
    }

}
