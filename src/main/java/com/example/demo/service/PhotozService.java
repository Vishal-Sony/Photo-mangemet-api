package com.example.demo.service;

import com.example.demo.model.Photo;
import com.example.demo.repository.PhototzRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PhotozService {

    private final PhototzRepository phototzRepository;

    public PhotozService(PhototzRepository phototzRepository){
        this.phototzRepository=phototzRepository;
    }
    public Iterable<Photo> get() {
        return phototzRepository.findAll();
    }

    public Photo get(Integer id) {
            return phototzRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        phototzRepository.deleteById(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo=new Photo();

        photo.setFileName(fileName);
        photo.setData(data);
        photo.setContentType(contentType);
        phototzRepository.save(photo);
        return photo;
    }
}
