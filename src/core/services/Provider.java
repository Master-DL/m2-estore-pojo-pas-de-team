package core.services;

import estorePojo.exceptions.UnknownItemException;

import java.util.HashMap;
import java.util.Map;

// Service

public class Provider implements IProvider {
	private final Map<String, Double> itemPrices = new HashMap<>();

	/**
	 * Constructs a new IProviderImpl
	 */
	public Provider() {
		itemPrices.put("CD", 15d);
		itemPrices.put("DVD", 20d);
	}

	/**
	 * Get the price of an item provided by this provider.
	 *
	 * @param item
	 * @return
	 */
	@Override
	public double getPrice(Object item) throws UnknownItemException {

		if (!itemPrices.containsKey(item))
			throw new UnknownItemException("Item " + item + " is not an item delivered by this provider.");

		Double price = itemPrices.get(item);
		return price.doubleValue();
	}

	/**
	 * Emit an order for items. The provider returns the delay for delivering the
	 * items.
	 *
	 * @param item the item ordered
	 * @param qty  the quantity ordered
	 * @return the delay (in hours)
	 */
	@Override
	public int order(Object item, int qty) throws UnknownItemException {

		if (!itemPrices.containsKey(item))
			throw new UnknownItemException("Item " + item + " is not an item delivered by this provider.");

		// Actually the production process is quite chaotic
		// We only know that the production a random number of hours!!
		double r = Math.random() * 10 * qty;
		return (int) r;
	}

}
