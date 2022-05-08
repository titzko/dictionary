package com.titzko.backend.services;

import com.titzko.backend.domain.DictEntry;
import com.titzko.backend.repositories.DictEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictEntryService {

    @Autowired
    DictEntryRepository dictEntryRepository;

    public Boolean createEntry(DictEntry dictEntry) {
        if(isValidDictEntry(dictEntry)) {
            dictEntryRepository.save(dictEntry);
            return true;
        }
        return false;
    }

    private Boolean isValidDictEntry(DictEntry dictEntry) {
        if(dictEntry.getDescription() != null && !dictEntry.getDescription().isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public List<DictEntry> getEntries() {
        return dictEntryRepository.findAll();
    }

    public Boolean deleteById(Long id) {
        if(dictEntryRepository.findById(id).isPresent()){
            dictEntryRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
