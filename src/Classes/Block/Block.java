package Classes.Block;

public class Block {
    private final int [] values;
    private final int width;
    private final int length;
    private final int height;

    public Block(int[] values) {
        this.values = values;
        this.width  = values[0];
        this.length  = values[1];
        this.height  = values[2];

    }

    public int getWidth() {
        return this.width;
    }

    public int getLength() {
        return this.length;
    }

    public int getHeight() {
        return this.height;
    }

    public int getVolume() {
        return this.height * this.length * this.width;
    }

    public int getSurfaceArea() {
        return this.height * this.width * 2 +
                this.height * this.length * 2 +
                this.length * this.width * 2;
    }
}
