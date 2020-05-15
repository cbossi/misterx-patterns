package misterx.model.commands;

import misterx.model.util.Messsages;

public class DefaultGameCommand extends AbstractGameCommand {

  @Override
  public void execute() {
    Messsages.printMessage("No Action Performed");
  }

}
