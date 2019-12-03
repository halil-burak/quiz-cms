package com.hburak.projects.quizcms.controller;

import com.hburak.projects.quizcms.domain.dto.platform.PlatformCreateDTO;
import com.hburak.projects.quizcms.domain.dto.platform.PlatformLangUpdateDTO;
import com.hburak.projects.quizcms.domain.dto.platform.PlatformUpdateDTO;
import com.hburak.projects.quizcms.service.PlatformService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/platforms")
public class PlatformController {
    private final PlatformService platformService;

    @GetMapping("/listAll")
    public ResponseEntity<?> getPlatforms() {
        return new ResponseEntity<Object>(platformService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/platform/{id}")
    public ResponseEntity<?> getOnePlatform(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<Object>(platformService.getOne(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public Long savePlatform(@RequestBody PlatformCreateDTO platformDTO) {
        return platformService.save(platformDTO);
    }

    @PutMapping("/update/{id]")
    public void updatePlatform(@PathVariable(name = "id") Long id, @RequestBody PlatformUpdateDTO platformUpdateDTO) {
        platformService.update(id, platformUpdateDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePlatform(@PathVariable(name = "id") Long id) {
        platformService.delete(id);
    }

    @PutMapping("/{id}/add-language")
    public void updateLanguagesOfPlatform(@PathVariable(name = "id") Long id, @RequestBody PlatformLangUpdateDTO platformLangUpdateDTO) {
        // todo
    }
}
