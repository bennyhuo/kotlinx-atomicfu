package kotlinx.atomicfu.transformer

import org.junit.Test
import java.io.File

/**
 * Created by benny.
 */
class AtomicFUTransformerJSTest {

    fun doTest() {
        val transformer = AtomicFUTransformer(
            emptyList(),
            File("atomicfu-testdata/build/classes/kotlin/main"),
            File("atomicfu-testdata/build/atomicFU/"),
        )
        transformer.transform()
    }

    @Test
    fun test() {
        println("Hello")
    }
}