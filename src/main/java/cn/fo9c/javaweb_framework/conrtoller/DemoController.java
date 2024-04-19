package cn.fo9c.javaweb_framework.conrtoller;

import cn.fo9c.javaweb_framework.domain.DTO.DemoDTO;
import cn.fo9c.javaweb_framework.domain.PO.DemoPO;
import cn.fo9c.javaweb_framework.domain.Result;
import cn.fo9c.javaweb_framework.domain.VO.DemoVO;
import cn.fo9c.javaweb_framework.mapper.DemoMapper;
import cn.fo9c.javaweb_framework.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 使用RestController注解标记这是一个控制器
@RestController
public class DemoController {
    // 自动注入DemoMapper，实现数据访问
    @Autowired
    private DemoMapper demoMapper;
    @Autowired
    private DemoService demoService;

    @GetMapping("/user")
    public List<DemoPO> getDemoList() {
        return demoMapper.selectList(null);
    }

    @PostMapping("/user/find")
    public Result<DemoVO> findUserByUid(@RequestBody DemoDTO demoDTO) {
        DemoVO demoVO = demoService.getDemoInfoByUid(demoDTO);
        return Result.success("查询成功", demoVO);
    }

}
