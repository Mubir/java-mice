package mubir.mygeneric.compiletimesafety;

public class EnsureRuntimeAndCompileTimeSafety<T> {

    private T target;

    EnsureRuntimeAndCompileTimeSafety(T target) {
        this.target = target;
    }

    public T getTarget() {
        return target;
    }
}
