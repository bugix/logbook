package ch.unibas.medizin.logbook.client.request;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.google.web.bindery.requestfactory.shared.EntityProxy;

public abstract class ApplicationEntityTypesProcessor<T> {

    private final T defaultValue;

    private T result;

    public ApplicationEntityTypesProcessor() {
        defaultValue = null;
    }

    public ApplicationEntityTypesProcessor(T defaultValue) {
        this.defaultValue = defaultValue;
    }

    public static Set<Class<? extends EntityProxy>> getAll() {
        Set<Class<? extends EntityProxy>> rtn = new HashSet<Class<? extends EntityProxy>>();

        return Collections.unmodifiableSet(rtn);
    }

    private static void process(ApplicationEntityTypesProcessor<?> processor, Class<?> clazz) {
        
        processor.handleNonProxy(null);
    }

    private static void process(ApplicationEntityTypesProcessor<?> processor, Object proxy) {
        processor.handleNonProxy(proxy);
    }

    public void handleNonProxy(Object object) {
    }

    public T process(Class<?> clazz) {
        setResult(defaultValue);
        ApplicationEntityTypesProcessor.process(this, clazz);
        return result;
    }

    public T process(Object proxy) {
        setResult(defaultValue);
        ApplicationEntityTypesProcessor.process(this, proxy);
        return result;
    }

    protected void setResult(T result) {
        this.result = result;
    }
}
