package mubir.mygeneric.compiletimesafety;

public class LostCompileTImeSafety {
    private Object target;

    LostCompileTImeSafety(Object target) {
        this.target = target;
    }

    public Object getTarget() {
        return target;
    }
}

