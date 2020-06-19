package rabbitmq_util;

import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * @author:huangzhen
 * @create 2020-06-16-18:45
 */
public class ConnectionFactoryUtil {
    public static  ConnectionFactory ConnectionFactorys() throws IOException {
        //连接工厂
        ConnectionFactory f = new ConnectionFactory();
        f.setHost("192.168.64.140");
        f.setUsername("admin");
        f.setPassword("admin");
        return f;
    }
    public void Print(){
        system.out.println("1");
    }
}
