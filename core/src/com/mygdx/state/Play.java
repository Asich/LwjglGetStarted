package com.mygdx.state;

import static com.mygdx.handlers.B2DVars.PPM;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.MyGame;
import com.mygdx.handlers.GameStateManager;

/**
 * Created by Murat on 13.12.2014.
 */
public class Play extends GameState {

    private Box2DDebugRenderer b2dr;
    private World world;

    private OrthographicCamera b2dCam;

    public Play(GameStateManager gameStateManager) {
        super(gameStateManager);

        world = new World(new Vector2(0, -9.8f), true);
        b2dr = new Box2DDebugRenderer();

        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(160 / PPM, 120 / PPM);
        bodyDef.type = BodyDef.BodyType.StaticBody;
        Body body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(50 / PPM, 5 / PPM);

        FixtureDef fdef = new FixtureDef();
        fdef.shape = shape;
        body.createFixture(fdef);

        //box

        bodyDef.position.set(140 / PPM, 170 / PPM);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        Body circleBody = world.createBody(bodyDef);
        CircleShape circle = new CircleShape();
        circle.setRadius(10f / PPM);
        FixtureDef f = new FixtureDef();
        f.shape = circle;
        f.density = 5f;
        f.restitution = 0.6f;
        circleBody.createFixture(f);

        b2dCam = new OrthographicCamera();
        b2dCam.setToOrtho(false, MyGame.V_WIDTH / PPM, MyGame.V_HEIGHT / PPM);

    }

    @Override
    public void handleInput() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void udpate(float dt) {
        world.step(dt, 6, 2);
    }

    @Override
    public void render() {
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        b2dr.render(world, b2dCam.combined);
    }


}
