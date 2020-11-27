package application.service;

import application.model.Limitation;
import application.model.Membership;
import application.model.Perk;
import application.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

public interface PerkService {
    Perk addPerk(String perkData) throws Exception;
    void save(Perk perk);
}
