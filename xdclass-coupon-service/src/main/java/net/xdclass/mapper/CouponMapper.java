package net.xdclass.mapper;

import net.xdclass.model.CouponDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 二当家小D
 * @since 2021-02-07
 */
public interface CouponMapper extends BaseMapper<CouponDO> {

    /**
     * 扣减存储
     * @param couponId
     * @return
     */
    int reduceStock(@Param("couponId") long couponId);
}
