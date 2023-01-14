package net.xdclass.mq;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import net.xdclass.model.OrderMessage;
import net.xdclass.service.ProductOrderService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

@Slf4j
@Component
@RabbitListener(queues = "${mqconfig.order_close_queue}")
public class ProductOrderMQListener {

    @Autowired
    private ProductOrderService productOrderService;


    /**
     *
     * 消费重复消息，幂等性保证
     * 并发情况下如何保证安全
     *
     * @param orderMessage
     * @param message
     * @param channel
     * @throws IOException
     */
    @RabbitHandler
    public void closeProductOrder(OrderMessage orderMessage, Message message, Channel channel) throws IOException {
        log.info("监听到消息：closeProductOrder:{}",orderMessage);
        long msgTag = message.getMessageProperties().getDeliveryTag();


        try{

            boolean flag = productOrderService.closeProductOrder(orderMessage);
            if(flag){
                channel.basicAck(msgTag,false);
            }else {
                channel.basicReject(msgTag,true);
            }

        }catch (IOException e){
            log.error("定时关单失败:",orderMessage);
            channel.basicReject(msgTag,true);
        }

    }

}
