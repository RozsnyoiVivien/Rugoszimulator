package hu.csanyzeg.master.Demos.FlappyBird;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class FlappyScreen extends MyScreen {
    public FlappyScreen(MyGame game) {
        super(game);
    }

    @Override
    public AssetList getAssetList() {
        AssetList assetList = new AssetList();
        AssetList.collectAssetDescriptor(FlappyStage.class, assetList);
        return assetList;
    }

    @Override
    protected void afterAssetsLoaded() {
        addStage(new FlappyStage(game),1,true);
    }

    @Override
    public void init() {

    }
}