package remoto;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRemota extends Remote {

	String metodoRemoto01() throws RemoteException;

	String metodoRemoto02() throws RemoteException;

	String metodoRemoto03() throws RemoteException;

	String metodoRemoto04() throws RemoteException;
}