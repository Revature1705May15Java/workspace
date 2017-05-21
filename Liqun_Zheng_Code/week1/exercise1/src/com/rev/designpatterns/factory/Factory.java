package com.rev.designpatterns.factory;

public class Factory {
	public Plan getPlan(String planType){
		if(planType == null){
			return null;
		}
		switch(planType.toUpperCase()){
		case("DOMESTICPLAN"):
		case("DOMESTIC PLAN"):
			return new DomesticPlan();

		case("COMMERCIALPLAN"):
		case("COMMERCIAL PLAN"):
			return new CommercialPlan();

		case("INSTITUTIONAL PLAN"):
		case("INSTITUTIONALPLAN"):
			return new InstitutionalPlan();

		
		default:
			return null;
		}

		
	}
}

