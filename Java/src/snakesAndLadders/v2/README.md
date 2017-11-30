## Snakes and Ladders v2

This version extends v1 with pluggable rules.
Rules are defined as `Game` decorators.
* `RelaxedLandingRule`: To finish the game, a player may land on the last cell or go beyond.
This is the default rule that comes built-in.
* `ExactLandingRule`: To finish the game, a player has to land on the last cell exactly.
* `ByByeRule`: If a player lands on a cell that is already occupied by another player, the other player is sent to the first cell.
* `Lucky6Rule`: A player that rolls 6 plays again.
