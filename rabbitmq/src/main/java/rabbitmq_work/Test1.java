package rabbitmq_work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import rabbitmq_util.ConnectionFactoryUtil;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @author:huangzhen
 * @create 2020-06-17-9:54
 */
public class Test1 {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory f = ConnectionFactoryUtil.ConnectionFactorys();
        Connection c = f.newConnection();
        Channel ch = c.createChannel();
        ch.queueDeclare("task_queue",true,false,false,null);
        while (true){
            System.out.print("输入消息:");
            String msg = new Scanner(System.in).nextLine();
            if("exit".equals(msg)){
                break;
            }
            ch.basicPublish("","task_queue", MessageProperties.PERSISTENT_TEXT_PLAIN,msg.getBytes());
            System.out.println("消息已发送:"+ msg);
        }
        c.close();
    }
}
