/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builders;

import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.util.logging.Logger;


public class SAXErrorHandler extends DefaultHandler {

    public static final String VALIDATOR = "validator";

    // creating error logger for package 'validator'
    private Logger logger = Logger.getLogger(VALIDATOR);

    public SAXErrorHandler(String log) throws IOException {

        // file and foratting settings
        //  logger.addHandler(new FileAppender(new SimpleLayout(), log));
    }

    public void wairning(SAXParseException ex) {
        logger.warning(ex.getLineNumber() + "-" + ex.getMessage());
    }

    public void error(SAXParseException ex) {
        //  logger.error(ex.getLineNumber() + "-" + ex.getMessage());
    }

}
