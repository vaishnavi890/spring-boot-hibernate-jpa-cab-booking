package com.vaishnavi.jpa.cab.booking.service.impl;

import com.vaishnavi.jpa.cab.booking.domain.Cab;
import com.vaishnavi.jpa.cab.booking.model.CabModel;
import com.vaishnavi.jpa.cab.booking.repository.CabRepository;
import com.vaishnavi.jpa.cab.booking.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("cabService")
public class CabServiceImpl implements CabService {

    @Autowired
    private CabRepository cabRepository;

    @Override
    public CabModel saveCab(CabModel model) {
        Cab cab = populateCabEntity(model);
        return populateCabModel(cabRepository.save(cab));
    }

    @Override
    public boolean deleteCab(Long cabId) {
        cabRepository.deleteById(cabId);
        return true;
    }

    @Override
    public List<CabModel> getAllCabs() {
        List<CabModel> models = new ArrayList<>();
        cabRepository.findAll().forEach(cab -> models.add(populateCabModel(cab)));
        return models;
    }

    @Override
    public CabModel getCabById(Long cabId) {
        return populateCabModel(cabRepository.findById(cabId)
                .orElseThrow(() -> new EntityNotFoundException("Cab not found")));
    }

    private CabModel populateCabModel(Cab cab) {
        CabModel model = new CabModel();
        model.setId(cab.getId());
        model.setDriverId(cab.getDriverId());
        model.setModel(cab.getModel());
        model.setLicensePlate(cab.getLicensePlate());
        return model;
    }

    private Cab populateCabEntity(CabModel model) {
        Cab cab = new Cab();
        cab.setDriverId(model.getDriverId());
        cab.setModel(model.getModel());
        cab.setLicensePlate(model.getLicensePlate());
        return cab;
    }
}


