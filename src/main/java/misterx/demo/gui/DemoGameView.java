package misterx.demo.gui;

import misterx.demo.gui.infopanels.*;
import misterx.model.game.Game;
import misterx.model.gameitems.Detective;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class DemoGameView implements ActionListener {

  public static final int WINDOW_WIDTH = 600;
  private static final String WINDOW_TITLE = "MisterX-MVC-Demo";
  private static final String PERFORM_ACTION_BUTTON_TEXT = "Perform Action";
  private static final String MAP_URL = "http://www.cbossi.ch/misterx/map.png";

  private final Game game;
  private final DemoGameController controller;

  private JFrame mainWindow;
  private JPanel buttonPanel;
  private JLabel mapLabel;
  private JPanel infoPanel;
  private PerformActionButton performActionButton;
  private AbstractGameViewInfoLabel gameStateInfoLabel;
  private AbstractGameViewInfoLabel misterXInfoLabel;
  private List<AbstractGameViewInfoLabel> detectivesInfoLabels;
  private AbstractGameViewInfoLabel winnerInfoLabel;

  public DemoGameView(Game game, DemoGameController controller) {
    this.game = game;
    this.controller = controller;
    this.detectivesInfoLabels = new ArrayList<AbstractGameViewInfoLabel>();

  }

  public void createView() {
    createLayoutComponents();
    createLayout();
    registerListener();
  }

  private void createLayoutComponents() {
    mainWindow = new JFrame(WINDOW_TITLE);
    mainWindow.setLayout(new BorderLayout());
    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    buttonPanel = new JPanel();
    buttonPanel.setPreferredSize(new Dimension(WINDOW_WIDTH, 40));
    buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

    mapLabel = new JLabel(loadMapIcon());

    performActionButton = new PerformActionButton(game, PERFORM_ACTION_BUTTON_TEXT);

    infoPanel = new JPanel();
    infoPanel.setPreferredSize(new Dimension(WINDOW_WIDTH, 120));
    infoPanel.setLayout(new FlowLayout());

    gameStateInfoLabel = new GameStateInfoLabel(game);

    misterXInfoLabel = new CharacterInfoLabel(game.getMisterX());
    createDetectivesInfoLabels();
    winnerInfoLabel = new WinnerInfoLabel(game);
  }

  private ImageIcon loadMapIcon() {
    ImageIcon mapIcon = new ImageIcon();
    try {
      mapIcon = new ImageIcon(new URL(MAP_URL));
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return mapIcon;
  }

  private void createDetectivesInfoLabels() {
    for (Detective detective : game.getDetectives()) {
      detectivesInfoLabels.add(new CharacterInfoLabel(detective));
    }
  }

  private void createLayout() {
    buttonPanel.add(performActionButton);

    infoPanel.add(gameStateInfoLabel);
    infoPanel.add(misterXInfoLabel);
    for (AbstractGameViewInfoLabel detectiveInfoLabel : detectivesInfoLabels) {
      infoPanel.add(detectiveInfoLabel);
    }
    infoPanel.add(winnerInfoLabel);

    mainWindow.getContentPane().add(buttonPanel, BorderLayout.PAGE_START);
    mainWindow.getContentPane().add(mapLabel, BorderLayout.CENTER);
    mainWindow.getContentPane().add(infoPanel, BorderLayout.PAGE_END);

    mainWindow.pack();
    mainWindow.setVisible(true);
  }

  private void registerListener() {
    performActionButton.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(performActionButton)) {
      controller.performActionButtonAction();
    }
  }

}
