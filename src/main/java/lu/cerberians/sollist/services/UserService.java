package lu.cerberians.sollist.services;

import lu.cerberians.sollist.entities.User;
import lu.cerberians.sollist.forms.UserForm;

public interface UserService {
    void deleteAll();
    User saveOrUpdate(UserForm user);
}
