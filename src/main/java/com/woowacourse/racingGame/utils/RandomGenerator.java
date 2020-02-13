package com.woowacourse.racingGame.utils;

import java.util.Random;

public class RandomGenerator {
	private static final int RANDOM_UPPER_BOUND = 10;

	public static int generateRandomNumber() {
		return new Random().nextInt(RANDOM_UPPER_BOUND);
	}
}
