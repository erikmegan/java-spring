package programmerzamannow.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmerzamannow.spring.core.data.Bar;
import programmerzamannow.spring.core.data.Foo;
import programmerzamannow.spring.core.data.FooBar;

public class DependencyInjectionTest {

    @Test
    void testNoDI(){
        var foo = new Foo();
        var bar = new Bar();

        var fooBar = new FooBar(foo,bar);

        Assertions.assertSame(foo, fooBar.getFoo());
        Assertions.assertSame(bar,fooBar.getBar());
    }
}
