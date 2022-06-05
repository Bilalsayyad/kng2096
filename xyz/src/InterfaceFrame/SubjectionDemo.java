package InterfaceFrame;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SubjectionDemo {
public static void main(String[] args) {
	AllopathyMedicalColleage kct=new AllopathyMedicalColleage();
	UnaniMedicalColleage botre=new UnaniMedicalColleage();
	Human bilal=new Human();
	
	Object obj=Proxy.newProxyInstance(bilal.getClass().getClassLoader(), new Class [] {Doctor.class},new MyInvocation(kct) );

	Doctor drbilal=(Doctor)obj;
	drbilal.docure();
	
	Object obj2=Proxy.newProxyInstance(bilal.getClass().getClassLoader(), new Class [] {Doctor.class},new MyInvocation(botre) );
	Doctor dbilal=(Doctor)obj2;
	dbilal.docure();
}
}
class MyInvocation implements InvocationHandler{
	Object obj;
public MyInvocation(Object obj) {
	this.obj=obj;
	
}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		return method.invoke(obj, args);
	}
	
}