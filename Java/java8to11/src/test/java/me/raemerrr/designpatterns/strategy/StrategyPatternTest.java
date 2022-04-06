package me.raemerrr.designpatterns.strategy;

import me.raemerrr.designpatterns.strategy.models.Americano;
import me.raemerrr.designpatterns.strategy.models.CoffeeMachine;
import me.raemerrr.designpatterns.strategy.models.Latte;
import org.junit.jupiter.api.Test;

public class StrategyPatternTest {

    @Test
    void test01() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.execute(new Americano());
        coffeeMachine.execute(new Latte());
    }
}
