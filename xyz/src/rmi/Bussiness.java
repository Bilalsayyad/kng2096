package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Bussiness extends Remote{
	
public Object getBilalStoreObjects()throws RemoteException;


}
