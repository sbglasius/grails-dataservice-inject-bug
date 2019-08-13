
import org.grails.events.bus.ExecutorEventBus

import java.util.concurrent.Executors

// Place your Spring DSL code here
beans = {
    grailsEventBus(ExecutorEventBus, Executors.newFixedThreadPool(5))

}
