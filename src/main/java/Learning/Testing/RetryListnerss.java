package Learning.Testing;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.lang.model.AnnotatedConstruct;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryListnerss implements IAnnotationTransformer
{
   
	public void transform(ITestAnnotation testAnnotaion,Class testClass,AnnotatedConstruct testConstructor,Method testMethod)
	{
		testAnnotaion.setRetryAnalyzer(RetryAnalyser.class);
	}
//	public void transform (ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)
//	{
//		annotation.setRetryAnalyzer(RetryAnalyser.class);
//	}
	
	
}
