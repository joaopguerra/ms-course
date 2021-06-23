package com.guerra.hruser.specifications;

import com.guerra.hruser.entities.User;
import com.guerra.hruser.entities.User_;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    public static Specification<User> withEmail(String email){
        return (root, query, builder) ->
                builder.equal(root.get(User_.email), email);
    }
}
