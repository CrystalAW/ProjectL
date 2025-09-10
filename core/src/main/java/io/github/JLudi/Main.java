package io.github.JLudi;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private Texture player;
    private FitViewport viewport;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("ludi.jpeg"); //
        player = new Texture("coin.jpg");
        viewport = new FitViewport(8, 5);
    }

    @Override
    public void render() {
        //ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        input();
        logic();
        draw();
        // Gdx.gl.glClearColor(1, 0, 0, 1); // Red background so you SEE something
        // Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // batch.begin();
        // batch.draw(image, 140, 210);
        // batch.end();
    }

    private void input() {

    }
    private void logic() {

    }

    private void draw() {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        // any tupe of drawing logic should be sandwiched between a being and end line.
        batch.draw(player, 0, 0, 1, 1); // drawing the coin by 1m

        batch.end();
    }

    
    @Override
    public void resize(int width, int height){
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
