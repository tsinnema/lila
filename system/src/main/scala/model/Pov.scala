package lila.system
package model

import lila.chess.Color

case class Pov(game: DbGame, color: Color) {

  def player = game player color

  def isPlayerFullId(fullId: Option[String]): Boolean =
    fullId some { game.isPlayerFullId(player, _) } none false
}

object Pov {

  def apply(game: DbGame, player: DbPlayer) = new Pov(game, player.color)
}