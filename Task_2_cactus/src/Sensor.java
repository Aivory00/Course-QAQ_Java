import java.util.Random;

public class Sensor implements Humiditys
{
    public int getHumidity()
    {
        Random random = new Random();
        return random.nextInt(100);
    }
}