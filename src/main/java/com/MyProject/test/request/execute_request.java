package com.MyProject.test.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MyProject.test.Models.Calculator;
import com.MyProject.test.Models.examples;
import com.MyProject.test.rep.ExamplesRepository; 

@Controller
public class execute_request {
	
	@Autowired
	private ExamplesRepository exRep;
	
	@GetMapping("/")
	public String index(Model model){
		model.addAttribute("view", "views/calculatorForm");
		return "index";
	}
	@PostMapping("/")
	public String index(
			@RequestParam String leftOperand,
			@RequestParam String operator,
			@RequestParam String rightOperand,
			Model model
	) {
		Integer leftNumber;
		Integer rightNumber;
		
		try {
			leftNumber = Integer.parseInt(leftOperand);
		}
		catch (NumberFormatException ex) {
			leftNumber = 0;
		}

		try {
			rightNumber = Integer.parseInt(rightOperand);
		}
		catch (NumberFormatException ex) {
			rightNumber = 0;
		}
		
		Calculator calculator = new Calculator(
				leftNumber,
				rightNumber,
				operator
		);
		 
		
		double result = calculator.calculateResult();
		model.addAttribute("leftOperand", leftNumber);
		model.addAttribute("operator", operator);
		model.addAttribute("rightOperand", rightNumber);
		model.addAttribute("result", result);
		
		
		examples ex = new examples(
				Integer.toString(leftNumber),
				Integer.toString(rightNumber),
				operator,
				Double.toString(result)
				);
		exRep.save(ex);
		
		model.addAttribute("view", "views/calculatorForm");
		return "index";
	}
	
}