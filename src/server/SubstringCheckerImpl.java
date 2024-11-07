package server;

import shared.SubstringChecker;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class SubstringCheckerImpl extends UnicastRemoteObject implements SubstringChecker {

    protected SubstringCheckerImpl() throws RemoteException {
        super();
    }

    @Override
    public boolean isSubstring(String str1, String str2) throws RemoteException {
        return str2.contains(str1);
    }

    public static void main(String[] args) {
        try {
            SubstringCheckerImpl checker = new SubstringCheckerImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("SubstringChecker", checker);
            System.out.println("Server is ready.");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
