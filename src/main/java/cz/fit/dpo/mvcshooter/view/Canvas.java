package cz.fit.dpo.mvcshooter.view;

import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.model.ModelObserver;
import cz.fit.dpo.mvcshooter.model.entities.GameObject;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Ondrej Stuchlik
 */
public class Canvas extends JPanel implements ModelObserver {

  private GraphicsDrawer drawer = new GraphicsDrawer();
  private Model model;

  public Canvas(int x, int y, int width, int height, Model model) {
    this.model = model;
    this.model.attach(this);
    this.setBackground(Color.WHITE);
    this.setDoubleBuffered(true);
    this.setLocation(x, y);
    this.setPreferredSize(new Dimension(width, height));
    this.setVisible(true);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawer.setGraphics(g);
    List<GameObject> all = model.getAll();
    for (GameObject go : all) {
      go.accept(drawer);
    }
  }

  @Override
  public void modelUpdated() {
    repaint();
  }
}
