package TTT;

import com.stylefeng.guns.rest.persistence.model.Cinema;
import com.stylefeng.guns.rest.persistence.dao.CinemaMapper;
import TTT.ICinemaService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 影院表 服务实现类
 * </p>
 *
 * @author 夏先鹏
 * @since 2020-06-30
 */
@Service
public class CinemaServiceImpl extends ServiceImpl<CinemaMapper, Cinema> implements ICinemaService {

}
