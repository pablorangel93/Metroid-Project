package objetosMapas;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.math.Rectangle;
import screens.PlayScreen;


/**
 * Created by brentaureli on 8/28/15.
 */
public class Limites extends InteractiveTileObject {
    public Limites(PlayScreen screen, MapObject object){
        super(screen, object);
        fixture.setUserData(this);
      //  setCategoryFilter(MarioBros.BRICK_BIT);
    }

 
}
