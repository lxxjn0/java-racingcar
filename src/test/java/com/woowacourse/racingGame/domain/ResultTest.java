package com.woowacourse.racingGame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class ResultTest {
	@Test
	void getRacingCarStatus_게임을_진행한_자동차() {
		final List<Car> racingCar = Arrays.asList(
			new Car(new Name("car1"), Position.valueOf(3)),
			new Car(new Name("car2"), Position.valueOf(2)),
			new Car(new Name("car3"), Position.valueOf(1)));
		final Result result = new Result(new Cars(racingCar));

		final List<String> actual = result.getRacingCarStatus();

		final List<String> expected = Arrays.asList("car1 : ---", "car2 : --", "car3 : -");

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void getWinners_우승한_자동차() {
		int winnerPosition = 7;

		List<Car> inGameCars = Arrays.asList(
			new Car(new Name("car1"), Position.valueOf(winnerPosition - 1)),
			new Car(new Name("car2"), Position.valueOf(winnerPosition)),
			new Car(new Name("car3"), Position.valueOf(winnerPosition - 2)),
			new Car(new Name("car4"), Position.valueOf(winnerPosition)));
		Cars cars = new Cars(inGameCars);
		Result result = new Result(cars);

		List<String> actual = result.getWinners();

		List<String> expected = Arrays.asList("car2", "car4");

		assertThat(actual).isEqualTo(expected);
	}
}
