package com.rev.patterns.factory;

public class PlanFactory {
	public Plan getPlan(String planType) {
		switch(planType.toUpperCase()) {
		case("DOMESTIC_PLAN"):
			return new DomesticPlan();
		case("COMMERCIAL_PLAN"):
			return new CommercialPlan();
		case("INSTITUTIONAL_PLAN"):
			return new InstitutionalPlan();
		default:
			return null;
		}
	}
}
