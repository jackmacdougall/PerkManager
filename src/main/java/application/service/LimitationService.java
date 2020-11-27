package application.service;

import application.model.Limitation;
import application.model.Perk;

import java.util.List;

public interface LimitationService {
    void save(Limitation limitation);
    void addLimitations(String data, Perk perk);
    List<Limitation> findByPerk(Long id);
}
