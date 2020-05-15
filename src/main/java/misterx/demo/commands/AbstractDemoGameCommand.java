package misterx.demo.commands;

import misterx.demo.util.GameCycleSimplifier;
import misterx.model.commands.AbstractGameCommand;

public abstract class AbstractDemoGameCommand extends AbstractGameCommand {

  protected final GameCycleSimplifier gameCycleSimplifier;

  public AbstractDemoGameCommand(GameCycleSimplifier gameCycleSimplifier) {
    this.gameCycleSimplifier = gameCycleSimplifier;
  }

}
