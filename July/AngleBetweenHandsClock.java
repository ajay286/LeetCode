public class AngleBetweenHandsClock {
    public double angleClock(int hour, int minutes) {
        double result = Math.abs(0.5 * (60*hour - 11 *minutes ));
        result = result <=180 ? result : 360 -result;
        
        return result;
        
    }
}
