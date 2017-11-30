## Snakes and Ladders v2

This version extends v1 with pluggable rules.
Rule are defined as `Game` decorators.

* `ExactLandingRule`: To finish the game, a player has to land on the last cell exactly.
* `RelaxedLandingRule`: To finish the game, a player may land on the last cell or go beyond.
* `ByByeRule`: If a player lands on a cell that is already occupied by another player, the other player is sent to the first cell.
* `Lucky6Rule`: A player that rolls 6 plays again.
