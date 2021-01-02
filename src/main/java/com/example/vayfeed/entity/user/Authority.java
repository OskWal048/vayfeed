package com.example.vayfeed.entity.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

//@Document(collection = "authorities")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Authority implements GrantedAuthority {

    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }
}
