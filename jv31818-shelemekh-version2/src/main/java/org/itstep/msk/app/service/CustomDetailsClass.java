package org.itstep.msk.app.service;

import lombok.*;
import org.graalvm.compiler.lir.CompositeValue;
import org.itstep.msk.app.entity.Customer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;



@Getter
@Setter
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class CustomDetailsClass implements UserDetails {

    private Customer customer;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return  customer.getRole().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_"+ role)).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return customer.getPassword();

    }

    @Override
    public String getUsername() {
        return customer.getName();
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
