package rabbitmq.fabudingyue;

import com.rabbitmq.client.*;
import rabbitmq_util.ConnectionFactoryUtil;

import java.io.IOException;

/**
 * @author:huangzhen
 * @create 2020-06-17-14:33
 */
public class Test2 {
    public static void main(String[] args)throws Exception {
        ConnectionFactory f = ConnectionFactoryUtil.ConnectionFactorys();
        Channel ch = f.newConnection().createChannel();
        ch.exchangeDeclare("logs","fanout");
        String queue = ch.queueDeclare().getQueue();
        ch.queueBind(queue,"logs","");

        DeliverCallback callback = new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery message) throws IOException {
                String msg = new String(message.getBody(), "UTF-8");
                System.out.println("收到: "+msg);
            }
        };
        CancelCallback cancel = new CancelCallback() {
            @Override
            public void handle(String consumerTag) throws IOException {

            }
        };
        ch.basicConsume(queue,true,callback,cancel);
    }
}
