public class MethodSignatureNotFoundException extends RuntimeException {
    public MethodSignatureNotFoundException(Scope scope, String methodName) {
        super("There is no method " + methodName);
    }
}