package com.second.hostelDetail.dao;

import com.second.hostelDetail.entities.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostelReposotory extends JpaRepository<Hostel,Integer> {
    public Hostel findById(int id);
}
