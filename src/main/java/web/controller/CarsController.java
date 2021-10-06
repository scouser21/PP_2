package web.controller;

import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.Service;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {


    @GetMapping(value = "/cars")
    public String printWelcome(@RequestParam(value = "count", required = false) String param, ModelMap model) {

        Service service = new Service();
        int count;
        if (param == null){
            count = Integer.MAX_VALUE;
        } else {
            count = Integer.parseInt(param);
        }

        List<Car> carsList = service.getCars(count);
        model.addAttribute("carsList", carsList);
        return "cars";
    }

}