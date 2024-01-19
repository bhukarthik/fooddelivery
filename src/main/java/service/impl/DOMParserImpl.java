package service.impl;

import dao.impl.DOMParserDAO;

public class DOMParserImpl {

        public void parseImp() {
                DOMParserDAO domParserDAO = new DOMParserDAO("src/main/resources/rating.xml");
                try {
                        domParserDAO.parse();
                } catch (Exception e) {
                        throw new RuntimeException(e);
                }
        }
}
