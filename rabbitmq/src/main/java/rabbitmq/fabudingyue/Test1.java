package rabbitmq.fabudingyue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import rabbitmq_util.ConnectionFactoryUtil;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @author:huangzhen
 * @create 2020-06-17-14:22
 */
public class Test1 {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory f = ConnectionFactoryUtil.ConnectionFactorys();
        Connection c = f.newConnection();
        Channel ch = c.createChannel();
        ch.exchangeDeclare("logs","fanout");
        while(true){
            System.out.println("输出消息:");
            String msg = new Scanner(System.in).nextLine();
            if("exit".equals(msg)){
                break;
            }
            ch.basicPublish("logs","",null,msg.getBytes("utf-8"));
            System.out.println("消息已经发送"+msg);
        }
        c.close();
    }
}
