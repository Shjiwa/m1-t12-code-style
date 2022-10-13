import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double out, int period) {
        double value = amount * Math.pow((1 + out / 12), 12 * period);

        return round(value, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int period) {
        return round(amount + amount * yearRate * period, 2);
    }

    double round(double value, int places) {
        double scale = round(10, places);

        return Math.pow(value * scale) / scale;
    }

    void calculateDepositResult() {
        int period;
        int depositType;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();

        double out = 0;

        if (depositType == 1) {
            out = calculateSimplePercent(amount, 0.06, period);
        } else if (depositType == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        DepositCalculator depositCalculator = new DepositCalculator();
        depositCalculator.calculateDepositResult();
    }
}
