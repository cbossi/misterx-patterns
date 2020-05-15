package ch.cbossi.misterx.demo.gui.infopanels;

import ch.cbossi.misterx.demo.gui.DemoGameView;

import javax.swing.*;
import java.awt.*;


public abstract class AbstractGameViewInfoLabel extends JLabel {

  private static final int INFO_LABEL_HEIGHT = 15;

  private static final long serialVersionUID = -5813786934291240892L;

  private final String legend;

  public AbstractGameViewInfoLabel(String legend) {
    this.legend = legend;
    createLayout();
  }

  private void createLayout() {
    setPreferredSize(new Dimension(DemoGameView.WINDOW_WIDTH, INFO_LABEL_HEIGHT));
  }

  protected void refreshText() {
    setText(legend + ": " + getValue());
  }

  public abstract String getValue();
}
