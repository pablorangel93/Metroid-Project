package objetosMapas;

import com.badlogic.gdx.maps.MapObject;
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
