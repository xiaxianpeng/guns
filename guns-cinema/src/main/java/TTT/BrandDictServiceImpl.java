package TTT;

import com.stylefeng.guns.rest.persistence.model.BrandDict;
import com.stylefeng.guns.rest.persistence.dao.BrandDictMapper;
import TTT.IBrandDictService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 品牌信息表 服务实现类
 * </p>
 *
 * @author 夏先鹏
 * @since 2020-06-30
 */
@Service
public class BrandDictServiceImpl extends ServiceImpl<BrandDictMapper, BrandDict> implements IBrandDictService {

}
