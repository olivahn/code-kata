package io.github.shirohoo;

import static io.github.shirohoo.racing.adapter.ApplicationType.CONSOLE;
import io.github.shirohoo.racing.domain.RacingGame;
import io.github.shirohoo.racing.domain.RacingGameSettings;
import io.github.shirohoo.racing.domain.RandomForwardCondition;
import io.github.shirohoo.racing.port.in.Input;
import io.github.shirohoo.racing.port.out.Output;

public class Main {
    public static void main(String[] args) {
        Input input = CONSOLE.getInput();
        Output output = CONSOLE.getOutput();

        output.setCarNamesMessage();
        String carNames = input.carNames();

        output.setTryCountMessage();
        int tryCount = input.tryCount();

        RacingGameSettings settings = RacingGameSettings.of(carNames, tryCount, new RandomForwardCondition());
        RacingGame racingGame = RacingGame.from(settings);

        output.showRoundMessage(racingGame.eachRound());

        output.showResultMessage(racingGame.winners());
    }
}
