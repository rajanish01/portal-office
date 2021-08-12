package com.epex.office.rest.controller;

import com.epex.office.models.OfficeDTO;
import com.epex.office.rest.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(final OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping("/find")
    @ResponseBody
    public ResponseEntity<?> findoffice(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(officeService.getOffice(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<?> createOffice(@RequestBody @Valid OfficeDTO officeDTO) {
        try {
            return ResponseEntity.ok(officeService.createOffice(officeDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
