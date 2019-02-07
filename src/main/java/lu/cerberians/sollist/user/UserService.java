package lu.cerberians.sollist.user;

import lu.cerberians.sollist.entities.User;

public interface UserService {
    void deleteAll();
    User saveOrUpdate(UserForm user);
}
