package service.impl;

import bin.Ratings;
import dao.impl.RatingsDAO;
import service.RatingsService;

public class RatingsServiceImpl implements RatingsService {

    RatingsDAO ratingsDAO = new RatingsDAO();
    @Override
    public void createRatings(Ratings ratings) {
        ratingsDAO.addRatings(ratings);
    }
}
