package cn.fo9c.javaweb_framework.service;

import cn.fo9c.javaweb_framework.domain.DTO.DemoDTO;
import cn.fo9c.javaweb_framework.domain.PO.DemoPO;
import cn.fo9c.javaweb_framework.domain.VO.DemoVO;
import org.springframework.transaction.annotation.Transactional;

// 使用Transactional注解声明这个类的所有方法都需要事务管理,在抛出异常时会回滚
@Transactional
public interface DemoService {
    /**
     * 通过用户Uid查询用户信息
     * @param demoDTO 用户Uid
     * @return 用户信息
     */
    public DemoVO getDemoInfoByUid(DemoDTO demoDTO);
}
