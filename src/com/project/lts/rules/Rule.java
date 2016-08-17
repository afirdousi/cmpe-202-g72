/*
* File created by : Thiagarajan Natarajan
* Date : August 17, 2016
* Subject : CMPE 202 - Summer 2016 - Group G72
*/

package com.project.lts.rules;

public abstract class Rule {

	/*Class Name:  Rule
 *Purpose:  This is an abstract class for rules.  It has 2 children such as Member Rule and VehicleRule
 *Pattern used:  Template pattern.  Template method apply() has 2 abstract methods initializeRule() and endRule().
 * Author: Thiagarajan Natarajan
 * Date: 08/15/2016
 * 	
 */
	String  ruleType;
	String  ruleId;
	String  ruleMessage;
	boolean isRuleEnabled;
	int ruleValue;
	
    abstract void initializeRule();
    abstract void endRule();
    
//Template method
    
    public final void apply() {
    	
    	initializeRule();
    	endRule();
    }
//setters and getters
	public String getRuleType() {
		return this.ruleType;
	}
	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}
	public String getRuleId() {
		return this.ruleId;
	}
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}
	public String getRuleMessage() {
		return this.ruleMessage;
	}
	public void setRuleMessage(String ruleMessage) {
		this.ruleMessage = ruleMessage;
	}
	public boolean isRuleEnabled() {
		return this.isRuleEnabled;
	}
	public void setRuleEnabled(boolean isRuleEnabled) {
		this.isRuleEnabled = isRuleEnabled;
	}
	public int getRuleValue() {
		return this.ruleValue;
	}
	public void setRuleValue(int ruleValue) {
		this.ruleValue = ruleValue;
	}
//constructor
	
	public Rule(String ruleType, String ruleId, String ruleMessage, boolean isRuleEnabled, int ruleValue) {
		
		this.ruleType = ruleType;
		this.ruleId = ruleId;
		this.ruleMessage = ruleMessage;
		this.isRuleEnabled = isRuleEnabled;
		this.ruleValue = ruleValue;
	}

}

