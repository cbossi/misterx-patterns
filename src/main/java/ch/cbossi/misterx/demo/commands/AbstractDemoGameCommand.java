package ch.cbossi.misterx.demo.commands;

import ch.cbossi.misterx.demo.util.GameCycleSimplifier;
import ch.cbossi.misterx.model.commands.AbstractGameCommand;

public abstract class AbstractDemoGameCommand extends AbstractGameCommand {

  protected final GameCycleSimplifier gameCycleSimplifier;

  public AbstractDemoGameCommand(GameCycleSimplifier gameCycleSimplifier) {
    this.gameCycleSimplifier = gameCycleSimplifier;
  }

}
