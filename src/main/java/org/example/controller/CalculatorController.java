package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;

    @GetMapping("/calculator")
    public String welcome() {
        return " добро пожаловать в калькулятор ";
    }

    @GetMapping("/calculator/plus")
    public String plus(@RequestParam(name = "num1", required = false) Integer a,
                       @RequestParam(name = "num2", required = false) Integer b) {
        if (a == null || b == null) return " не передано значение переменной";
        int plus = calculatorService.plus(a, b);
        return a + " + " + b + " = " + plus;
    }

    @GetMapping("/calculator/minus")
    public String minus(@RequestParam(name = "num1", required = false) Integer a,
                        @RequestParam(name = "num2", required = false) Integer b) {
        if (a == null || b == null) return " не передано значение переменной";
        int minus = calculatorService.minus(a, b);
        return a + " - " + b + " = " + minus;
    }

    @GetMapping("/calculator/multiple")
    public String multiple(@RequestParam(name = "num1", required = false) Integer a,
                           @RequestParam(name = "num2", required = false) Integer b) {
        if (a == null || b == null) return " не передано значение переменной";
        int multiple = calculatorService.multiple(a, b);
        return a + " * " + b + " = " + multiple;
    }

    @GetMapping("/calculator/divide")
    public String divide(@RequestParam(name = "num1", required = false) Integer a,
                         @RequestParam(name = "num2", required = false) Integer b) {
        if (a == null || b == null) return " не передано значение переменной";
        double divide;
        try {
            divide = calculatorService.divide(a, b);
        } catch (Throwable exc) {
            return exc.getMessage();
        }
        return a + " / " + b + " = " + divide;
    }
}
