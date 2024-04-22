package com.tigo.EmShareKernel.core.event;

import com.tigo.EmShareKernel.exception.TransformationException;

public interface ITransformer {
	
	INotification transform(IEventEM event) throws TransformationException;

}
