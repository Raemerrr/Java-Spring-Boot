package me.raemerrr.designpatterns.templatemethod;

import me.raemerrr.designpatterns.templatemethod.models.AbstractMethod;
import me.raemerrr.designpatterns.templatemethod.models.TemplateMethod1;
import me.raemerrr.designpatterns.templatemethod.models.TemplateMethod2;
import org.junit.jupiter.api.Test;

public class TemplateMethodTest {

    @Test
    public void test01() {
        AbstractMethod template1 = new TemplateMethod1();
        AbstractMethod template2 = new TemplateMethod2();

        template1.execute(template1.getClass().toString());
        template2.execute(template1.getClass().toString());
    }
}
