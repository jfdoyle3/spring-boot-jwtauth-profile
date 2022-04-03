package com.example.springjwtauth.controllers;

import com.example.springjwtauth.entities.Profile;
import com.example.springjwtauth.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileRepository repository;


    @GetMapping("/all")
    @ResponseBody
    public List<Profile> getEveryone() {
        return repository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Profile> createProfile(@RequestBody Profile newProfile) {
        return new ResponseEntity<>(repository.save(newProfile), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Profile updateProfile(@PathVariable Long id, @RequestBody Profile updates) {
        Profile profile = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getfName() != null) profile.setfName(updates.getfName());
        if (updates.getlName() != null) profile.setlName(updates.getlName());
        if (updates.getTitle() != null) profile.setTitle(updates.getTitle());
        if (updates.getAge() != profile.getAge()) profile.setAge(updates.getAge());
        if (updates.getBio() != null) profile.setBio(updates.getBio());
        if (updates.getRole() != null) profile.setRole(updates.getRole());

        return repository.save(profile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeProfile(@PathVariable Long id){
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }


}
