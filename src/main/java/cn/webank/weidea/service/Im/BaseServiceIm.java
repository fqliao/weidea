package cn.webank.weidea.service.Im;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import cn.webank.weidea.service.BaseService;

@Service("baseService")
@Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class BaseServiceIm implements BaseService{

}
