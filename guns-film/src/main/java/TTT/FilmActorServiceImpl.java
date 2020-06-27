package TTT;

import com.stylefeng.guns.rest.persistence.model.FilmActor;
import com.stylefeng.guns.rest.persistence.dao.FilmActorMapper;
import TTT.IFilmActorService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 影片演员表 服务实现类
 * </p>
 *
 * @author 夏先鹏
 * @since 2020-06-28
 */
@Service
public class FilmActorServiceImpl extends ServiceImpl<FilmActorMapper, FilmActor> implements IFilmActorService {

}
