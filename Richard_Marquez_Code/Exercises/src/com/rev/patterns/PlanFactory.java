package com.rev.patterns;

public class PlanFactory {
	public Plan getPlan(String planType) {
		switch(planType.toUpperCase()) {
		case "COMMERCIAL":
			return new CommercialPlan();
		case "DOMESTIC":
			return new DomesticPlan();
		case "INSTITUTIONAL":
			return new InstitutionalPlan();
		default:
			return null;
		}
	}
}
