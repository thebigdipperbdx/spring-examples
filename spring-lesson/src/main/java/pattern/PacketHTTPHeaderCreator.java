package pattern;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yanyugang
 * @description
 * @date 2019-09-06 11:25
 */
public class PacketHTTPHeaderCreator extends PacketDecorator {
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public PacketHTTPHeaderCreator(IPacketCreator c){
        super(c);
    }

    @Override
    public String handleContent(){
        StringBuffer sb=new StringBuffer();
        sb.append("Cache-Control:no-cache\n");
        sb.append("Date:" + sdf.format(new Date()) + "\n");
        sb.append(component.handleContent());
        return sb.toString();
    }
}
