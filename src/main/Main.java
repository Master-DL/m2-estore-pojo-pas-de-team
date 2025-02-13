package main;

import core.services.*;

public class Main {

	public static void main(String[] args) {
		IProvider prov = new Provider();
		IBank bank = new Bank();
		Store store = new Store(prov, bank);
		Client cl = new Client(store, store, store);

		cl.run();
	}

}
