package com.revature_wk1.designpatterns.factory;

public class Factory 
{
	public Plan getPlan(String planType)
	{	
		switch(planType.toUpperCase())
		{
			case("DOMESTIC"):
				return new DomesticPlan();
			
			case("COMMERCIAL"):
				return new CommercialPlan();
			
			case("INSITUTIONAL"):
				return new InstitutionalPlan();
			
			default:
				return null;
		}
	}
}
