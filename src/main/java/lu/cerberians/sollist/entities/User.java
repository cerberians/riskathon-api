package lu.cerberians.sollist.entities;

import lombok.Getter;
import lombok.Setter;
import lu.cerberians.sollist.user.UserForm;

@Getter
@Setter
public class User {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;

    public User(UserForm user) {
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.email = user.getEmail();
    }
}
