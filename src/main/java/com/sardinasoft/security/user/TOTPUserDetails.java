package com.sardinasoft.security.user;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class TOTPUserDetails implements UserDetails {
	private String username;
	private String password;
	private boolean enabled;
	private String secret;
	private Collection authorities = new HashSet<>();
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public String getSecret() {
		return secret;
	}
	public Collection getAuthorities() {
		return authorities;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public TOTPUserDetails(DBUser user) {
	    this.username = user.getUsername();
	    this.password = user.getPassword();
	    this.enabled = user.isEnabled();
	    this.secret = user.getSecret();
	    populateAuthorities(user.getRoles());
	  }
	
	
}
