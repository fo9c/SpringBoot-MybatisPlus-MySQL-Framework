package cn.fo9c.javaweb_framework.service.Impl;

import cn.fo9c.javaweb_framework.domain.DTO.DemoDTO;
import cn.fo9c.javaweb_framework.domain.PO.DemoPO;
import cn.fo9c.javaweb_framework.domain.VO.DemoVO;
import cn.fo9c.javaweb_framework.mapper.DemoMapper;
import cn.fo9c.javaweb_framework.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoMapper demoMapper;

    @Override
    public DemoVO getDemoInfoByUid(DemoDTO demoDTO) {
        Integer userUid = demoDTO.getUid();
        DemoPO demoPO = demoMapper.selectById(userUid);
        if (demoPO != null) {
            return DemoVO.builder()
                    .uid(demoPO.getUid())
                    .name(demoPO.getName())
                    .age(demoPO.getAge())
                    .build();
        } else {
            return null;
            }
    }
}
