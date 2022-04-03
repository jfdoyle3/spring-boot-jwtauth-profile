package com.example.springjwtauth.repositories;

import com.example.springjwtauth.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
