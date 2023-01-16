package com.second.hostelDetail.controllers;

import com.second.hostelDetail.entities.Hostel;
import com.second.hostelDetail.services.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@RestController

public class HostelController {
    @Autowired
    private HostelService hostelService;

    @GetMapping("/hostels")
    public ResponseEntity<List<Hostel>> getHostels() {
        List<Hostel>list=hostelService.getAllHostels();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }
    @GetMapping("/hostels/{id}")
        public ResponseEntity<Hostel> getHostel(@PathVariable("id")int id){
        Hostel hostel=hostelService.getHostelById(id);
        if(hostel==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
        return ResponseEntity.of(Optional.of(hostel));
    }
    @PostMapping("/hostels")
    public ResponseEntity<Hostel> addHostel(@RequestBody Hostel hostel){
        Hostel b = null;
        try{
            b=this.hostelService.addHostel(hostel);
            System.out.println(hostel);
            return ResponseEntity.of(Optional.of(b));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    @DeleteMapping("/hostels/{hostelid}")
    public ResponseEntity<?>deleteHostel(@PathVariable("hostelid")int hostelId){
        try {

                this.hostelService.deleteHostel(hostelId);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping("/hostels/{hostelId}")
    public ResponseEntity<Hostel> updateHostel(@RequestBody Hostel hostel,@PathVariable("hostelId") int hostelId){
        try{
            this.hostelService.updateHostel(hostel,hostelId);
            return ResponseEntity.ok().body(hostel);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
