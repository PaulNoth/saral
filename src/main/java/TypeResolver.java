import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Optional;

public class TypeResolver {

    public static Type getFromTypeName(EnkelParser.TypeContext typeContext) {
        if(typeContext == null) {
            return BuiltInType.VOID;
        }
        String typeName = typeContext.getText();
        if(typeName.equals("java.lang.String")) {
            return BuiltInType.STRING;
        }
        Optional<? extends Type> builtInType = getBuiltInType(typeName);
        if(builtInType.isPresent()) {
            return builtInType.get();
        }
        return new ClassType(typeName);
    }

    public static Type getFromValue(String value) {
        if(StringUtils.isEmpty(value)) {
            return BuiltInType.VOID;
        }
        if(StringUtils.isNumeric(value)) {
            return BuiltInType.INT;
        }
        return BuiltInType.STRING;
    }

    private static Optional<BuiltInType> getBuiltInType(String typeName) {
        return Arrays.stream(BuiltInType.values())
                .filter(type -> type.getName().equals(typeName))
                .findFirst();
    }
}
