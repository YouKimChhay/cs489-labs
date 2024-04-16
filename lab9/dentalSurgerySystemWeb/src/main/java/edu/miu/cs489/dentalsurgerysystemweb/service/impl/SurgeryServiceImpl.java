package edu.miu.cs489.dentalsurgerysystemweb.service.impl;

import edu.miu.cs489.dentalsurgerysystemweb.model.Surgery;
import edu.miu.cs489.dentalsurgerysystemweb.repository.SurgeryRepository;
import edu.miu.cs489.dentalsurgerysystemweb.service.SurgeryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SurgeryServiceImpl implements SurgeryService {

    private final SurgeryRepository surgeryRepository;

    @Override
    public Surgery addNewSurgery(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }

    @Override
    public List<Surgery> getAllSurgeries() {
        return surgeryRepository.findAll();
    }

    @Override
    public Surgery getSurgeryById(Long id) throws EntityNotFoundException {
        return surgeryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Surgery id "+ id + " not found."));
    }

    @Override
    public Surgery updateSurgeryById(Long id, Surgery updatedSurgery) {
        //check for a valid id
        return surgeryRepository.save(updatedSurgery);
    }

    @Override
    public void deleteSurgeryById(Long id) {
        surgeryRepository.deleteById(id);
    }
}
