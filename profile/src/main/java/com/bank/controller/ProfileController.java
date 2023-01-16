package com.bank.controller;

import com.bank.dto.ProfileDto;
import com.bank.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ao")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/save")
    public ResponseEntity<ProfileDto> save(@RequestBody ProfileDto dto) {
        int x = 5;
        return ResponseEntity.ok(profileService.save(dto));
    }

}
