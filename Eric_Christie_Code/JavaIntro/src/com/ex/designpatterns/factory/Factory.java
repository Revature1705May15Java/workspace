package com.ex.designpatterns.factory;

public class Factory {

  public Plan getPlan(String planType) {
    if (planType == null) {
      return null;
    }

    switch (planType.toUpperCase()) {
    case ("DOMESTICPLAN"):
      return new DomesticPlan();
    case ("COMMERCIALPLAN"):
      return new CommercialPlan();
    case ("INSTITUTIONALPLAN"):
      return new InstitutionalPlan();
    default:
      return null;
    }
  }

}
