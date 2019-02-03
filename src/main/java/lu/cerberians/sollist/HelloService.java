package lu.cerberians.sollist;

import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.UUID;

@Service
public class HelloService {

    private HelloMapper helloMapper;

    @Inject
    public HelloService(HelloMapper helloMapper) {
        this.helloMapper = helloMapper;
    }

    public void createNode() {
        helloMapper.createNode(UUID.randomUUID().toString());
    }

}
