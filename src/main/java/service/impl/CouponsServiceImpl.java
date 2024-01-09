package service.impl;

import bin.Coupons;
import dao.impl.CouponsDAO;
import service.CouponsService;
import service.CustomersService;

public class CouponsServiceImpl implements CouponsService {
    CouponsDAO couponsDAO = new CouponsDAO();

    @Override
    public void createCoupons(Coupons coupons) {
        couponsDAO.addCoupons(coupons);
    }
}
