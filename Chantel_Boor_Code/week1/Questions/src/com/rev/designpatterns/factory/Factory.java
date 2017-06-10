package com.rev.designpatterns.factory;

public class Factory 
{
	public Plan getPlan (String planType)
	{

		switch(planType.toUpperCase())
		{
		case ("DOMESTICPLAN"):
		case ("DOMESTIC PLAN"):
			return new DomesticPlan();
		case ("COMMERCIALPLAN"):
		case ("COMMERCIAL PLAN"):
			return new CommercialPlan();
		case ("INSTITUTIONPLAN"):
		case ("INSTITUTION PLAN"):	
			return new InstitutionPlan();
		default:
			return null;
		}
		
	}
}
