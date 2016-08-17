/*
* File created by : Thiagarajan Natarajan
* Date : August 17, 2016
* Subject : CMPE 202 - Summer 2016 - Group G72
*/

package com.project.lts.rules;


public class VehicleRule extends Rule{

	public VehicleRule(String ruleType, String ruleId, String ruleMessage, boolean isRuleEnabled, int ruleValue) {
		super(ruleType, ruleId, ruleMessage, isRuleEnabled, ruleValue);
		
	}

	
	@Override
	void initializeRule() {
		System.out.println("Initializing Vehicle rule using template pattern");
		
	}

	@Override
	void endRule() {
		System.out.println("End of Vehicle rule template pattern");
		
	}

}