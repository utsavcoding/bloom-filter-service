package com.bloomfilter.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This repository is to interact with the database.
 */
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
