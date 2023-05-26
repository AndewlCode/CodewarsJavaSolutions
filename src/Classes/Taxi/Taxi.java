package Classes.Taxi;

class Taxi {
    private int x;
    private int y;
    public Taxi(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void moveRight() {
        this.x += 1;
    }
    public void moveLeft() {
        this.x -= 1;
    }
    public void moveUp() {
        this.y += 1;
    }
    public void moveDown() {
        this.y -= 1;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

}
