package Classes.Taxi;

public class TaxiDriver {
    public static void driveTaxi(Taxi driver, int toX, int toY) {
        boolean xVectorIsPotitive = false;
        boolean yVectorIsPotitive = false;

        if (driver.getX() < toX) {
            xVectorIsPotitive = true;
        }

        if (driver.getY() < toY) {
            yVectorIsPotitive = true;
        }

        if (xVectorIsPotitive) {
            int roadXLength = toX - driver.getX();
            while (roadXLength > 0) {
                driver.moveRight();
                roadXLength--;
            }
        } else {
            int roadXLength = driver.getX() - toX;
            while (roadXLength > 0) {
                driver.moveLeft();
                roadXLength--;
            }
        }

        if (yVectorIsPotitive) {
            int roadYLength = toY - driver.getY();
            while (roadYLength > 0) {
                driver.moveUp();
                roadYLength--;
            }
        } else {
            int roadYLength = driver.getY() - toY;
            while (roadYLength > 0) {
                driver.moveDown();
                roadYLength--;
            }
        }
    }
}
