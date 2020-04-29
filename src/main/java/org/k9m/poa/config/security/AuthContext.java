package org.k9m.poa.config.security;

import java.util.List;


public interface AuthContext{
    List<String> getAuthorities();
}