package se.chalmers.tda367.vt13.dimensions.controller.screens;

import se.chalmers.tda367.vt13.dimensions.components.MenuButton;
import se.chalmers.tda367.vt13.dimensions.controller.Dimensions;
import se.chalmers.tda367.vt13.dimensions.model.LevelHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class MainMenuScreen extends AbstractMenuScreen {

	public MainMenuScreen(final Dimensions game) {
		super(game);
		init();
	}

	private void init() {
		final MenuButton playButton = new MenuButton("data/play.png");
		playButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				game.getGameScreen().nextLevel(
						LevelHandler.getInstance().getNextUnfinishedLevel());
				game.setScreen(game.getGameScreen());
				dispose();
			}
		});
		mainTable.add(playButton).expandX();
		initSidebar();
	}
	
	private void initSidebar(){
		Table sidebarTable = new Table();
		
		final Button levelSelectButton = new MenuButton("data/level_select.png");
		levelSelectButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				levelSelectButton.setChecked(false);
				game.setScreen(game.getLevelSelectScreen());
			}
		});
		
		final Button optionButton = new MenuButton("data/settings.png");
		optionButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				optionButton.setChecked(false);
				game.setScreen(game.getCreditScreen());
			}
		});
		
		final Button exitButton = new MenuButton("data/exit.png");
		exitButton.addListener(new ClickListener() {
			public void clicked(InputEvent e, float x, float y) {
				System.out.println("exit");
				System.exit(0);
			}
		});

		sidebarTable.add().width(200);
		sidebarTable.row();
		sidebarTable.add(levelSelectButton);
		sidebarTable.row();
		sidebarTable.add(optionButton);
		sidebarTable.row();
		sidebarTable.add(exitButton);
		
		mainTable.add(sidebarTable);
	}
}
