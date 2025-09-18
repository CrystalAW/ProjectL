package io.github.JLudi;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Sprite playerSprite;
    private Texture image;
    private Texture player;
    private Texture background;
    private FitViewport viewport;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("ludi.jpeg"); //
        player = new Texture("coin.jpg");
        background = new Texture("gamebkgnd.jpg");
        playerSprite = new Sprite(player);
        playerSprite.setSize(1,1);
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
        float speed = 4f;
        // delta time: measured time between frames
        float delta = Gdx.graphics.getDeltaTime(); // getting current delta

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            playerSprite.translateX(speed * delta); // move coin right
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            playerSprite.translateX(-speed * delta); // move to the left
        } 
        // NEXT :: adding the up and down movements later
        // else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
        //     playerSprite.translateX((speed *speed) * delta);
        // }
    }


    private void logic() {

    }

    private void draw() {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        float worldWidth = viewport.getWorldWidth();
        float worldHeight = viewport.getWorldHeight();
        // any tupe of drawing logic should be sandwiched between a being and end line.
        batch.draw(background, 0,0, worldWidth, worldHeight); // needs to be placed in order that it will be rendered.
        playerSprite.draw(batch); // sprites have their own draw method
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
