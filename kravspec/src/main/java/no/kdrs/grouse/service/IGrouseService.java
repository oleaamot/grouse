package no.kdrs.grouse.service;

import java.util.List;

import no.kdrs.grouse.entity.Grouse;

public interface IGrouseService {
     List<Grouse> getAllGrouses();
     Grouse getGrouseById(int grouseId);
     boolean addGrouse(Grouse grouse);
     void updateGrouse(Grouse grouse);
     void deleteGrouse(int grouseId);
}
