package com.caua.api_spring.controllers;

import com.caua.api_spring.exceptions.UnsuportedMathOperationException;
import com.caua.api_spring.services.ConverterServices;
import com.caua.api_spring.services.MathService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
    private MathService mathService = new MathService();
    private ConverterServices converterServices = new ConverterServices();

    @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!converterServices.isNumeric(numberOne) || !converterServices.isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }

        return mathService.sum(converterServices.convertToDouble(numberOne), converterServices.convertToDouble(numberTwo));
    }

    @RequestMapping(value="/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!converterServices.isNumeric(numberOne) || !converterServices.isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }

        return mathService.subtraction(converterServices.convertToDouble(numberOne), converterServices.convertToDouble(numberTwo));
    }

    @RequestMapping(value="/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!converterServices.isNumeric(numberOne) || !converterServices.isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }

        return mathService.multiplication(converterServices.convertToDouble(numberOne), converterServices.convertToDouble(numberTwo));
    }

    @RequestMapping(value="/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!converterServices.isNumeric(numberOne) || !converterServices.isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }

        return mathService.division(converterServices.convertToDouble(numberOne), converterServices.convertToDouble(numberTwo));
    }

    @RequestMapping(value="/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!converterServices.isNumeric(numberOne) || !converterServices.isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }

        return mathService.mean(converterServices.convertToDouble(numberOne), converterServices.convertToDouble(numberTwo));
    }

    @RequestMapping(value="/squareRoot/{number}", method=RequestMethod.GET)
    public Double squareRoot(@PathVariable("number") String number) throws Exception {
        if (!converterServices.isNumeric(number)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }

        return mathService.squareRoot(converterServices.convertToDouble(number));
    }
}
