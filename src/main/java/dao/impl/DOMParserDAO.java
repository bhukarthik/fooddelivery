package dao.impl;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import bin.Ratings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import service.impl.RatingsServiceImpl;

public class DOMParserDAO {
    private String fileName;
    private static final Logger LOGGER = (Logger) LogManager.getLogger(DOMParserDAO.class);
    public DOMParserDAO(String fileName){
        this.fileName=fileName;
    }
    public void parse() throws Exception {
        File inputDataFile = new File(fileName);
        DocumentBuilderFactory dbldrFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = dbldrFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(inputDataFile);
        doc.getDocumentElement().normalize();
        LOGGER.info("Name of the Root element:" + doc.getDocumentElement().getNodeName());

        LOGGER.info("Root element :" + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("ROW");
        LOGGER.info("----------------------------");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            LOGGER.info("\nCurrent Element :" + nNode.getNodeName());

            int ratingId = 0;
            float ratingCode = 0;
            int customerId = 0;
            String customerName = null;
            String restaurantName = null;
            int restaurantId = 0;
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                ratingId = Integer.parseInt(eElement.getElementsByTagName("rating_id").item(0).getTextContent());
                ratingCode = Float.parseFloat(eElement.getElementsByTagName("rating_code").item(0).getTextContent());
                customerId = Integer.parseInt(eElement.getElementsByTagName("customer_id").item(0).getTextContent());
                customerName = eElement.getElementsByTagName("customer_name").item(0).getTextContent();
                restaurantName = eElement.getElementsByTagName("restaurant_name").item(0).getTextContent();
                restaurantId = Integer.parseInt(eElement.getElementsByTagName("restaurant_id").item(0).getTextContent());
                LOGGER.info("Rating ID : " + ratingId);
                LOGGER.info("Rating COde : " + ratingCode);
                LOGGER.info("Customer ID : " + customerId);
                LOGGER.info("Customer Name : " + customerName);
                LOGGER.info("Restaurant Name : " + restaurantName);
                LOGGER.info("Restaurant ID : " + restaurantId);
            }
            Ratings ratingsobj = new Ratings(ratingId, ratingCode, customerId, customerName, restaurantName, restaurantId);
            RatingsServiceImpl ratingsService= new RatingsServiceImpl();
            ratingsService.createRatings(ratingsobj);
        }
    }
}
