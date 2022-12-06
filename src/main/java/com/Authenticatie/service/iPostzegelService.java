package com.Authenticatie.service;

import com.Authenticatie.model.Postzegel;

import java.util.List;

public interface iPostzegelService {

    public Postzegel postzegelOpslaan(Postzegel postzegel);
    public List<Postzegel> getAllePostzegels();
    public Postzegel getPostzegelById(int id);
    public void verwijderPostzegel(Postzegel postzegel);
}
