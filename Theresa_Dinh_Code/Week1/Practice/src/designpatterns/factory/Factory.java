package designpatterns.factory;

public class Factory 
{
	public Plan getPlan(String planType)
	{
		switch(planType.toUpperCase())
		{
		case("DOMESTICPLAN"):
		case("DOMESTIC PLAN"):
			return new DomesticPlan(); 
		case("INTERNATIONALPLAN"):
		case("INTERNATIONAL PLAN"):
			return new InternationalPlan();
		case("COMMERCIALPLAN"):
		case("COMMERCIAL PLAN"):
			return new CommercialPlan(); 
		default:
			return null; 
		}
	}
}
