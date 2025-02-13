package core.services;

import estorePojo.exceptions.UnknownItemException;

public interface IJustHaveALook {
	double getPrice(Object item)
			throws UnknownItemException;

	boolean isAvailable(Object item, int qty)
			throws UnknownItemException;
}
