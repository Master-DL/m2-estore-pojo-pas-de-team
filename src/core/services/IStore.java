package core.services;

import core.data.Cart;
import core.data.Order;
import estorePojo.exceptions.InsufficientBalanceException;
import estorePojo.exceptions.InvalidCartException;
import estorePojo.exceptions.UnknownAccountException;
import estorePojo.exceptions.UnknownItemException;

public interface IStore {
	double getPrice(Object item)
			throws UnknownItemException;

	boolean isAvailable(Object item, int qty)
			throws UnknownItemException;

	Cart addItemToCart(Cart cart, IClient client, Object item, int qty)
			throws UnknownItemException, InvalidCartException;

	Order pay(Cart cart, String address, String bankAccountRef)
			throws InvalidCartException, UnknownItemException, InsufficientBalanceException, UnknownAccountException;

	Order oneShotOrder(IClient client, Object item, int qty, String address, String bankAccountRef)
			throws UnknownItemException, InsufficientBalanceException, UnknownAccountException;
}
