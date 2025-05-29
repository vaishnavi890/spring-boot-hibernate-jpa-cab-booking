package com.vaishnavi.jpa.cab.booking.service;

import com.vaishnavi.jpa.cab.booking.model.CabModel;
import java.util.List;

public interface CabService {
    CabModel saveCab(CabModel cab);
    boolean deleteCab(int cabId);

    boolean deleteCab(Long cabId);

    List<CabModel> getAllCabs();
    CabModel getCabById(int cabId);

    CabModel getCabById(Long cabId);
}



