package rabbitmq.jiandanmoshi;

import com.rabbitmq.client.*;
import rabbitmq_util.ConnectionFactoryUtil;

import java.io.IOException;

/**
 * @author:huangzhen
 * @create 2020-06-16-18:33
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        ConnectionFactory f = ConnectionFactoryUtil.ConnectionFactorys();
        //建立连接
        Connection c = f.newConnection();
        //建立信道
        Channel ch = c.createChannel();
        //声明队列,如果该队列已经创建过,则不会重复创建
        ch.queueDeclare("helloworld",false,false,false,null);
        System.out.println("等待接收数据");

        //收到消息后用来处理消息的回调对象
        DeliverCallback callback = new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery message) throws IOException {
                byte[] a = message.getBody();
                String msg = new String(message.getBody(), "UTF-8");
                String threadName = Thread.currentThread().getName();
                System.out.println("收到: "+msg);
                System.out.println(threadName);
            }
        };

        //消费者取消时的回调对象
        CancelCallback cancel = new CancelCallback() {
            @Override
            public void handle(String consumerTag) throws IOException {
            }
        };

        ch.basicConsume("helloworld", true, callback, cancel);
    }
}

