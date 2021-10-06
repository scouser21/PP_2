package service;

import model.Car;

import java.util.ArrayList;
import java.util.List;

public class Service {
    ArrayList<Car> carsList;

    public Service(){
        ArrayList<Car> list = new ArrayList<>();
        list.add(new Car(2011, "Red", "Rapid"));
        list.add(new Car(2012, "Black", "Jetta"));
        list.add(new Car(2013, "Blue", "Focus"));
        list.add(new Car(2014, "White", "Camry"));
        list.add(new Car(2015, "Gray", "Micra"));

        this.carsList = list;
    }

    public List getCars(int count){
        List<Car> list = new ArrayList<>();
        if (count <= carsList.size()){
            for (int i=0; i<count; i++){
                list.add(carsList.get(i));
            }
        } else {
            list = (ArrayList<Car>) carsList.clone();
        }
        return list;
    }
}
