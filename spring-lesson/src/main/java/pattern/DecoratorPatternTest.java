package pattern;

/**
 * @author yanyugang
 * @description
 * @date 2019-09-06 11:27
 */
public class DecoratorPatternTest {
    public static void main(String[] args){
        IPacketCreator pc=new PacketHTTPHeaderCreator(
                new PacketHTMLHeaderCreator(
                        new PacketBodyCreator()));
        System.out.println(pc.handleContent());
    }
}
