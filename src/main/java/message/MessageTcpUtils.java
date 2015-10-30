package message;

import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.stack.IpAddress;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;

/**
 * Created by wzgong on 10/14/2015.
 */
public class MessageTcpUtils {
    JChannel channel;
    MessageReceiverAdapterTest messageReceiverAdapter = new MessageReceiverAdapterTest();

    private void start() throws Exception {
//        Properties props = System.getProperties(); channel=new JChannel(MessageUtils.class.getResourceAsStream("udp.xml"));
//        props.setProperty("gate.home", "http://gate.ac.uk/wiki/code-repository");
//        props.setProperty("impl.prefix","TwoStacksPlain");
        System.setProperty("java.net.preferIPv4Stack","true");
//        System.setProperty("jgroups.bind_addr","10.104.215.211");
//        System.setProperty("jgroups.bind_addr","46.137.79.238");
//        System.setProperty("jgroups.bind_addr","120.55.82.135");
//        System.setProperty("jgroups.bind_addr","121.43.119.217");
//        channel=new JChannel(MessageTcpUtils.class.getResourceAsStream("/udp.xml")); // 使用默认的配置, udp.xml【YBXIANG:】该文件位于jgroups-x.y.z.Final.jar中。
        channel=new JChannel(MessageUdpUtils.class.getResourceAsStream("/tcp.xml"));// 使用默认的配置, tco.xml【YBXIANG:】该文件位于jgroups-x.y.z.Final.jar中。
        channel.getProtocolStack();
        channel.setReceiver(messageReceiverAdapter);
        channel.connect("ChatCluster");
        eventLoop();

        channel.close();
    }

    private void eventLoop() {

        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

        while(true) {

            try {

                System.out.print("> "); System.out.flush();

                String line=in.readLine().toLowerCase();

                if(line.startsWith("quit") || line.startsWith("exit"))

                    break;



//                Address dest = new    IpAddress( InetAddress.getByName("2001:0:5ef5:79fd:28a7:dbb:f597:282c"), 8700);
//                Address dest = new IpAddress("46.137.79.238:8700");
//                Address dest = new IpAddress("184.72.221.187:8700");
//                Address dest = new IpAddress("120.55.82.135");
//                Address src = new IpAddress("220.248.46.202:8700");
//                Message msg=new Message(dest, null, line);
                Message msg=new Message(null, null, line);


                channel.send(msg);
            }

            catch(Exception e) {
                    e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) throws Exception {
        new MessageTcpUtils().start();
    }
}
