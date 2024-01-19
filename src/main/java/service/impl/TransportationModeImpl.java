package service.impl;

import bin.TransportationModes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.xml.sax.SAXException;
import service.TransportationMode;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class TransportationModeImpl implements TransportationMode {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(TransportationModeImpl.class);
    @Override
    public void addTransportation() {
        try {
            File file = new File("src/main/resources/transportationmodes.xml");
            File xsdFile = new File("src/main/resources/vehicle.xsd");
            JAXBContext jaxbContext = JAXBContext.newInstance(bin.TransportationModes.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            TransportationModes transportationModesObj=(TransportationModes) jaxbUnmarshaller.unmarshal(file);
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema vehicleSchema = sf.newSchema(xsdFile);
            jaxbUnmarshaller.setSchema(vehicleSchema);
            LOGGER.info("Transportation Modes"+transportationModesObj);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
