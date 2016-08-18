
package com.project.lts.rules;
/*
 * 
 * 
 * 
 * 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.lts.accounts.Member;

public class RuleManager {
	public  ArrayList<Rule> rules;
	public Rule rule;
	public long ruleid = 2;
	public String strmruleType="";
	public String strmrulemsg="";
	public boolean isRulactive = true;
	public int intruleval = 0;
	
public RuleManager() {
		this.rules = new ArrayList<Rule>();
	}

public void  setMockRules() {
	//String ruleType, String ruleId, String ruleMessage, boolean isRuleEnabled, int ruleValue)
	this.rule = new MemberRule("M", "Rule001","Drivers age restriction",true,19);
	this.rules.add(this.rule);
	this.rule = new VehicleRule("V","Rule002","Vehicle manufacturing year rule", true,2002);
	this.rules.add(this.rule);
	
	
}

public void addRules(Rule r, List<Rule> rules) {
	
	rules.add(r);
	System.out.println("After adding the size of the rules arraylist = " + rules.size());
	System.out.println("List of Rules");
	for (int i = 0; i < rules.size(); i++){

		System.out.println("\n" +  rules.get(i).getRuleId() + " " +  rules.get(i).getRuleMessage() + " * "
				+  rules.get(i).getRuleType() + " * " +  rules.get(i).getRuleValue() + " * ");
	
	}
	
}


public void removeRule(String ruleId) {


		System.out.println("Printing after deletion..");

		for (int i = 0; i < rules.size(); i++) {

			if (rules.get(i).getRuleId().equalsIgnoreCase(ruleId)) {
				System.out.println("Rule deleted = "+ruleId + rules.get(i).getRuleType() + "Rule Message = "+rules.get(i).getRuleMessage());
				rules.remove(i);
			}

		}
		System.out.println("rule has been deleted successfully!");
		System.out.println("Size of the list after delete operation is " + rules.size());
	}





public void showRulesmenu() {
	
	int choice;
	
	
	do {

		System.out.println("Lyft Transportation System (LTS) - Rule Management - SystemAdmin ");
		System.out.println("=============================================================");
		System.out.println("1. Add Rule");
		System.out.println("2. Retrieve Rule");
		System.out.println("3. Delete Rule");
		System.out.println("4. Exit");
		System.out.println("Enter your option(1,2,3,4,5,6,7,8,9)");

		Scanner console1 = new Scanner(System.in);
	    choice = console1.nextInt();
		console1.nextLine();
        switch(choice) {
          case 1:
        	  collectInput();
        	  addanyRule();
        	  break;
          case 2:
        	  System.out.println("Enter Rule Id to be retrieved");
  			  console1 = new Scanner(System.in);
  			  String strmRuleId = (console1.nextLine());
        	  rule= retrieveRule(strmRuleId);
        	  if (rule !=null)
        	    System.out.println("Rule retrieved = "+rule.getRuleId()+" "+rule.getRuleType()+" "+ rule.getRuleMessage()+" "+rule.getRuleValue());
        	  else
        		  System.out.println("Rule Id not found");
        	  break;
          case 3:
			System.out.println("Deleting Rule ");
			System.out.println("Enter Rule Id to be deleted");
			console1 = new Scanner(System.in);
		    strmRuleId = (console1.nextLine());
			removeRule(strmRuleId);
			break;
		}

	}while (choice !=4);
	
}

/*
* File created by : Thiagarajan Natarajan
* Date : August 17, 2016
* Subject : CMPE 202 - Summer 2016 - Group G72
*/

private void addanyRule() {
	
	this.ruleid++;
	
	if (this.strmruleType.equalsIgnoreCase("M")){
	    this.rule = new MemberRule("M", "", "",true, 0 );
	    System.out.println("TEMPLATE METHOD Pattern: Creating Member rule.");
	    rule.apply();
	}
	else{
		 this.rule = new VehicleRule("V", "", "",true, 0 );
		 System.out.println("TEMPLATE METHOD Pattern: Creating Vehicle rule.");
		 rule.apply();
	}
	this.rule.setRuleId("Rule00"+ruleid);
	this.rule.setRuleEnabled(this.isRulactive);
	this.rule.setRuleMessage(this.strmrulemsg);
	this.rule.setRuleValue(intruleval);
	addRules(this.rule,this.rules);
	
	
}

private void collectInput() {
	
	System.out.println("Rule type Member / Vehicle (Enter M/V)");
	Scanner console1 = new Scanner(System.in);
	this.strmruleType = (console1.nextLine());
	if (this.strmruleType.equalsIgnoreCase("M")) {
		System.out.println("Enter Member Rule Message ");
		 console1 = new Scanner(System.in);
		 this.strmrulemsg = (console1.nextLine());
		
	}
	else
	{
		System.out.println("Enter Vehicle Rule Message ");
		 console1 = new Scanner(System.in);
		 this.strmrulemsg = (console1.nextLine());
		
	}
	 
	 this.isRulactive = true;
	 System.out.println("Enter Rule value ");
	 console1 = new Scanner(System.in);
	 this.intruleval = (console1.nextInt());
	 
	
}

public Rule retrieveRule(String ruleId) {
	
	System.out.println("Printing rules ..");
	System.out.println("TEMPLATE method Pattern: Vehile, Member rules  created using TEMPLATE method Pattern..");
    System.out.println("Number of rules"+rules.size());
	for (int i = 0; i < this.rules.size();i++) {
        if (ruleId.equalsIgnoreCase("All")){
        	System.out.println("\n" +  this.rules.get(i).getRuleId() + " " +  this.rules.get(i).getRuleMessage() + " * "
    				+  this.rules.get(i).getRuleType() + " * " +  this.rules.get(i).getRuleValue() + " * ");
        }
       
		if (this.rules.get(i).getRuleId().equalsIgnoreCase(ruleId)) {
			return this.rules.get(i);
	
        }
		
	}
	
	return null;
		
}

}
