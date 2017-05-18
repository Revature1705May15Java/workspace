package com.revature.lambda;

import java.util.Arrays;
import java.util.List;

public class Lambda 
{

	public static void main(String[] args) 
	{
		Lambda circle = new Lambda();
		
		Lambda triangle = new Lambda();
		
		ShapeFormula_2 pythagorean = (double a, double b) -> Math.pow(a,b);
		
		ShapeFormula_2 areaTri = (double a, double b) -> (.5 * a * b );
		
		ShapeFormula_1 areaCir = (double a) -> (Math.PI * Math.pow(a, a));
		
		ShapeFormula_1 circumference = (double a) -> (2 * Math.PI * a);
		
		double circum = circle.formulate_1(circumference, 25);
		System.out.println(circum);
		
		double area = triangle.formulate_2(areaTri, 4, 10);
		System.out.println(area);
	}
	
	private double formulate_1(ShapeFormula_1 sf1, double a)
	{
		return sf1.formula_1(a);
	}
	
	private double formulate_2(ShapeFormula_2 sf2, double a, double b)
	{
		return sf2.formula_2(a, b);
	}
}

interface ShapeFormula_1
{
	double formula_1 (double a);
}

interface ShapeFormula_2
{
	double formula_2 (double a, double b);
}
