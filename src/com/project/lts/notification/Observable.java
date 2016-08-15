package com.project.lts.notification;

import java.util.*;

import com.project.lts.accounts.Member;

public class Observable {
	
	List<Member> observers = new ArrayList<Member>();
	
	public void add(Member m){
		this.observers.add(m);
	}
	
	public void add(List<Member> members){
		this.observers.addAll(members);
	}
	
	public void remove(Member m){
		this.observers.remove(m);
	}
	
	public void removeAll(){
		this.observers = new ArrayList<Member>();
	}
	
	
	
}
