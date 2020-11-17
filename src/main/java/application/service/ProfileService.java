package application.service;

import application.model.Profile;
import application.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public void createProfile(Profile profile) { profileRepository.save(profile); }

    public Profile getProfile(String username) { return profileRepository.findByUsername(username); }
}
