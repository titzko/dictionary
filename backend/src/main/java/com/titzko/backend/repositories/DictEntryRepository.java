package com.titzko.backend.repositories;

import com.titzko.backend.domain.DictEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DictEntryRepository extends JpaRepository<DictEntry, Long> {
}
