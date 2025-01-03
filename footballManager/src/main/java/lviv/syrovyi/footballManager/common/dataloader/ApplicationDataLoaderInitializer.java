package lviv.syrovyi.footballManager.common.dataloader;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

public interface ApplicationDataLoaderInitializer extends ApplicationListener<ApplicationReadyEvent> {

    boolean isInitialized();

}
