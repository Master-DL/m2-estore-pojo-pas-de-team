package core.services;

import estorePojo.exceptions.UnknownItemException;

public interface IProvider {
	double getPrice(Object item) throws UnknownItemException;

	int order(Object item, int qty) throws UnknownItemException;
}
