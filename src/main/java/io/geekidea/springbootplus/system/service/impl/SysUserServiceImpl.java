package io.geekidea.springbootplus.system.service.impl;

import io.geekidea.springbootplus.system.entity.SysUser;
import io.geekidea.springbootplus.system.mapper.SysUserMapper;
import io.geekidea.springbootplus.system.service.SysUserService;
import io.geekidea.springbootplus.system.web.param.SysUserQueryParam;
import io.geekidea.springbootplus.system.web.vo.SysUserQueryVo;
import io.geekidea.springbootplus.common.service.impl.BaseServiceImpl;
import io.geekidea.springbootplus.common.web.vo.Paging;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;


/**
 * <p>
 * SystemUser 服务实现类
 * </p>
 *
 * @author geekidea
 * @since 2019-10-05
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper SysUserMapper;

    @Override
    public SysUserQueryVo getSysUserById(Serializable id) throws Exception {
        return SysUserMapper.getSysUserById(id);
    }

    @Override
    public Paging<SysUserQueryVo> getSysUserPageList(SysUserQueryParam SysUserQueryParam) throws Exception {
        Page page = setPageParam(SysUserQueryParam, OrderItem.desc("create_time"));
        IPage<SysUserQueryVo> iPage = SysUserMapper.getSysUserPageList(page, SysUserQueryParam);
        return new Paging(iPage);
    }

}
