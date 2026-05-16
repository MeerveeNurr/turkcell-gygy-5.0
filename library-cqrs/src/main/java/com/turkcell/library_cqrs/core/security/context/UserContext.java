package com.turkcell.library_cqrs.core.security.context;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.turkcell.library_cqrs.core.security.authorization.Role;

@Component
@RequestScope
public class UserContext {
    private String userId;
    private String email;
    private List<Role> roles;

   public void setUser(String userId,String email,List<Role> roles){
        this.userId=userId;
        this.email=email;
        this.roles=roles;
    }
//yukarıdaki işlemin amacı, kullanıcı bilgilerini tek bir yerde tutarak uygulamanın diğer bölümlerinde bu bilgilere kolayca erişmektir. Bu sayede, kullanıcıya özgü işlemler yaparken veya yetkilendirme kontrolleri gerçekleştirirken bu bilgilere ihtiyaç duyulduğunda, UserContext üzerinden erişilebilir hale gelir.

public void clear() {
        this.userId = null;
        this.email = null;
        this.roles = null;
    }
    // clear() metodu, kullanıcı bilgilerini temizlemek için kullanılır. Bu, genellikle kullanıcı oturumu sona erdiğinde veya kullanıcı bilgilerini sıfırlamak istediğiniz durumlarda çağrılır. clear() metodunu çağırarak, UserContext içindeki kullanıcı bilgilerini null yaparak temizlemiş olursunuz.

    public boolean isAuthenticated() {
        return userId != null;
    }
    // isAuthenticated() metodu, kullanıcının kimlik doğrulamasının yapılıp yapılmadığını kontrol etmek için kullanılır. Eğer userId null değilse, yani kullanıcı bilgileri mevcutsa, bu metod true döner ve kullanıcının kimlik doğrulamasının yapıldığını gösterir. Eğer userId null ise, bu metod false döner ve kullanıcının kimlik doğrulamasının yapılmadığını gösterir.
    
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    

}
