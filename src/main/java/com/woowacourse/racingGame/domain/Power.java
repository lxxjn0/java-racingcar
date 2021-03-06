package com.woowacourse.racingGame.domain;

import java.util.HashMap;
import java.util.Map;

public class Power {
	private static final Map<Integer, Power> cache = new HashMap<>();
	private static final int MOVABLE_LOWER_BOUND = 4;
	public static final int RANDOM_LOWER_BOUND = 0;
	public static final int RANDOM_UPPER_BOUND = 9;

	private final int randomNumber;

	public Power(final int randomNumber) {
		if (randomNumber < RANDOM_LOWER_BOUND || randomNumber > RANDOM_UPPER_BOUND) {
			throw new IllegalArgumentException("유효하지 않은 랜덤 숫자입니다.");
		}
		this.randomNumber = randomNumber;
	}

	public static Power valueOf(final int randomNumber) {
		if (cache.containsKey(randomNumber)) {
			return cache.get(randomNumber);
		}
		Power newPower = new Power(randomNumber);
		cache.put(randomNumber, newPower);
		return newPower;
	}

	public boolean isMovable() {
		return randomNumber >= MOVABLE_LOWER_BOUND;
	}
}
