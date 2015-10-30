package message;

import org.jgroups.JChannel;
import org.jgroups.Message;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by wzgong on 10/14/2015.
 */
public class MessageUdpUtils {
    JChannel channel;
    MessageReceiverAdapterTest messageReceiverAdapter = new MessageReceiverAdapterTest();

    private void start() throws Exception {
//        Properties props = System.getProperties(); channel=new JChannel(MessageUtils.class.getResourceAsStream("udp.xml"));
//        props.setProperty("gate.home", "http://gate.ac.uk/wiki/code-repository");
//        props.setProperty("impl.prefix","TwoStacksPlain");
        System.setProperty("java.net.preferIPv4Stack","true");
        channel=new JChannel(MessageUdpUtils.class.getResourceAsStream("/udp.xml")); // 使用默认的配置, udp.xml【YBXIANG:】该文件位于jgroups-x.y.z.Final.jar中。
//        channel=new JChannel(MessageUtils.class.getResourceAsStream("/tcp.xml"));// 使用默认的配置, tco.xml【YBXIANG:】该文件位于jgroups-x.y.z.Final.jar中。
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


//                Address dest = new IpAddress("184.72.221.187:8700");
//                Address src = new IpAddress("220.248.46.202:8700");
//                Message msg=new Message(dest, null, line);
                Message msg=new Message(null, null, line);


                channel.send(msg);

            }

            catch(Exception e) {

            }

        }

    }

    public static void main(String[] args) throws Exception {
        new MessageUdpUtils().start();
    }
}
