package permutador;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class Permutador {
	private Set<String> perms = new ConcurrentSkipListSet<String>();
	
	public Set<String> getPerm(){
		return this.perms;
	}
	
	public void permutation(String str) {
			permutation("", str);
		}
	
	private void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0) {
			perms.add(prefix);
			} else {
				for (int i = 0; i < n; i++) {
					permutation(prefix + str.charAt(i),
					str.substring(0, i) + str.substring(i + 1, n));
				}
			}
		}

}
