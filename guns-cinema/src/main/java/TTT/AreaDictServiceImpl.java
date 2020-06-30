package TTT;

import com.stylefeng.guns.rest.persistence.model.AreaDict;
import com.stylefeng.guns.rest.persistence.dao.AreaDictMapper;
import TTT.IAreaDictService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 地域字典表 服务实现类
 * </p>
 *
 * @author 夏先鹏
 * @since 2020-06-30
 */
@Service
public class AreaDictServiceImpl extends ServiceImpl<AreaDictMapper, AreaDict> implements IAreaDictService {

}
