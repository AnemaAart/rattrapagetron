package controller;

public class UserOrder implements IUserOrder {
	private final int player;
	private final Order order;

	public UserOrder(final int player, final Order order) {
		this.order = order;
	}

	@Override
	public Order getOrder() {
		return this.order;
	}

	@Override
	public int getPlayer() {
		return this.player;
	}
}
