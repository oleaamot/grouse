package no.kdrs.grouse.service;

import java.util.List;

import no.kdrs.grouse.entity.Kravspec;

public interface IKravspecService {
     List<Kravspec> getAllKravspecs();
     Kravspec getKravspecById(int kravspecId);
     boolean addKravspec(Kravspec kravspec);
     void updateKravspec(Kravspec kravspec);
     void deleteKravspec(int kravspecId);
}
