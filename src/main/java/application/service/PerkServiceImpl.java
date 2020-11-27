package application.service;

import application.model.Limitation;
import application.model.Membership;
import application.model.Perk;
import application.model.Product;
import application.repository.PerkRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PerkServiceImpl implements PerkService {

    @Autowired
    private PerkRepository repository;

    @Override
    public void save(Perk perk) { repository.save(perk); }

    @Override
    public List<Perk> findAllPerks() { return repository.findAll(); }

    @Override
    public Perk addPerk(String perkData) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(perkData);
            Membership membership = mapper.convertValue(node.get("membershipObj"), Membership.class);
            Product product = mapper.convertValue(node.get("productObj"), Product.class);
            String description = mapper.convertValue(node.get("description"), String.class);
            Date expiryDate = mapper.convertValue(node.get("expiryDate"), Date.class);
            Perk perk = new Perk(membership, product, description, expiryDate);
            save(perk);
            return perk;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
