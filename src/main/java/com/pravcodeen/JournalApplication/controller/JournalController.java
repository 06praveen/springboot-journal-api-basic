package com.pravcodeen.JournalApplication.controller;

import com.pravcodeen.JournalApplication.entity.JournalEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/journal")
public class JournalController {

    //A Map is created which stores Long and JournalEntity type of data
    private Map<Long,JournalEntity> journalEntity =new HashMap<>();

    //Get all the data from the Map
    @GetMapping
    public List<JournalEntity> getAll(){
        return new ArrayList<>(journalEntity.values());
    }

    //Post the data on the list
    @PostMapping
    public String createData(@RequestBody JournalEntity myEntity){
        journalEntity.put(myEntity.getId(),myEntity);
        return "Data Saved Successfully";
    }

    //Get specific detail by id
    @GetMapping("id/{myId}")
    public JournalEntity getByID(@PathVariable Long myId){
        return journalEntity.get(myId);
    }

    //Delete specific detail by id
    @DeleteMapping("id/{myId}")
    public JournalEntity deleteById(@PathVariable Long myId){
        return journalEntity.remove(myId);
    }

    //Update specific detail by id
    @PutMapping("id/{myId}")
    public JournalEntity updateById(@PathVariable Long myId,@RequestBody JournalEntity obj){
        return journalEntity.put(myId,obj);
    }
}
