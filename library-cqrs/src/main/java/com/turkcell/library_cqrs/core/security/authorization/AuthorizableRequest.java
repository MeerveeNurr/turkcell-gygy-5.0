package com.turkcell.library_cqrs.core.security.authorization;

import java.util.List;

public interface AuthorizableRequest {

    List<Role> requiredRoles();
    //Bu classın amacı, bir isteğin hangi rollere sahip kullanıcılar tarafından erişilebileceğini tanımlamaktır. requiredRoles() metodu, bu isteğe erişim izni olan rolleri döndürür. Bu sayede, uygulamanın güvenlik mekanizması, bir isteğin hangi kullanıcılar tarafından erişilebileceğini belirlemek için bu metodu kullanabilir.
}
