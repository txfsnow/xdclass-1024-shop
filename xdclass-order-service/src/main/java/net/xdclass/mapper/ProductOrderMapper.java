package net.xdclass.mapper;

import net.xdclass.model.ProductOrderDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 二当家小D
 * @since 2021-02-22
 */
public interface ProductOrderMapper extends BaseMapper<ProductOrderDO> {

    /**
     * 更新订单状态
     * @param outTradeNo
     * @param newState
     * @param oldState
     */
    void updateOrderPayState(@Param("outTradeNo") String outTradeNo,@Param("newState") String newState, @Param("oldState") String oldState);
}
