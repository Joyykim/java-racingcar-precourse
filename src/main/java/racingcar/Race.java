package racingcar;

import static racingcar.GameResult.getResult;
import static racingcar.Messages.GAME_RESULT_IS;
import static utils.PrintUtils.print;
import static utils.PrintUtils.printEmptyLine;

import java.util.List;
import utils.RandomUtils;

public class Race {

    public static final int RANDOM_MIN = 0;
    public static final int RANDOM_MAX = 9;
    public static final int MOVE = 4;

    public static GameResult start(List<Car> cars, int tryCount) {
        print(GAME_RESULT_IS);
        for (int i = 0; i < tryCount; i++) {
            cars.forEach(Race::moveCar);
            printEmptyLine();
        }
        return getResult(cars);
    }

    private static void moveCar(Car car) {
        if (isMove()) {
            car.moveForward();
        }
        car.printStatus();
    }

    private static boolean isMove() {
        return MOVE <= RandomUtils.nextInt(RANDOM_MIN, RANDOM_MAX);
    }
}
