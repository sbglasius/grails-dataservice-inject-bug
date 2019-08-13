package test

import java.time.LocalDateTime

class Recorder {
    Test test
    LocalDateTime recorded
    static constraints = {
        test nullable: false
        recorded nullable: false
    }
}
