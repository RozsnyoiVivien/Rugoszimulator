package hu.csanyzeg.master.Demos.Box2dHelper;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.Box2DWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.MyFixtureDef;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ShapeType;

public class BallActor extends OneSpriteStaticActor {
    public static final String ballTexture = "box2dhelper/ball.png";

    public static AssetList assetList = new AssetList();
    static {
        assetList.addTexture(ballTexture);
    }

    public BallActor(MyGame game, World world, float x, float y, float r) {
        super(game, ballTexture);
        setSize(1,1);
        setPosition(x,y);
        setSize(r,r);
        setRotation(180);
        setActorWorldHelper(new Box2DWorldHelper(world, this, ShapeType.Circle, new MyFixtureDef(0.2f, 0.7f, 5f, false), BodyDef.BodyType.DynamicBody));
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Vector2 v = new Vector2(-x + getOriginX(),-y + getOriginY());
                System.out.println(v);
                v.rotate(getRotation());
                System.out.println(v);
                v.scl(5000f);
                ((Body)getActorWorldHelper().getBody()).applyForceToCenter(v,true);
            }
        });
    }
}
