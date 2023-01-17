package com.bank.controller;

import com.bank.dto.ProfileDto;
import com.bank.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/save")
    public ResponseEntity<ProfileDto> save(@RequestBody ProfileDto dto) {
        return ResponseEntity.ok(profileService.save(dto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProfileDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(profileService.findById(id));
    }

    @GetMapping("/getAllById")
    public ResponseEntity<List<ProfileDto>> getAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(profileService.findAllById(ids));
    }

    @PutMapping("/update")
    public ResponseEntity<ProfileDto> update(@RequestBody ProfileDto dto) {
        return ResponseEntity.ok(profileService.save(dto));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProfileDto>> getAll() {
        return ResponseEntity.ok(profileService.findAll());
    }
}
