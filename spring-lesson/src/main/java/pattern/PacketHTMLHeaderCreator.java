package pattern;

/**
 * @author yanyugang
 * @description
 * @date 2019-09-06 11:18
 */
public class PacketHTMLHeaderCreator extends PacketDecorator {

    public PacketHTMLHeaderCreator(IPacketCreator c){
        super(c);
    }

    @Override
    public String handleContent(){
        StringBuffer sb=new StringBuffer();
        sb.append("<html>");
        sb.append("<body>");
        sb.append(component.handleContent());
        sb.append("</body>");
        sb.append("</html>\n");
        return sb.toString();
    }
}
