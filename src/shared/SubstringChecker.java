
package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SubstringChecker extends Remote {
    boolean isSubstring(String str1, String str2) throws RemoteException;
}
