public class MonthData {
    int[] days = new int[30];

    public void printDaysAndStepsFromMonth() { // функция печати дней месяца
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " день: " + days[i]);
        }
    }

    public int sumStepsFromMonth() { //функция поиска суммы шагов за месяц
        int sumSteps = 0;
        for (int aDays : days) {
            sumSteps += aDays;
        }
        return sumSteps;

    }

    public int maxSteps() {//функция поиска максимального количества шагов в месяце
        int maxStepsPerMount = 0;
        for (int aDays : days) {
            if (aDays > maxStepsPerMount) {
                maxStepsPerMount = aDays;
            }
        }
        return maxStepsPerMount;
    }

    public int bestSeries(int goalByStepsPerDay) {//функция поиска максимального количества последовательных дней,
        // когда количество пройденных шагов больше целевого значения
        int maxGoalBySteps = 0; // максимальная серия
        int serialSteps = 0; //текущая серия

        for (int num : days) {
            if (num > goalByStepsPerDay) { //суммируем текущую серию дней с количеством шагов больше целевого
                serialSteps++;
            } else {
                if (serialSteps > maxGoalBySteps) {// Если текущая длина больше максимальной, обновляем maxGoalBySteps
                    maxGoalBySteps = serialSteps; // сохраняем в максимальную серию
                }
                serialSteps = 0; // Сброс текущей длины серии
            }
            if (serialSteps > maxGoalBySteps) { // Проверяем в конце, если последняя серия была максимальной
                maxGoalBySteps = serialSteps; // сохраняем в максимальную серию
            }
        }
        return maxGoalBySteps;
    }
}