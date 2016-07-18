

/**
 * Created by Adriano on 11/07/16.
 */

import com.google.common.collect.Sets;
import lu.intech.Billetterie.api.OffresREST;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("/")
public class ApplicationContext extends Application  {

    @Override
    public Set<Class<?>> getClasses() {
        return Sets.newHashSet( OffresREST.class);
    }

}
