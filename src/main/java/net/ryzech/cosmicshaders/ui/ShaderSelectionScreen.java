package net.ryzech.cosmicshaders.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.utils.ShaderProvider;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;
import finalforeach.cosmicreach.gamestates.GameState;
import finalforeach.cosmicreach.ui.UIElement;

public class ShaderSelectionScreen extends GameState {
    GameState previousState;
    private String selectedShader = "base";
    private Boolean inSubMenu = false;
    private SpriteBatch spriteBatch = new SpriteBatch();
    private Viewport uiViewport;

    public ShaderSelectionScreen(final GameState previousState) {
        this.previousState = previousState;
    }

    @Override
    public void create() {
        super.create();

        UIElement returnToMenuButton = new UIElement(420.0F, 260.0F, 250.0F, 50.0F) {
            public void onClick() {
                super.onClick();
                GameState.switchToGameState(GameState.MAIN_MENU);
            }
        };

        returnToMenuButton.setText("Return to Main Menu");
        returnToMenuButton.show();
        this.uiElements.add(returnToMenuButton);
    }

    public void render() {
        super.render();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE) && (!inSubMenu)) {
            switchToGameState(this.previousState);
        }

        ScreenUtils.clear(0.0F, 0.0F, 0.0F, 1.0F, true);

        Gdx.gl.glEnable(2929);
        Gdx.gl.glDepthFunc(513);
        Gdx.gl.glEnable(2884);
        Gdx.gl.glCullFace(1029);
        Gdx.gl.glEnable(3042);
        Gdx.gl.glBlendFunc(770, 771);
        this.drawUIElements();
    }
}
