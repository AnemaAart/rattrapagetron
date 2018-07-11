package controller;

public class TronController {

	public void orderPerform(final IUserOrder userOrder) {
		if (userOrder != null) {
			final PlayerPh player = this.grid.getLightcycleByPlayer(userOrder.getPlayer());
			if (player != null) {
				int direction;
				switch (userOrder.getOrder()) {
				case RIGHT:
					direction = (player.setDirection(
							(this.grid.getLightcycleByPlayer(userOrder.getPlayer()).getDirection() + 1 + 4) % 4));

					break;
				case LEFT:
					direction = (player.setDirection(
							((this.grid.getLightcycleByPlayer(userOrder.getPlayer()).getDirection() - 1) + 4) % 4));
					break;
				case NOP:
				default:
					direction = player
							.setDirection(this.grid.getLightcycleByPlayer(userOrder.getPlayer()).getDirection());
					break;

				}

				player.setDirection(direction);
			}
		}
	}
}
