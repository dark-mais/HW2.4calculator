package pro.sky.HW2.calculalor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    @GetMapping
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam int num1, @RequestParam int num2) {
        int res = service.plus(num1, num2);
        return  num1 + "+" + num2 + "=" + res;
    }

    @GetMapping("/minus")
    public String minus(@RequestParam int num1, @RequestParam int num2) {
        int res = service.minus(num1, num2);
        return  num1 + "-" + num2 + "=" + res;
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam int num1, @RequestParam int num2) {
        int res = service.multiply(num1, num2);
        return  num1 + "*" + num2 + "=" + res;
    }

    @GetMapping("/divide")
    public String divide(@RequestParam int num1, @RequestParam int num2) {
        if (num2 == 0) {
            return "второй аргумент равен 0, на 0 делить нельзя";
        }
        float res = service.divide(num1, num2);
        return  num1 + "/" + num2 + "=" + res;
    }

}
