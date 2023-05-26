package com.openbootcamp.demospringrest.services;

import com.openbootcamp.demospringrest.models.BootCamper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BootCamperService {
    private final List<BootCamper> bootCampers = new ArrayList<>();

    public List<BootCamper> getAll(){
        return bootCampers;
    }

    public void add(BootCamper bootCamper){
        bootCampers.add(bootCamper);
    }

    public BootCamper get(String nombre){
        for(BootCamper bootcamper : bootCampers){
            if(bootcamper.getNombre().equalsIgnoreCase(nombre)){
                return bootcamper;
            }
        }
        return null;
    }
}
