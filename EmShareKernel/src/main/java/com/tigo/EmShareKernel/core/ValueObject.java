package com.tigo.EmShareKernel.core;

import com.tigo.EmShareKernel.core.BussinessRuleValidationException;

public abstract class ValueObject {

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
