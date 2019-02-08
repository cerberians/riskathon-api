package lu.cerberians.sollist.discrepancy;

import lu.cerberians.sollist.entities.Loop;
import lu.cerberians.sollist.mapper.LoopMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class DiscrepancyService {

    private LoopMapper loopMapper;

    @Inject
    public DiscrepancyService(LoopMapper loopMapper) {
        this.loopMapper = loopMapper;
    }

    public List<Loop> getDiscrepancies(){
        List<Loop> ok = loopMapper.whitelist();
        List<Loop> nok = loopMapper.blacklist();
        nok.removeAll(ok);
        return nok;
    }

    public void fixDiscrepancies(Loop loop) {
        loopMapper.fixDiscrepancies(loop);
    }
}
