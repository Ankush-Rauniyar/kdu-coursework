package billingComponent;

public class BlueCrossBlueShield implements InsuranceBrand{
    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking){
        double ansAge = 0;
        double ansSmoking = 0;
        if(insurancePlan instanceof PlatinumPlan){
            if(age > 55){
                ansAge = 200;
            }
            if(smoking){
                ansSmoking= 100;
            }
        }else if(insurancePlan instanceof GoldPlan){
            if(age > 55){
                ansAge = 150;
            }
            if(smoking){
                ansSmoking = 90;
            }
        }else if(insurancePlan instanceof SilverPlan){
            if(age > 55){
                ansAge = 100;
            }
            if(smoking){
                ansSmoking = 80;
            }
        }else if(insurancePlan instanceof BronzePlan){
            if(age > 55){
                ansAge = 50;
            }
            if(smoking){
                ansSmoking = 70;
            }
        }
        return ansAge + ansSmoking;
    }
}
