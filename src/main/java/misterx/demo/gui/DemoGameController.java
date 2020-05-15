package misterx.demo.gui;

import misterx.demo.commands.PlayRoundGameCommand;
import misterx.demo.commands.SetAllStartPositionsGameCommand;
import misterx.demo.util.DemoMapDataParser;
import misterx.demo.util.GameCycleSimplifier;
import misterx.model.commands.DefaultGameCommand;
import misterx.model.commands.GameCommand;
import misterx.model.commands.MoveCharacterGameCommand;
import misterx.model.factory.GameItemFactory;
import misterx.model.factory.GameItemFactoryImpl;
import misterx.model.game.Game;
import misterx.model.gameitems.Detective;
import misterx.model.gameitems.MisterX;
import misterx.model.gameitems.enums.DetectiveType;

import java.util.LinkedList;
import java.util.Queue;


public class DemoGameController {

  private final DemoGameView gameView;
  private GameCycleSimplifier gameCycleSimplifier;
  private Queue<GameCommand> demoCommands;
  private Game game;

  public DemoGameController(Game game) {
    this.game = game;
    this.gameView = new DemoGameView(game, this);
    this.demoCommands = new LinkedList<GameCommand>();
    onLoadAction();
    createView();

  }

  private void onLoadAction() {
    GameItemFactory factory = GameItemFactoryImpl.getInstance();
    MisterX misterX = factory.createMisterX();
    Detective blueDetective = factory.createDetective(DetectiveType.BLUE);
    Detective greenDetective = factory.createDetective(DetectiveType.GREEN);

    gameCycleSimplifier = new GameCycleSimplifier(game, misterX, blueDetective, greenDetective);
    gameCycleSimplifier.createAndStartGame(new DemoMapDataParser());

    fillDemoCommandList();
  }

  private void fillDemoCommandList() {
    demoCommands.add(new SetAllStartPositionsGameCommand(gameCycleSimplifier, "Luzern", "Chur", "Basel"));

    demoCommands.add(new MoveCharacterGameCommand(game.getMisterX(), game.getMap().getCityByName("Bern")));
    demoCommands.add(new MoveCharacterGameCommand(game.getDetective(DetectiveType.BLUE), game.getMap().getCityByName("Zürich")));
    demoCommands.add(new MoveCharacterGameCommand(game.getDetective(DetectiveType.GREEN), game.getMap().getCityByName("Genf")));

    demoCommands.add(new PlayRoundGameCommand(gameCycleSimplifier, "Lausanne", "Bern", "Lausanne"));
  }

  private void createView() {
    gameView.createView();
  }

  public void performActionButtonAction() {
    fetchNextDemoCommand().execute();
  }

  private GameCommand fetchNextDemoCommand() {
    if (demoCommands.isEmpty()) {
      return new DefaultGameCommand();
    }
    return demoCommands.poll();
  }
}
