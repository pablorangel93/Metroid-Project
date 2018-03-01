package hud;

import javax.swing.tree.ExpandVetoException;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.metroidproyect.game.SuperMetroid;

public class Hud {
	public Stage stage;
	private Viewport viewport;

	private Integer energy;

	Label samusEnergy;
	Label energyText;

	public Hud(SpriteBatch sb) {
		energy = 100;
		viewport = new FitViewport(SuperMetroid.V_WIDTH, SuperMetroid.V_HEIGHT, new OrthographicCamera());
		stage = new Stage(viewport, sb);

		Table table = new Table();
		table.top().left();
		table.setFillParent(true);

		samusEnergy = new Label(String.format("%03d", energy), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		energyText = new Label("Energy ", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

		table.add(energyText);
		table.add(samusEnergy);

		stage.addActor(table);
	}
}
