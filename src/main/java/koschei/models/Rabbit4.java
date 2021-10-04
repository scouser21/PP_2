package koschei.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component ("rabbitBean")
public class Rabbit4 {

    Duck5 duck;

    @Override
    public String toString() {
        return ", в зайце утка " + duck.toString();
    }

    @Autowired
    public void setDuck(Duck5 duck){
        this.duck = duck;
    }
}
