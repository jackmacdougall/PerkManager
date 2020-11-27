package application.service;

import application.model.Limitation;
import application.model.Perk;
import application.repository.LimitationRepository;
import application.repository.PerkRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LimitationServiceImpl implements LimitationService {

    @Autowired
    private LimitationRepository repository;

    @Autowired
    private PerkRepository perkRepository;

    @Override
    public void save(Limitation limitation) { repository.save(limitation); }

    @Override
    public List<Limitation> findByPerk(Long perkId) {
        return repository.findByPerkId(perkId);
    }

    @Override
    public void addLimitations(String data, Perk perk) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode fullNode = mapper.readTree(data);
            Limitation[] limitationArray = mapper.convertValue(fullNode.get("limitations"), Limitation[].class);
            for (Limitation limitation : limitationArray) {
                limitation.setPerk(perk);
                save(limitation);
            }
        }  catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
