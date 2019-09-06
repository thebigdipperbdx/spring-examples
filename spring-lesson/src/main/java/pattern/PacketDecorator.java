package pattern;

/**
 * @author yanyugang
 * @description
 * @date 2019-09-06 11:18
 */
public abstract class PacketDecorator implements IPacketCreator {
    IPacketCreator component;

    public PacketDecorator(IPacketCreator c){
        component=c;
    }
}
