package lu.cerberians.sollist.user;

import lu.cerberians.sollist.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    public void deleteAll(){
        //userRepository.deleteAll();
        log.debug("Neo4j reinitialized");
    }

    @Override
    public User saveOrUpdate(UserForm user) {
        User u = new User(user);
        return /*serRepository.save(u)*/u;
    }
}