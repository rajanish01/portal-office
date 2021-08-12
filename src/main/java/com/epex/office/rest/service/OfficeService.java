package com.epex.office.rest.service;

import com.epex.office.models.OfficeDTO;
import com.epex.office.repository.Office;
import com.epex.office.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficeService {

    private final OfficeRepository officeRepository;

    @Autowired
    public OfficeService(final OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public OfficeDTO createOffice(OfficeDTO officeDTO) {
        Office persistedOffice = officeRepository.save(new Office(officeDTO));
        return new OfficeDTO(persistedOffice);
    }

    public OfficeDTO getOffice(Long id) throws Exception {
        Office requestedOffice = officeRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee With Given Id Not Found !"));
        return new OfficeDTO(requestedOffice);
    }

}
