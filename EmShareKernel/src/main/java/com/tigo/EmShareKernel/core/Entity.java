package com.tigo.EmShareKernel.core;

public abstract class Entity<TId> {

	protected TId Id;
	
	protected Entity() {
		
	}
	
	public TId getId() {
		return Id;
	}
	
	protected void CheckRule(IBussinessRule rule)
			throws BussinessRuleValidationException {
			if (rule == null) {
				throw new IllegalArgumentException("Rule cannot be null");
			}
			if (!rule.IsValid()) {
				throw new BussinessRuleValidationException(rule);
			}
		}
	
}
