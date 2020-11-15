package application.security;

import application.model.Profile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class ProfileDetails implements UserDetails {
    private Profile profile;

    public ProfileDetails(Profile profile){
        this.profile = profile;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(profile.getRole());
        return Arrays.asList(authority);
    }

    @Override
    public String getUsername() {
        return profile.getUsername();
    }

    @Override
    public String getPassword() {
        return profile.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
