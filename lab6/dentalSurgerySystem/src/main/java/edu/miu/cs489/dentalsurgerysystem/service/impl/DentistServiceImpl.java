package edu.miu.cs489.dentalsurgerysystem.service.impl;

import edu.miu.cs489.dentalsurgerysystem.model.Dentist;
import edu.miu.cs489.dentalsurgerysystem.repository.DentistRepository;
import edu.miu.cs489.dentalsurgerysystem.service.DentistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DentistServiceImpl implements DentistService {

    private final DentistRepository dentistRepository;

    @Override
    public Dentist addNewDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public List<Dentist> getAllDentists() {
        return dentistRepository.findAll();
    }

    @Override
    public Dentist getDentistById(Long id) {
        //check for a valid id
        return dentistRepository.findById(id).get();
    }

    @Override
    public Dentist updateDentistById(Long id, Dentist updatedDentist) {
        //check for a valid id
        return dentistRepository.save(updatedDentist);
    }

    @Override
    public void deleteDentistById(Long id) {
        dentistRepository.deleteById(id);
    }
}
