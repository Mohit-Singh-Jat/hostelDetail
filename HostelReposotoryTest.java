package com.second.hostelDetail.dao;

import com.second.hostelDetail.entities.Hostel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HostelRepositoryTest {
    @Autowired
    private HostelReposotory hostelRepository;


 /*   @Test
    void findById() {
        Hostel hostel=new Hostel(1,9630,"basant kunj ");
        hostelRepository.save(hostel);

        Hostel actualResult = hostelRepository.findById(1);
        assertThat(actualResult);
    }*/
 @Test
 public void saveEmployee() {
     Hostel hostel = Hostel.builder()
             .id(1)
             .phone(87654)
             .address("bhunhbchbjc")
             .build();
     hostelRepository.save(hostel);
     Assertions.assertThat(hostel.getId()).isGreaterThan(0);
 }
}