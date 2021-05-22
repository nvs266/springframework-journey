package sonng.dev.helloworld.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import sonng.dev.helloworld.model.Greeting
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    private val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam("name", defaultValue = "World") name: String): Greeting {
        return Greeting(id = counter.getAndIncrement(), content = "Hello $name")
    }
}