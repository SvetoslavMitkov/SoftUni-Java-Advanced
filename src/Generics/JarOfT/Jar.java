package Generics.JarOfT;

import java.util.Deque;

public class Jar<T> {
    private Deque<T> jar ;

    public Jar() {
        this.jar = jar;
    }

    public void add (T entity){
        this.jar.push(entity);
    }

    public T remove (){
        return this.jar.pop();
    }

}
