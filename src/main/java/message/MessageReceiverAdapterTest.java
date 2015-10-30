package message;

import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;

/**
 * Created by wzgong on 10/29/2015.
 */
public class MessageReceiverAdapterTest    extends ReceiverAdapter

    {
    public void receive(Message msg) {
//        MessageBody messageBody = (MessageBody) msg.getObject();
//        sf.getCache().evictQueryRegion("userCache");
        System.out.println(msg.getSrc() + " student: " + msg.getObject());
        System.out.println(msg);

    }

        public void viewAccepted(View view) {
            System.out.println(view.getMembers().size());
            System.out.println(view.getViewId());
        }




}
