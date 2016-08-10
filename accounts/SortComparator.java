/*
* File created by : Thiagarajan Natarajan
* Date : August 09, 2016
* Subject : CMPE 202 - Summer 2016 - Group G72
*/

package com.project.lts.accounts;

import java.util.Comparator;

public class SortComparator implements Comparator<Member>

{

	@Override
	public int compare(Member e1, Member e2) {

		return e1.getnMemberID().compareTo(e2.getnMemberID());
	}
}
