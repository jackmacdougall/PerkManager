package application.service;

import application.model.Limitation;
import application.model.Perk;

public interface LimitationService {
    void save(Limitation limitation);
    void addLimitations(String data, Perk perk);
}
