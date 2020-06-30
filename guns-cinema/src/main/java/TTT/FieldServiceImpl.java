package TTT;

import com.stylefeng.guns.rest.persistence.model.Field;
import com.stylefeng.guns.rest.persistence.dao.FieldMapper;
import TTT.IFieldService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 放映场次信息表 服务实现类
 * </p>
 *
 * @author 夏先鹏
 * @since 2020-06-30
 */
@Service
public class FieldServiceImpl extends ServiceImpl<FieldMapper, Field> implements IFieldService {

}
