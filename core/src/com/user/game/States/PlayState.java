package com.user.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.user.game.FlappyDemo;
import com.user.game.sprites.Bird;

public class PlayState extends State {

    private Bird bird;
    private Texture bg;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Bird(50, 300);
        cam.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGHT / 2);
        bg = new Texture("bg.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            bird.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0);
        sb.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
