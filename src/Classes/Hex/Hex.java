//https://www.codewars.com/kata/5483366098aa442def0009af
package Classes.Hex;

public class Hex {
    int intValue;
    String strValue;

    public Hex(int i) {
        intValue = i;
        strValue = "0x" + Integer.toHexString(i).toUpperCase();
    }

    public int valueOf() {
        return intValue;
    }

    public String toJSON() {
        return strValue;
    }

    @Override
    public String toString() {
        return strValue;
    }

    public Hex plus(Hex other) {
        return new Hex(other.intValue + intValue);
    }

    public Hex plus(int number) {
        return new Hex(intValue + number);
    }

    public Hex minus(Hex other) {
        return new Hex(intValue - other.intValue);
    }

    public Hex minus(int number) {
        return new Hex(intValue - number);
    }

    public static int parse(String string) {
        return Integer.parseInt(string.replaceFirst("0x", ""), 16);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hex hex)) return false;

        if (intValue != hex.intValue) return false;
        return strValue.equals(hex.strValue);
    }
}
