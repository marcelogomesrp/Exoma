package br.usp.exoma;

/**
 *
 * @author marcelo
 */

public class WeldJUnit4Runner{

}
/*
public class WeldJUnit4Runner extends BlockJUnit4ClassRunner {

    private final Class klass;
    private final Weld weld;
    //private final WeldContainer container;

    public WeldJUnit4Runner(Class<?> klass) throws InitializationError {
        super(klass);
        this.klass = klass;
        this.weld = new Weld();
        weld.initialize();
        //this.container = weld.initialize();
    }

}
    /*

    private final Class klass;
    private final Weld weld;
    private final WeldContainer container;

    public WeldJUnit4Runner(final Class klass) throws InitializationError {
        super(klass);
        this.klass = klass;
        this.weld = new Weld();
        this.container = weld.initialize();
    }

    @Override
    protected Object createTest() throws Exception {
        final Object test = container.instance().select(klass).get();
        return test;
    }
}
*/
