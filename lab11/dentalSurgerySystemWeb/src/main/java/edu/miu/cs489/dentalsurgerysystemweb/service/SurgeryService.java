package edu.miu.cs489.dentalsurgerysystemweb.service;

import edu.miu.cs489.dentalsurgerysystemweb.model.Surgery;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface SurgeryService {
    Surgery addNewSurgery(Surgery surgery);
    List<Surgery> getAllSurgeries();
    Surgery getSurgeryById(Long id) throws EntityNotFoundException;
    Surgery updateSurgeryById(Long id, Surgery updatedSurgery);
    void deleteSurgeryById(Long id);
}
