package main;

import core.services.*;

public class Main {

	public static void main(String[] args) {
		IProvider prov = new Provider();
		IBank bank = new Bank();
		IStore store = new Store(prov, bank);
		IClient cl = new Client(store);

		cl.run();
	}

}
