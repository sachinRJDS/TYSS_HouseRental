package com.houserental.genericutility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

public class ITransform implements IAnnotationTransformer{
	//welcome
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(com.houserental.genericutility.RetryImplementation.class);
	}
	
	//Thank You

	
}
