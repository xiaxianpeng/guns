package TTT;

import com.stylefeng.guns.rest.persistence.model.HallFilmInfo;
import com.stylefeng.guns.rest.persistence.dao.HallFilmInfoMapper;
import TTT.IHallFilmInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 热映电影字典表 服务实现类
 * </p>
 *
 * @author 夏先鹏
 * @since 2020-06-30
 */
@Service
public class HallFilmInfoServiceImpl extends ServiceImpl<HallFilmInfoMapper, HallFilmInfo> implements IHallFilmInfoService {

}
