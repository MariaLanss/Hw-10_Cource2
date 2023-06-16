package pro.sky.hw10_cource2.controller;

import pro.sky.hw10_cource2.exeption.IllegalNumberException;
import pro.sky.hw10_cource2.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {this.calculatorService = calculatorService;}

    @ExceptionHandler(value = IllegalNumberException.class)
    public ResponseEntity<String> illegalNumberHandler(IllegalNumberException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @GetMapping
    public String hello(){return this.calculatorService.hello();}

    @GetMapping("/plus")
    public String printPlus(@RequestParam("num1") int num1,
                            @RequestParam("num2") int num2){
        return this.calculatorService.printPlus(num1, num2);
    }

    @GetMapping("/minus")
    public String printMinus(@RequestParam("num1") int num1,
                             @RequestParam("num2") int num2){
        return this.calculatorService.printMinus(num1, num2);
    }

    @GetMapping("/multiply")
    public String printMultiply(@RequestParam("num1") int num1,
                                @RequestParam("num2") int num2){
        return this.calculatorService.printMultiply(num1, num2);
    }

    @GetMapping("/divide")
    public String printDivide(@RequestParam("num1") int num1,
                              @RequestParam("num2") int num2){
        return this.calculatorService.printDivide(num1, num2);
    }

}