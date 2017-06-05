package com.ex.FactoryPattern;

public class Factory {
	public Plan getPlan(String planType){
		
		switch(planType.toUpperCase()){
		case "DOMESTICPLAN":
		case "DOMESTIC PLAN":
			return new DomesticPlan();
		case "COMMERCIALPLAN":
		case "COMMERCIAL PLAN":
			return new CommercialPlan();
		case "INSTITUTIONALPLAN":
		case "INSTITUTIONAL PLAN":
			return new InstitutionalPlan();
		default:
			return null;
		}
	}
	
}
