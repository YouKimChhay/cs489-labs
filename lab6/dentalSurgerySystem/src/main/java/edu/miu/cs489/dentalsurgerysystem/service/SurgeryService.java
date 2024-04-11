package edu.miu.cs489.dentalsurgerysystem.service;

import edu.miu.cs489.dentalsurgerysystem.model.Surgery;

import java.util.List;

public interface SurgeryService {
    Surgery addNewSurgery(Surgery surgery);
    List<Surgery> getAllSurgeries();
    Surgery getSurgeryById(Long id);
    Surgery updateSurgeryById(Long id, Surgery updatedSurgery);
    void deleteSurgeryById(Long id);
}
