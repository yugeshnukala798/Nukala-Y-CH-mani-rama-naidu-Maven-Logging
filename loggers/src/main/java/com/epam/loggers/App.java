package com.epam.loggers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Hello world!
 *
 */
public class App 
{
	
	private static final Logger logger = LogManager.getLogger(App.class);
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        logger.info("What operation you want to preform.......\n");
        logger.info("1.Interest Calculation\n2.Construction cost Estimation\nEnter your option : ");
        int op = Integer.parseInt(br.readLine());
        if(op == 1){
            InterestCalculate i = new InterestCalculate();
            double interest = 0;
            logger.info("\n1.Simple Interest\n2.Compond Interest\nEnter your option : ");
            int typeofInterest = Integer.parseInt(br.readLine());
            double principal,rateofInterest,time,noOfTimesPerYear;
            logger.info("\nEnter Principal Amount : ");
            principal = Double.parseDouble(br.readLine());
            logger.info("\nEnter Rate of Interest : ");
            rateofInterest = Double.parseDouble(br.readLine());
            logger.info("\nEnter Time period : ");
            time = Double.parseDouble(br.readLine());
            if(typeofInterest == 2){
                logger.info("\nEnter number of times interest to be calculated : ");
                noOfTimesPerYear = Double.parseDouble(br.readLine());
                interest = i.compoundInterest(principal,time,rateofInterest,noOfTimesPerYear);
            }
            else {
                interest = i.simpleInterest(principal,time,rateofInterest);
            }
            logger.info("\nTotal Interest : " + interest+" INR.\n");
            logger.info("Total Amount : " + (principal+interest) + " INR.\n");
        }
        else{
            Estimate est = new Estimate();
            logger.info("Enter the Area of the House : ");
            double area = Double.parseDouble(br.readLine());
            logger.info("\nMaterial Standards - Cost per Square Feet \n1.Normal Standard - 1200INR\n2.Above Standard - 1500INR\n3.High Standard - 1800INR\n4.High Standard with fully Automated - 2500INR\n");
            logger.info("\nEnter  your option : ");
            int standard = Integer.parseInt(br.readLine());

            logger.info("Do you want Fully Automated home?(y/n)");
            String str = br.readLine();
            boolean fullyautomated = false;
            if(str.charAt(0) == 'y')
                fullyautomated = true;
            double estimatedcost = est.estimateHouse(area, standard, fullyautomated);
            logger.info("Estimated cost for Construction is "+estimatedcost + " INR\n");
        }
        br.close();
    }
}