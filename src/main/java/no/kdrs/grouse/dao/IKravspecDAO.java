package no.kdrs.grouse.dao;

import java.util.List;
import no.kdrs.grouse.entity.Kravspec;

public interface IKravspecDAO {
    List<Kravspec> getAllKravspecs();
    Kravspec getKravspecById(int kravspecId);
    void addKravspec(Kravspec kravspec);
    void updateKravspec(Kravspec kravspec);
    void deleteKravspec(int kravspecId);
    boolean kravspecExists(String title, String category);
}
