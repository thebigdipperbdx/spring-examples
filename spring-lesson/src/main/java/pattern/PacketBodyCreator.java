package pattern;

/**
 * @author yanyugang
 * @description
 * @date 2019-09-06 11:17
 */
public class PacketBodyCreator implements IPacketCreator {
    @Override
    public String handleContent(){
        return "Content of Packet";
    }
}
