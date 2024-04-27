package com.mygdx.entropy.Objects.Items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.mygdx.entropy.Objects.GameEntity;
import static com.mygdx.entropy.Utils.Constants.PPM;

public class Threads extends GameEntity {

    private TextureAtlas atlas;
    
    public Body body;

    private AtlasRegion thread;

    public Threads(float width, float height, Body body) {
        super(width, height, body);
        
        this.atlas = new TextureAtlas("items/item.atlas");
        this.thread = atlas.findRegion("threadItem"); 
        
        Fixture fixture = body.getFixtureList().first();
        fixture.setUserData(this);
        fixture.setSensor(true);
    }

    @Override
    public void update() {
        x = body.getPosition().x * PPM;
        y = body.getPosition().y * PPM; 
    }

    @Override
    public void render(SpriteBatch batch) {     
    }

    public TextureRegion getTexture() {
        return thread;
    }

    public void dispose() {  
        atlas.dispose();
        thread.getTexture().dispose();
    }
}
