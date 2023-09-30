package Classes.Hex;

public class Test {
    public static void main(String[] args) {
        Hex FF = new Hex(255);
        System.out.println(FF);
        System.out.println(FF.valueOf() + 1);
        System.out.println(FF.equals(new Hex(255)));

        Hex a = new Hex(10);
        Hex b = new Hex(5);

        System.out.println(a.plus(b).toJSON());
        System.out.println(a.plus(2).toJSON());

        System.out.println(Hex.parse("0xFF"));
        System.out.println(Hex.parse("GG"));
    }
}