package net.xdclass.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.models.auth.In;

import java.math.BigDecimal;
import java.util.List;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

public class CartVO {

    /**
     * 购物项
     */
    @JsonProperty("cart_items")
    private List<CartItemVO> cartItems;


    /**
     * 购买总件数
     */
    @JsonProperty("total_num")
    private Integer totalNum;

    /**
     * 购物车总价格
     */
    @JsonProperty("total_amount")
    private BigDecimal totalAmount;

    /**
     * 购物车实际支付价格
     */
    @JsonProperty("real_pay_amount")
    private BigDecimal realPayAmount;


    /**
     * 总件数
     * @return
     */
    public Integer getTotalNum() {
        if(this.cartItems!=null){
            int total = cartItems.stream().mapToInt(CartItemVO::getBuyNum).sum();
            return total;
        }
        return 0;
    }

    /**
     * 总价格
     * @return
     */
    public BigDecimal getTotalAmount() {
        BigDecimal amount = new BigDecimal("0");
        if(this.cartItems!=null){
            for(CartItemVO cartItemVO : cartItems){
                BigDecimal itemTotalAmount =  cartItemVO.getTotalAmount();
                amount = amount.add(itemTotalAmount);
            }
        }
        return amount;
    }

    /**
     * 购物车里面实际支付的价格
     * @return
     */
    public BigDecimal getRealPayAmount() {
        BigDecimal amount = new BigDecimal("0");
        if(this.cartItems!=null){
            for(CartItemVO cartItemVO : cartItems){
                BigDecimal itemTotalAmount =  cartItemVO.getTotalAmount();
                amount = amount.add(itemTotalAmount);
            }
        }
        return amount;
    }

    public List<CartItemVO> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemVO> cartItems) {
        this.cartItems = cartItems;
    }
}
