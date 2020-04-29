package org.k9m.poa.config.security;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Profile({"!local"})
public class MockAuthContext implements AuthContext{

    @Override
    public List<String> getAuthorities() {
        return  Collections.singletonList("mock_role");
    }
}