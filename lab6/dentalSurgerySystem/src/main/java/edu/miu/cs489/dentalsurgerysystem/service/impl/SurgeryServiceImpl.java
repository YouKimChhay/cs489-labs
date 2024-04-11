package edu.miu.cs489.dentalsurgerysystem.service.impl;

import edu.miu.cs489.dentalsurgerysystem.model.Surgery;
import edu.miu.cs489.dentalsurgerysystem.repository.SurgeryRepository;
import edu.miu.cs489.dentalsurgerysystem.service.SurgeryService;
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
    public Surgery getSurgeryById(Long id) {
        //check for a valid id
        return surgeryRepository.findById(id).get();
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
