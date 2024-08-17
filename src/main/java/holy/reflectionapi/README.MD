# Reflection api.(It's just a library in java)
1. Allows to change any java program at runtime.
2. Slower because JVM can't optimize the code.
3. but it's widely used in spring framework.

## Method stuff:

### Get a method's name:
- method.getName();

### Get a method's return type:
- method.getReturnType();

### Invoke a method:
- method.invoke(anyParameters, listedLikeThis);

### If it's private or not accessible, put this before it:
- method.setAccessible(true);

### See if a method has an annotation:
- method.isAnnotationPresent(NameOfAnnotation.class);

### Get an annotation from a method:
- method.getAnnotation(NameOfAnnotation.class);

### Get a method's parameter types:
- method.getParameterTypes();

### Get annotations on a method's parameters:
- method.getParameterAnnotations()

### Get the class that declares this method:
- method.getDeclaringClass();

### Get all exceptions the method declares it can throw:
- method.getExceptionTypes();


## Field stuff:
### Get the value of a field:
- field.get(objectToGetThisFieldFrom);

### Get the type of a field:
- Field.getType();

### Set the value of a field:
- field.set(objectToSetThisFieldOn, valueToSetTheFieldTo);

### Get the name of a field:
- field.getName();

### See if a field has an annotation:
- field.isAnnotationPresent(NameOfAnnotation.class);

### Get an annotation from a field:
- field.getAnnotation(NameOfAnnotation.class);

### Get the class that declares this field:
- method.getDeclaringClass();


## Class stuff:
### Get a class's name:
- class.getName();

### See if a class has an annotation:
- class.isAnnotationPresent(NameOfAnnotation.class);

### Get an annotation from a class:
- class.getAnnotation(NameOfAnnotation.class);

### Get declared fields:
- class.getDeclaredFields();

### Get all fields, which will include fields declared in parent classes:
- class.getFields();

### Get declared methods:
- class.getDeclaredMethods();

### Get all methods, which will include fields declared in parent classes:
- class.getMethods();