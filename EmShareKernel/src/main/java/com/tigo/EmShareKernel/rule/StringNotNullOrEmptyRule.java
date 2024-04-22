package com.tigo.EmShareKernel.rule;

import com.tigo.EmShareKernel.core.IBussinessRule;

public class StringNotNullOrEmptyRule implements IBussinessRule{

	private String _value;
	public String Message;

	public StringNotNullOrEmptyRule(String _value) {
		this._value = _value;
		Message = "string cannot be null";
	}

	public Object get_value() {
		return _value;
	}

	@Override
	public boolean IsValid() {
		return (_value.isEmpty() || _value == null);
	}

	@Override
	public String GetMessage() {
		return Message;
	}
	
}
