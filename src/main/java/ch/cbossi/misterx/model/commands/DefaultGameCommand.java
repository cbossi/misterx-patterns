package ch.cbossi.misterx.model.commands;

import ch.cbossi.misterx.model.util.Messsages;

public class DefaultGameCommand extends AbstractGameCommand {

  @Override
  public void execute() {
    Messsages.printMessage("No Action Performed");
  }

}
