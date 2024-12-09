public class Converter {

    public int convertToKm(int steps) { //преобразуем шаги в километры
        double kmDouble = steps * 0.75 / 1000;
        return (int) kmDouble;
    }

    public int convertStepsToKilocalories(int steps) {//преобразуем шаги в килокалории
        return (steps * 50 / 1000);
    }
}

