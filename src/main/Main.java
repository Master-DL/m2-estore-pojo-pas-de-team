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


@interface Service {}
@interface Autowired {}

interface ServiceF {
	void doSomethingComplex();
	float doSomethingElse(int a);
}

interface Service1 {
	void doSomething(String someString);
}

interface Service2 {
	String yes();
}

interface Service3 {
	float wow(int a);
}

@Service
class ServiceFImpl implements ServiceF {
	private final Service1 srv1;
	private final Service2 srv2;
	private final Service3 srv3;

	@Autowired
	public ServiceFImpl(Service1 srv1, Service2 srv2, Service3 srv3) {
		this.srv1 = srv1;
		this.srv2 = srv2;
		this.srv3 = srv3;
	}

	@Override
	public void doSomethingComplex() {
		srv1.doSomething(srv2.yes());
	}

	@Override
	public float doSomethingElse(int a) {
		return srv3.wow(a);
	}
}
