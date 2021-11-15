package Generics.ArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {
    public static<T> T[] create(int lenght, T def) {
    T[]arr = (T[]) Array.newInstance(def.getClass(),lenght);

        Arrays.fill(arr,def);
        return arr;
    }
    public static<T> T[] create(Class<T> clazz ,int lenght, T def) {
    T[]arr = (T[]) Array.newInstance(clazz,lenght);

        Arrays.fill(arr,def);
        return arr;
}
public static int getGreater(Integer first,Integer second){
int result = first.compareTo(second);
return result >= 0 ? first : second;
}
}
