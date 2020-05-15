package misterx.demo.commands;

import misterx.demo.util.GameCycleSimplifier;

public class SetAllStartPositionsGameCommand extends AbstractDemoGameCommand {

  private final String misterXStartPosition;
  private final String[] detectivesStartPositions;

  public SetAllStartPositionsGameCommand(GameCycleSimplifier gameCycleSimplifier, String misterXStartPosition, String... detectivesStartPositions) {
    super(gameCycleSimplifier);
    this.misterXStartPosition = misterXStartPosition;
    this.detectivesStartPositions = detectivesStartPositions;
  }

  @Override
  public void execute() {
    gameCycleSimplifier.setStartPositions(misterXStartPosition, detectivesStartPositions);
  }

}
