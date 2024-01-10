package handson.partthree;

import billingComponent.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Main {
    private static final org.slf4j.Logger logger = (Logger) LoggerFactory.getLogger(Main.class);

    public static void main(String[] args){
        User staff = new User();
        InsuranceBrand insuranceBrand = new BlueCrossBlueShield();
        HealthInsurancePlan insurancePlan = new PlatinumPlan();

        insurancePlan.setOfferedBy(insuranceBrand);
        staff.setInsurancePlan(insurancePlan);
        logger.info("output is {}",insurancePlan.computeMonthlyPremium(5000, 56, true));
//        System.out.println(insurancePlan.computeMonthlyPremium(5000, 56, true));
    }
}
