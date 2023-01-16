package com.second.hostelDetail.services;

import com.second.hostelDetail.dao.HostelReposotory;
import com.second.hostelDetail.entities.Hostel;
import org.apache.catalina.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class HostelService {
    @Autowired
    private HostelReposotory hostelReposotory;
    public List<Hostel>getAllHostels(){
        List<Hostel>list= (List<Hostel>) this.hostelReposotory.findAll();
        return list;
    }
    public Hostel getHostelById(int id){
        Hostel hostel = null;
        try{
            hostel=this.hostelReposotory.findById(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return hostel;
    }
    public Hostel addHostel(Hostel b){
        Hostel result = hostelReposotory.save(b);
        return result;
    }

    public void  deleteHostel(int bId){
        hostelReposotory.deleteById(bId);
    }
    public void updateHostel(Hostel hostel,int hostelId){
        hostel.setId(hostelId);
        hostelReposotory.save(hostel);
    }
}
