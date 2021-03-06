package com.example.vayfeed.entity.user;

import com.example.vayfeed.entity.news.NewsFeed;
import com.example.vayfeed.entity.news.NewsPiece;
import com.example.vayfeed.entity.weather.WeatherInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Document(collection = "users")
@Getter @Setter @NoArgsConstructor
public class User implements UserDetails {

    @Id
    private String username;

    private String password;

    private Boolean enabled;

    private List<Authority> authorities;

    private UserParams userParams;

    private List<WeatherInfo> weatherInfos;

    private List<NewsPiece> newsFeed;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
