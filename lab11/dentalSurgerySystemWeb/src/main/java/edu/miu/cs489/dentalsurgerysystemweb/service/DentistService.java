package edu.miu.cs489.dentalsurgerysystemweb.service;

import edu.miu.cs489.dentalsurgerysystemweb.model.Dentist;

import java.util.List;

public interface DentistService {
    Dentist addNewDentist(Dentist dentist);
    List<Dentist> getAllDentists();
    Dentist getDentistById(Long id);
    Dentist updateDentistById(Long id, Dentist updatedDentist);
    void deleteDentistById(Long id);
}
