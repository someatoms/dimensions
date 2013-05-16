package se.chalmers.tda367.vt13.dimensions.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class PlayButton extends Button {

	public PlayButton() {
		super(getButtonStyle());
	}

	private static ButtonStyle getButtonStyle(){
		Skin skin = new Skin();
		Pixmap pixmap2 = new Pixmap(Gdx.files.internal("data/play.png"));
		skin.add("play", new Texture(pixmap2));
		ButtonStyle buttonStyle = new ButtonStyle();
		buttonStyle.up = skin.newDrawable("play", Color.GREEN);
		buttonStyle.down = skin.newDrawable("play", Color.BLUE);
		buttonStyle.checked = skin.newDrawable("play");
		buttonStyle.over = skin.newDrawable("play", Color.RED);
		skin.add("default", buttonStyle);
		return buttonStyle;
	}

}
