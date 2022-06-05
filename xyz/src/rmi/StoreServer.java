package rmi;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import InterfaceFrame.AllopathyMedicalColleage;
import InterfaceFrame.Dentist;
import InterfaceFrame.Doctor;
import InterfaceFrame.Human;
import InterfaceFrame.UnaniMedicalColleage;
import emailcomponant.Email;
import emailcomponant.EmailComponant;

public class StoreServer extends UnicastRemoteObject implements Bussiness {

	public StoreServer() throws RemoteException {
		
	}

	@Override
	public Object getBilalStoreObjects() throws RemoteException {
		
		AllopathyMedicalColleage kct=new AllopathyMedicalColleage();
		UnaniMedicalColleage botre=new UnaniMedicalColleage();
		EmailComponant email=new EmailComponant();
		
		Object bilal=new Human();
		
		bilal=Proxy.newProxyInstance(bilal.getClass().getClassLoader(),
				new Class[]{Doctor.class,Email.class,Dentist.class},
				new MyInvocation(new Object[] {kct,email}));		
	return bilal;
}
	public static void main(String[] args) throws Exception {
		StoreServer stores=new StoreServer();
		
		LocateRegistry.createRegistry(1099);
		Naming.bind("rmi://localhost:1099/bilalstores",stores);
		
		System.out.println("bilal  store ready....");
	}
}
class MyInvocation implements InvocationHandler,Serializable{
	Object obj[];
public MyInvocation(Object obj[]) {
	this.obj=obj;
}
@Override
public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	for(Object o:obj) {
		try {
	return method.invoke(o, args);}catch(Exception e) {}
	}return null;
}
}
	
