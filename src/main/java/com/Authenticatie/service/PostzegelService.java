package com.Authenticatie.service;

import com.Authenticatie.model.Postzegel;
import com.Authenticatie.repository.PostzegelRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostzegelService implements iPostzegelService {

    @Autowired
    private PostzegelRepository postzegelRepository;

    @Override
    public Postzegel postzegelOpslaan(Postzegel postzegel) {
        return postzegelRepository.save(postzegel);
    }

    @Override
    public List<Postzegel> getAllePostzegels() {
        return postzegelRepository.findAll();
    }

    @Override
    public Postzegel getPostzegelById(int id) {
        return postzegelRepository.findById(id).orElse(null);
    }

    @Override
    public void verwijderPostzegel(Postzegel postzegel) {
        this.postzegelRepository.delete(postzegel);
    }
}
