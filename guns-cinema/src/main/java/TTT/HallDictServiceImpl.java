package TTT;

import com.stylefeng.guns.rest.persistence.model.HallDict;
import com.stylefeng.guns.rest.persistence.dao.HallDictMapper;
import TTT.IHallDictService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 影厅字典表 服务实现类
 * </p>
 *
 * @author 夏先鹏
 * @since 2020-06-30
 */
@Service
public class HallDictServiceImpl extends ServiceImpl<HallDictMapper, HallDict> implements IHallDictService {

}
