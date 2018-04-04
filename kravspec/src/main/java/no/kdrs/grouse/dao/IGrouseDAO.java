package no.kdrs.grouse.dao;

import java.util.List;
import no.kdrs.grouse.entity.Grouse;

public interface IGrouseDAO {
    List<Grouse> getAllGrouses();
    Grouse getGrouseById(int grouseId);
    void addGrouse(Grouse grouse);
    void updateGrouse(Grouse grouse);
    void deleteGrouse(int grouseId);
    boolean grouseExists(String title, String category);
}
