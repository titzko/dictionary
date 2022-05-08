package com.titzko.backend.controller;

import com.titzko.backend.domain.DictEntry;
import com.titzko.backend.services.DictEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/dict-entry")
@RestController
public class DictEntryController {

    @Autowired
    DictEntryService dictEntryService;

    @PostMapping (path = "/create")
    public ResponseEntity<String> createDictEntry(@RequestBody DictEntry dictEntry){
        Boolean validEntry = dictEntryService.createEntry(dictEntry);
        if(validEntry) {
            return new ResponseEntity<>("Entry created", HttpStatus.OK);
        }
        return new ResponseEntity<>("Couldnt create entry - Input doesnt fullfill requirements", HttpStatus.OK);
    }

    @GetMapping(path= "/all")
    public ResponseEntity<List<DictEntry>> getEntries(){
        return new ResponseEntity<>(dictEntryService.getEntries(), HttpStatus.OK);
    }

    @DeleteMapping( path="/delete/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable Long id){
        Boolean isDeleted = dictEntryService.deleteById(id);
        if(isDeleted){
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Something went wrong...",HttpStatus.OK);
        }
    }



}
